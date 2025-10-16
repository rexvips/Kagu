from __future__ import annotations
from dataclasses import dataclass
from typing import Callable, Generic, Iterable, Iterator, Optional, TypeVar

T = TypeVar("T")


@dataclass
class _Node(Generic[T]):
    key: T
    left: Optional["_Node[T]"] = None
    right: Optional["_Node[T]"] = None


class BinarySearchTree(Generic[T]):
    """Unbalanced binary search tree with insert, search, delete, traversal."""

    __slots__ = ("_root", "_size", "_cmp")

    def __init__(self, initial: Optional[Iterable[T]] = None, key: Optional[Callable[[T], T]] = None) -> None:
        self._root: Optional[_Node[T]] = None
        self._size: int = 0
        # key is used to transform values for comparison; default is identity
        self._cmp: Callable[[T], T] = key if key is not None else (lambda x: x)
        if initial is not None:
            for item in initial:
                self.insert(item)

    def __len__(self) -> int:
        return self._size

    def __iter__(self) -> Iterator[T]:
        yield from self.inorder()

    def __repr__(self) -> str:
        return f"BinarySearchTree([{', '.join(repr(x) for x in self)}])"

    def insert(self, value: T) -> None:
        def _insert(node: Optional[_Node[T]], value: T) -> _Node[T]:
            if node is None:
                self._size += 1
                return _Node(value)
            if self._cmp(value) < self._cmp(node.key):
                node.left = _insert(node.left, value)
            elif self._cmp(value) > self._cmp(node.key):
                node.right = _insert(node.right, value)
            # ignore duplicates
            return node

        self._root = _insert(self._root, value)

    def contains(self, value: T) -> bool:
        node = self._root
        while node is not None:
            if self._cmp(value) == self._cmp(node.key):
                return True
            if self._cmp(value) < self._cmp(node.key):
                node = node.left
            else:
                node = node.right
        return False

    def remove(self, value: T) -> bool:
        removed = False

        def _remove(node: Optional[_Node[T]], value: T) -> Optional[_Node[T]]:
            nonlocal removed
            if node is None:
                return None
            if self._cmp(value) < self._cmp(node.key):
                node.left = _remove(node.left, value)
            elif self._cmp(value) > self._cmp(node.key):
                node.right = _remove(node.right, value)
            else:
                removed = True
                if node.left is None:
                    return node.right
                if node.right is None:
                    return node.left
                # replace with inorder successor
                succ_parent = node
                succ = node.right
                while succ.left is not None:
                    succ_parent = succ
                    succ = succ.left
                node.key = succ.key
                if succ_parent.left is succ:
                    succ_parent.left = succ.right
                else:
                    succ_parent.right = succ.right
            return node

        self._root = _remove(self._root, value)
        if removed:
            self._size -= 1
        return removed

    def inorder(self) -> Iterator[T]:
        def _in(node: Optional[_Node[T]]):
            if node is not None:
                yield from _in(node.left)
                yield node.key
                yield from _in(node.right)

        yield from _in(self._root)

    def preorder(self) -> Iterator[T]:
        def _pre(node: Optional[_Node[T]]):
            if node is not None:
                yield node.key
                yield from _pre(node.left)
                yield from _pre(node.right)

        yield from _pre(self._root)

    def postorder(self) -> Iterator[T]:
        def _post(node: Optional[_Node[T]]):
            if node is not None:
                yield from _post(node.left)
                yield from _post(node.right)
                yield node.key

        yield from _post(self._root)

    def clear(self) -> None:
        self._root = None
        self._size = 0
