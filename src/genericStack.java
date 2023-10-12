import java.util.EmptyStackException;

public class genericStack <T>{
    node<T> top;
    genericStack(){
        this.top = null;
    }

    public void push(T item) {
        node<T> nn = new node<>(item);
        nn.setNext(top);
        top = nn;
    }

    public T pop() {
        T item = top.getData();
        top = top.getNext();
        return item;
    }
    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        int size = 0;
        node<T> current = top;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }
}
