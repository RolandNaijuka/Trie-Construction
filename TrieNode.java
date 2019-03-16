
public class TrieNode<E> {
	//private int key;
	private E element;
	private TrieNode<E> right, left;
	
	public TrieNode(E element, TrieNode<E> left, TrieNode<E> right) {
		this.element=element;
		//this.key=key;
		this.right=right;
		this.left=left;
	}
	public TrieNode() {this.right=this.left=null;}
	
	
	/*public int key() {
		return this.key;
	}*/
	
	public E element() {
		return this.element;
	}
	
	public void setElement(E element) {
		this.element=element;
	}
	
	public TrieNode<E> left(){
		return this.left;
	}
	
	public TrieNode<E> right(){
		return this.right;
	}
	
	public void setLeft(TrieNode<E> left){
		this.left=left;
	}
	
	public void setRight(TrieNode<E> right){
		this.right = right;
	}
	
	
	public boolean isLeaf() {
		return (this.right==null&&this.left==null);
	}
}
