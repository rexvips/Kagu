from __future__ import annotations
from typing import Generic, Iterable, Iterator, List, Optional, TypeVar

T = TypeVar("T")


class Stack(Generic[T]):
    """A simple LIFO stack built on top of Python list.

    Provides O(1) amortized push/pop and peek operations.
    """

    __slots__ = ("_data",)

    def __init__(self, initial: Optional[Iterable[T]] = None) -> None:
        self._data: List[T] = []
        if initial is not None:
            for item in initial:
                self.push(item)

    def __len__(self) -> int:
        return len(self._data)

    def __iter__(self) -> Iterator[T]:
        # iterate from bottom to top
        return iter(self._data)

    def __repr__(self) -> str:
        return f"Stack([{', '.join(repr(x) for x in self)}])"

    def push(self, value: T) -> None:
        self._data.append(value)

    def pop(self) -> T:
        if not self._data:
            raise IndexError("pop from empty Stack")
        return self._data.pop()

    def peek(self) -> T:
        if not self._data:
            raise IndexError("peek from empty Stack")
        return self._data[-1]

    def clear(self) -> None:
        self._data.clear()
