package com.task3;

class Node<E> {
    private E element;
    private Node<E> nextNode = null;

    Node(E element) {
        this.element = element;
    }

    E getElement() {
        return element;
    }

    void setElement(E element) {
        this.element = element;
    }

    Node<E> getNextNode() {
        return nextNode;
    }

    void setNextNode(Node<E> nextNode) {
        this.nextNode = nextNode;
    }
}
