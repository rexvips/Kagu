"""DSA package exposing common data structures and interview questions.

Subpackages:
- array: Dynamic array implementation
- list: Singly linked list implementation
- stack: Stack implementation
- queue: Queue implementation
- tree: Binary Search Tree implementation

Usage:
from DSA.array import DynamicArray
from DSA.list import SinglyLinkedList
from DSA.stack import Stack
from DSA.queue import CircularQueue
from DSA.tree import BinarySearchTree
from DSA.questions import Questions
"""

from .array.dynamic_array import DynamicArray
from .list.singly_linked_list import SinglyLinkedList
from .stack.stack import Stack
from .queue.circular_queue import CircularQueue
from .tree.binary_search_tree import BinarySearchTree
from .questions import Questions

__all__ = [
    "DynamicArray",
    "SinglyLinkedList",
    "Stack",
    "CircularQueue",
    "BinarySearchTree",
    "Questions",
]
