package algorithm;


public class MyLinkedList<T> {

    private Integer size;

    private Node<T> header;

    private Node<T> tail;

    public MyLinkedList() {
        this.size = 0;
        this.header = new Node<T>(null, null, null);
        this.tail = new Node<T>(header, null, null);
        header.setNext(tail);
    }

    public void add(T data) {
        Node<T> newNode = new Node(data);
        tail.getPre().setNext(newNode);
        newNode.setPre(tail.getPre());
        newNode.setNext(tail);
        tail.setPre(newNode);
        size++;
    }

    public boolean isEmpty() {
        return size.equals(0);
    }

    public T get(Integer index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node current = header;
        for (int i = 0; i <= index; i++) {
            current = current.getNext();
        }
        return (T) current.getData();
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = header.getNext();
        while (current.getNext() != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.print();
        System.out.println();
        System.out.println(list.size);
    }
}
