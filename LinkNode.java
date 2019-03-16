

public class LinkNode<E> {
    private LinkNode<E> next;
    private E element;

    public LinkNode(LinkNode<E> next){
        this.element=null;
        this.next=next;
    }
    public LinkNode(E element, LinkNode<E> next){
        this.next=next;
        this.element=element;
    }

    public LinkNode<E> next(){
        return this.next;
    }
    public void setNext(LinkNode<E> next){
        this.next=next;
    }

    public E element(){
        return this.element;
    }
    public void setElement(E element){
        this.element=element;
    }
}
