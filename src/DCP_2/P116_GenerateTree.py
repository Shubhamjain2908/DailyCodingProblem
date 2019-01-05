'''
    Google
    Generate a finite, but an arbitrarily large binary tree quickly in O(1).
    That is, generate() should return a tree whose size is unbounded but finite.
'''

import random
from random import randint

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def generate():
    root = Node(randint(0, 9))

    if random.random() < 0.5:
        root.left = generate()
    if random.random() < 0.5:
        root.right = generate()

    return root

def inorderTraversal(root):
        res = []
        if root:
            res = inorderTraversal(root.left) 
            res.append(root.val)
            res = res + inorderTraversal(root.right)
        return res

root = generate()
print(inorderTraversal(root))