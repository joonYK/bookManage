package kr.jy.book.dataStructure;

public class myLinkedList<E>{
    private Node<E> firstNode;
    private Node<E> lastNode;

    private int size = 0;

    /**
     * 노드 추가
     * @param item
     */
    public void add(E item) {
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
        for(int i = 0; i < i; i++) {
            node = node.nextNode;
        }

        return node.item;
    }

    /**
     * 노드 삭제
     * @param item
     * @return
     */
    public boolean remove(E item) {
        if(size == 0)
            return false;

        Node<E> node = firstNode;

        for(int i = 0; i < size; i++) {
            if(node.item == item || node.item.equals(item)) {
                node.prevNode.nextNode = node.nextNode;
                node.nextNode.prevNode = node.prevNode;
                node.prevNode = null;
                node.nextNode = null;

                size--;
                return true;
            }
            node = node.nextNode;
        }

        return false;
    }

    /**
     * 노드 삭제
     * @param index
     * @return
     */
    public boolean remove(int index) {
        if(size < index)
            return false;

        Node<E> node = firstNode;

        for(int i = 0; i < index; i++) {
            node = node.nextNode;
        }

        node.prevNode.nextNode = node.nextNode;
        node.nextNode.prevNode = node.prevNode;
        node.prevNode = null;
        node.nextNode = null;

        size--;

        return true;

    }

}

class Node<E> {
    E item;
    Node<E> nextNode;
    Node<E> prevNode;

    Node(E item) {
        this.item = item;
    }
}
