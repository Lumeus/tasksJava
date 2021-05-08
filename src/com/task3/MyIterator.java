package com.task3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator<E> implements Iterator<E> {
    private final MyLinkedList<E> list;
    private Node<E> prevNode = null;
    private Node<E> currentNode = null;
    private Node<E> nextNode;
    private boolean removeErrorFlag = true;

    MyIterator(MyLinkedList<E> list, Node<E> nextNode) {
        this.list = list;
        this.nextNode = nextNode;
    }

    @Override
    public boolean hasNext() {
        return nextNode != null;
    }

    @Override
    public E next() {
        if (nextNode == null) { throw new NoSuchElementException(); }
        prevNode = currentNode;
        currentNode = nextNode;
        nextNode = currentNode.getNextNode();
        removeErrorFlag = false;
        return currentNode.getElement();
    }

    @Override
    public void remove() {
        if (removeErrorFlag) { throw new IllegalStateException(); }
        if (prevNode == null) {
            list.first = nextNode;
        }
        else {
            prevNode.setNextNode(nextNode);
        }
        currentNode.setElement(null);
        currentNode.setNextNode(null);
        currentNode = prevNode;
        prevNode = null;
        list.size--;
        removeErrorFlag = true;
    }
}
