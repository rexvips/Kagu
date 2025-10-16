from __future__ import annotations
from typing import Generic, Iterable, Iterator, List, Optional, TypeVar

T = TypeVar("T")


class CircularQueue(Generic[T]):
    """Circular queue with dynamic resizing.

    Enqueue and dequeue are O(1) amortized.
    """

    __slots__ = ("_data", "_head", "_tail", "_size")

    def __init__(self, initial: Optional[Iterable[T]] = None, capacity: int = 8) -> None:
        if capacity <= 0:
            raise ValueError("capacity must be positive")
        self._data: List[Optional[T]] = [None] * capacity
        self._head: int = 0
        self._tail: int = 0
        self._size: int = 0
        if initial is not None:
            for item in initial:
                self.enqueue(item)

    def __len__(self) -> int:
        return self._size

    def __iter__(self) -> Iterator[T]:
        for i in range(self._size):
            yield self._data[(self._head + i) % len(self._data)]  # type: ignore[misc]

    def __repr__(self) -> str:
        return f"CircularQueue([{', '.join(repr(x) for x in self)}])"

    def _resize(self, new_capacity: int) -> None:
        old_data = list(self)
        self._data = [None] * new_capacity
        self._head = 0
        self._tail = 0
        self._size = 0
        for item in old_data:
            self.enqueue(item)

    def enqueue(self, value: T) -> None:
        if self._size == len(self._data):
            self._resize(len(self._data) * 2)
        self._data[self._tail] = value
        self._tail = (self._tail + 1) % len(self._data)
        self._size += 1

    def dequeue(self) -> T:
        if self._size == 0:
            raise IndexError("dequeue from empty CircularQueue")
        value = self._data[self._head]
        self._data[self._head] = None
        self._head = (self._head + 1) % len(self._data)
        self._size -= 1
        # shrink if quarter-full
        if 0 < self._size <= len(self._data) // 4 and len(self._data) > 8:
            self._resize(max(8, len(self._data) // 2))
        return value  # type: ignore[misc]

    def peek(self) -> T:
        if self._size == 0:
            raise IndexError("peek from empty CircularQueue")
        return self._data[self._head]  # type: ignore[misc]

    def clear(self) -> None:
        self._data = [None] * max(8, len(self._data))
        self._head = self._tail = self._size = 0
