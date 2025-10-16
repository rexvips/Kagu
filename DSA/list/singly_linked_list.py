from __future__ import annotations
from dataclasses import dataclass
from typing import Generic, Iterable, Iterator, Optional, TypeVar

T = TypeVar("T")


@dataclass
class _Node(Generic[T]):
    value: T
    next: Optional["_Node[T]"] = None


class SinglyLinkedList(Generic[T]):
    """A straightforward singly linked list with head/tail tracking."""

    __slots__ = ("_head", "_tail", "_size")

    def __init__(self, initial: Optional[Iterable[T]] = None) -> None:
        self._head: Optional[_Node[T]] = None
        self._tail: Optional[_Node[T]] = None
        self._size: int = 0
        if initial is not None:
            for item in initial:
                self.append(item)

    def __len__(self) -> int:
        return self._size

    def __iter__(self) -> Iterator[T]:
        current = self._head
        while current is not None:
            yield current.value
            current = current.next

    def __repr__(self) -> str:
        return f"SinglyLinkedList([{', '.join(repr(x) for x in self)}])"

    def append(self, value: T) -> None:
        node = _Node(value)
        if self._tail is None:
            self._head = self._tail = node
        else:
            self._tail.next = node
            self._tail = node
        self._size += 1

    def prepend(self, value: T) -> None:
        node = _Node(value, next=self._head)
        self._head = node
        if self._tail is None:
            self._tail = node
        self._size += 1

    def pop_first(self) -> T:
        if self._head is None:
            raise IndexError("pop from empty list")
        node = self._head
        self._head = node.next
        if self._head is None:
            self._tail = None
        self._size -= 1
        return node.value

    def pop_last(self) -> T:
        if self._head is None:
            raise IndexError("pop from empty list")
        if self._head.next is None:
            value = self._head.value
            self._head = self._tail = None
            self._size = 0
            return value
        # find penultimate
        prev = self._head
        current = self._head.next
        while current.next is not None:
            prev = current
            current = current.next
        prev.next = None
        self._tail = prev
        self._size -= 1
        return current.value

    def find(self, value: T) -> Optional[int]:
        idx = 0
        for v in self:
            if v == value:
                return idx
            idx += 1
        return None

    def remove(self, value: T) -> bool:
        prev: Optional[_Node[T]] = None
        current = self._head
        while current is not None:
            if current.value == value:
                if prev is None:
                    self._head = current.next
                    if self._head is None:
                        self._tail = None
                else:
                    prev.next = current.next
                    if prev.next is None:
                        self._tail = prev
                self._size -= 1
                return True
            prev = current
            current = current.next
        return False

    def clear(self) -> None:
        self._head = self._tail = None
        self._size = 0
