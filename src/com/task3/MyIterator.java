package com.task3;

import java.util.Iterator;

public class MyIterator<E> implements Iterator<E> {
    private MyLinkedList<E> list;
    private Node<E> prevNode = null;
    private Node<E> currentNode = null;
    private Node<E> nextNode;
    private boolean removeErrorFlag = true;

    public MyIterator(MyLinkedList<E> list, Node<E> nextNode) {
        this.list = list;
        this.nextNode = nextNode;
    }

    @Override
    public boolean hasNext() {
        return nextNode != null;
    }

    @Override
    public E next() {
        prevNode = currentNode;
        currentNode = nextNode;
        nextNode = currentNode.getNextNode();
        removeErrorFlag = false;
        return currentNode.getElement();
    }

    @Override
    public void remove() {
        if (removeErrorFlag) { throw new IllegalStateException(); }
        currentNode.setElement(null);
        currentNode = prevNode;
        prevNode = null;
        currentNode.setNextNode(nextNode);
    }
}
