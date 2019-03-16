
public class myList<E> {
    private LinkNode<E> tail;
    private LinkNode<E> head;
    public LinkNode<E> curr;
    private int size;


    public myList(){
        head=tail=new LinkNode<>(null);
        size=0;
    }

    public void append(E element) {
        tail.setNext(new LinkNode<E>(element,tail.next()));
        size++;
    }

    public int size(){
        return size;
    }

    public E getElement(int pos){
        moveToPos(pos);
        if (curr.next()==null) return null;
        return curr.next().element();
    }
    private void moveToPos(int pos){
        curr = head;
        for (int i=0; i<pos;i++) curr=curr.next();
    }
}
