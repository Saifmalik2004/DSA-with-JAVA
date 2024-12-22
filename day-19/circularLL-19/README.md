# Circular Linked List

![Circular Linked List Visualization](https://images.javatpoint.com/ds/images/circular-singly-linked-list.png)

*Image Source: Wikipedia*

---

## Introduction

A **circular linked list** is a variation of the linked list where the last node points back to the first node, forming a circle. Unlike singly or doubly linked lists, a circular linked list does not have a `NULL` value for the `next` pointer in its last node.

Key characteristics of a circular linked list:  
- The **last node** connects back to the **first node**.  
- Traversal can begin at any node and continues in a loop.  
- It can be **singly circular** (each node has a `next` pointer) or **doubly circular** (each node has `next` and `prev` pointers).

---

## How to Initialize

A circular linked list is initialized by creating a single node where:  
1. The `data` is assigned a value.  
2. The `next` pointer references itself, completing the circle.

Example:  
```java
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = this; // Pointing to itself
    }
}

Node head = new Node(10); // Initialize circular linked list with one node
```

---

## Operations in Circular Linked List

In this section, we will discuss the following operations and their functionalities:

### 1. Add First
Adds a new node at the beginning of the list.  
- The new node's `next` pointer is updated to point to the current head.  
- The last node's `next` pointer is updated to point to the new node.  
- The new node becomes the head of the list.

---

### 2. Add Last
Appends a new node at the end of the list.  
- The new node's `next` pointer is updated to point to the current head.  
- The current last node's `next` pointer is updated to the new node.  
- The new node becomes the last node of the list.

---

### 3. Remove First
Removes the first node of the list.  
- The last node's `next` pointer is updated to point to the second node.  
- The second node becomes the new head of the list.

---

### 4. Remove Last
Deletes the last node of the list.  
- Traverse to the second-to-last node.  
- Update its `next` pointer to point to the head, removing the reference to the last node.

---

### 5. Search
Finds a node with a specific value.  
- Traverse the list starting from the head.  
- Check each node's `data` field for a match.  
- Stop the search when the desired node is found or after one complete loop.

---

## Where to Find the Solutions

You can find the implementation of these operations (`add first`, `add last`, `remove first`, `remove last`, and `search`) in their respective files within this directory. Each file contains detailed explanations and code examples to help you understand the functionality better.