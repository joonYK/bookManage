package kr.jy.book.dataStructure;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

public class MyLinkedList<E> implements Serializable {
    private Node<E> firstNode;
    private Node<E> lastNode;

    private int size = 0;


    /**
     * 노드 추가
     * @param item
     */
    public boolean add(E item) {
        Node<E> node = new Node<E>(item);

        if(firstNode == null)
            firstNode = node;

        if(lastNode == null) {
            lastNode = node;
        } else {
            node.prevNode = lastNode;
            lastNode.nextNode = node;
            lastNode = node;
        }

        size++;
        return true;
    }


    public void add(int index, E element) {
        if(index < size) {
            return;
        }

        Node<E> newNode = new Node<>(element);
        Node<E> node = firstNode;

        for(int i=0; i<index; i++) {
            node = node.nextNode;
        }

        newNode.prevNode = node;
        newNode.nextNode = node.nextNode;
        node.nextNode = newNode;
        node.nextNode.prevNode = node;

        size++;
    }

    /**
     * 노드 조회
     * @param index
     * @return
     */
    public E get(int index) {
        if(index > size)
            return null;

        Node<E> node = firstNode;
        for(int i = 0; i < index; i++) {
            node = node.nextNode;
        }

        return node.item;
    }

    /**
     * 노드 삭제
     * @param o
     * @return
     */
    public boolean remove(Object o) {
        if(size == 0)
            return false;

        for(Node<E> node = firstNode; node != null; node = node.nextNode) {
            if(node.item == o || node.item.equals(o)) {

                if(node.prevNode == null)
                    firstNode = node.nextNode;
                else
                    node.prevNode.nextNode = node.nextNode;

                if(node.nextNode == null)
                    lastNode = node.prevNode;
                else
                    node.nextNode.prevNode = node.prevNode;

                node.prevNode = null;
                node.nextNode = null;

                size--;
                return true;
            }
        }

        return false;
    }

    /**
     * 노드 삭제
     * @param index
     * @return
     */
    public E remove(int index) {
        if(size < index || isEmpty())
            return null;

        Node<E> node = firstNode;

        for(int i = 0; i < index; i++) {
            node = node.nextNode;
        }

        node.prevNode.nextNode = node.nextNode;
        node.nextNode.prevNode = node.prevNode;
        node.prevNode = null;
        node.nextNode = null;
        size--;

        return node.item;

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Node<E> next = null;
        for(Node<E> node = firstNode; node != null; ) {
            next = node.nextNode;
            node.item = null;
            node.prevNode = null;
            node.nextNode = null;
            node = next;
        }

        firstNode = null;
        lastNode = null;
        size = 0;
    }


    public boolean contains(Object o) {
        if(indexOf(o) > -1)
            return true;

        return false;
    }

    public Object[] toArray() {
        if(size == 0)
            return new Object[0];

        Object[] arr = new Object[size];
        Node<E> node = firstNode;

        for(int i=0; i<size; i++) {
            arr[i] = node.item;
            node = node.nextNode;
        }

        return arr;
    }

    public boolean addAll(Collection<? extends E> c) {
        addAll(size, c);
        return true;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        Object[] arr = c.toArray();
        if(arr.length == 0)
            return false;

        if(index > size)
            index = size;

        Node<E> addFirst = null;
        Node<E> addLast = null;

        for(Object o : arr) {
            Node<E> node = new Node<E>((E)o);
            if(addFirst == null) {
                addFirst = node;
                addLast = node;
                continue;
            }

            addLast.nextNode = node;
            node.prevNode = addLast;
            addLast = node;
        }

        Node<E> node = firstNode;

        //firstNode가 없는경우 (하나도 없는경우)
        if(node == null) {
            firstNode = addFirst;
            lastNode = addLast;
            return true;

        //첫번째에 넣는경우
        } else if(index == 0) {
            firstNode = addFirst;
            addLast.nextNode = node;
            node.prevNode = addLast;
            return true;

        //마지막에 넣는경우
        } else if(index == size) {
            lastNode.nextNode = addFirst;
            lastNode = addLast;

        //중간에 넣는경우
        } else {
            for(int i=0; i<index; i++) {
                node = node.nextNode;
            }
            node.prevNode.nextNode = addFirst;
            node.prevNode = addLast;
        }

        size += arr.length;

        return true;
    }

    public int indexOf(Object o) {
        if(size == 0)
            return -1;

        Node<E> node = firstNode;
        for(int i = 0; i < size; i++) {
            if(node.item == o || o.equals(node.item))
                return i;

            node = node.nextNode;
        }

        return -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node<E> node = firstNode;

        while(node != null) {
            if(sb.length() == 0)
                sb.append(node.item);
            else
                sb.append(", " + node.item);

            node = node.nextNode;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
            MyLinkedList<String> mll = new MyLinkedList<String>();
            mll.add("a");
            mll.add("b");
            mll.add("c");
            mll.add("d");

            LinkedList<String> ll = new LinkedList<String>();
            ll.add("e");
            ll.add("f");
            ll.add("g");

            mll.addAll(ll);

        System.out.println(mll);


    }


}

class Node<E> implements Serializable{
    E item;
    Node<E> nextNode;
    Node<E> prevNode;

    Node(E item) {
        this.item = item;
    }
}