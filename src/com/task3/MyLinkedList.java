package com.task3;

import java.util.Iterator;

public class MyLinkedList<E> implements ILinkedList<E> {
    Node<E> first = null;
    Node<E> last = null;
    int size = 0;

    public MyLinkedList(){}

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>(this, first);
    }

    @Override
    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (first == null) {
            first = newNode;
        } else {
            last.setNextNode(newNode);
        }
        last = newNode;
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException();
        Node<E> newNode = new Node<>(element);
        Node<E> prevNode = first;
        Node<E> nextNode;
        for (int i = 0; i < index - 1; i++) {
            prevNode = prevNode.getNextNode();

        }
        nextNode = prevNode.getNextNode();
        prevNode.setNextNode(newNode);
        newNode.setNextNode(nextNode);
        size++;
    }

    @Override
    public void clear() {
        size = 0;
        while (first != null){
            first.setElement(null);
            last = first.getNextNode();
            first.setNextNode(null);
            first = last;
        }
    }

    @Override
    public E get(int index) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException();
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNextNode();
        }
        return node.getElement();
    }

    @Override
    public int indexOf(E element) {
        int res = 0;
        Node<E> node = first;
        while (node != null) {
            if (node.getElement() == element) {
                return res;
            }
            node = node.getNextNode();
            res++;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException();
        Node<E> prevNode = first;
        Node<E> nextNode;
        for (int i = 0; i < index - 1; i++) {
            prevNode = prevNode.getNextNode();
        }
        nextNode = prevNode.getNextNode();
        E res = nextNode.getElement();
        nextNode.setElement(null);
        nextNode = nextNode.getNextNode();
        prevNode.getNextNode().setNextNode(null);
        prevNode.setNextNode(nextNode);
        size--;
        return res;
    }

    @Override
    public E set(int index, E element) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException();
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNextNode();
        }
        E res = node.getElement();
        node.setElement(element);
        return res;
    }

    @Override
    public int size() {
        return size;
    }

//////////////////////////////////////////////////////////////////////////////////////
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }
//////////////////////////////////////////////////////////////////////////////////////

    @Override
    public String toString() {
        if (size == 0) {
            return "{ }";
        } else {
            StringBuilder res = new StringBuilder("{");
            Node<E> node = first;
            res.append(node.getElement());
            node = node.getNextNode();
            while (node != null) {
                res.append(", ");
                res.append(node.getElement());
                node = node.getNextNode();
            }
            res.append("}");
            return res.toString();
        }
    }
}
