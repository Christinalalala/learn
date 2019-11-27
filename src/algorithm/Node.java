package algorithm;

public class Node<T> {
    private Node pre;
    private Node next;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public Node(Node pre, Node next, T data) {
        this.pre = pre;
        this.next = next;
        this.data = data;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
