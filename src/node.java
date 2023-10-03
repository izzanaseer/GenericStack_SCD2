public class node <T>{
    private T data;
    private node<T> next;

    public node(T data){
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public node<T> getNext() {
        return next;
    }

    public void setNext(node<T> next) {
        this.next = next;
    }
}
