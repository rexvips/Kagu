from __future__ import annotations
from typing import Generic, Iterable, Iterator, List, Optional, TypeVar

T = TypeVar("T")


class DynamicArray(Generic[T]):
    """A simple dynamic array with manual resizing, similar to Python's list.

    Provides amortized O(1) append and pop operations, O(1) random access,
    and O(n) insert/remove at arbitrary positions.
    """

    __slots__ = ("_size", "_capacity", "_data")

    def __init__(self, initial: Optional[Iterable[T]] = None, capacity: int = 4) -> None:
        if capacity <= 0:
            raise ValueError("capacity must be positive")
        self._size: int = 0
        self._capacity: int = max(capacity, 4)
        self._data: List[Optional[T]] = [None] * self._capacity
        if initial is not None:
            for item in initial:
                self.append(item)

    def __len__(self) -> int:
        return self._size

    def __iter__(self) -> Iterator[T]:
        for i in range(self._size):
            yield self._data[i]  # type: ignore[misc]

    def __repr__(self) -> str:
        return f"DynamicArray([{', '.join(repr(x) for x in self)}])"

    def _resize(self, new_capacity: int) -> None:
        if new_capacity < self._size:
            raise ValueError("new_capacity cannot be less than current size")
        new_data: List[Optional[T]] = [None] * new_capacity
        for i in range(self._size):
            new_data[i] = self._data[i]
        self._data = new_data
        self._capacity = new_capacity

    def _grow(self) -> None:
        self._resize(self._capacity * 2)

    def _shrink(self) -> None:
        # shrink when 1/4 full to avoid thrashing
        if self._capacity > 4 and self._size <= self._capacity // 4:
            self._resize(max(4, self._capacity // 2))

    def append(self, value: T) -> None:
        if self._size == self._capacity:
            self._grow()
        self._data[self._size] = value
        self._size += 1

    def pop(self) -> T:
        if self._size == 0:
            raise IndexError("pop from empty DynamicArray")
        self._size -= 1
        value = self._data[self._size]
        self._data[self._size] = None
        self._shrink()
        return value  # type: ignore[misc]

    def get(self, index: int) -> T:
        self._check_index(index)
        return self._data[index]  # type: ignore[misc]

    def set(self, index: int, value: T) -> None:
        self._check_index(index)
        self._data[index] = value

    def insert(self, index: int, value: T) -> None:
        if index < 0 or index > self._size:
            raise IndexError("insert index out of range")
        if self._size == self._capacity:
            self._grow()
        for i in range(self._size, index, -1):
            self._data[i] = self._data[i - 1]
        self._data[index] = value
        self._size += 1

    def remove_at(self, index: int) -> T:
        self._check_index(index)
        value = self._data[index]
        for i in range(index, self._size - 1):
            self._data[i] = self._data[i + 1]
        self._size -= 1
        self._data[self._size] = None
        self._shrink()
        return value  # type: ignore[misc]

    def clear(self) -> None:
        for i in range(self._size):
            self._data[i] = None
        self._size = 0
        self._shrink()

    def _check_index(self, index: int) -> None:
        if index < 0 or index >= self._size:
            raise IndexError("index out of range")
