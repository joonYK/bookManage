package kr.jy.book.dataStructure;

public class myLinkedList<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;

    // 노드 추가
    public void add(T item) {
        Node<T> node = new Node<T>(item);

        if(firstNode == null) firstNode = node;

        if(lastNode == null) {
            lastNode = node;
        } else {
            lastNode.nextNode = node;
            lastNode = node;
        }
    }


    // 노드 조회
    public T get(int i) {
        return null;
    }

    public T get(T item) {
        return null;
    }

}

class Node<T> {
    T item;
    Node<T> nextNode;

    Node(T item) {
        this.item = item;
    }
}
