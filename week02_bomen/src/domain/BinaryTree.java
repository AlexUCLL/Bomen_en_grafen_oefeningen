package domain;

public class BinaryTree<E> {
	private E data;
	private BinaryTree<E> leftTree, rightTree;
	
	public BinaryTree(E data){
		this(data,null,null);
	}
	
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
		if (data == null) {
			throw new IllegalArgumentException();
		}
		this.data= data;
		this.leftTree= leftTree;
		this.rightTree= rightTree;
	}
	
	public void printPreorder(){
			System.out.print(this.data + " ");
			if (this.leftTree != null) this.leftTree.printPreorder();
			if (this.rightTree != null) this.rightTree.printPreorder();
	}
	public void printInOrder(){
		if(this.leftTree!= null) this.leftTree.printInOrder();
		System.out.print(this.data + " ");
		if (this.rightTree != null) this.rightTree.printInOrder();
	}
	public void printPostorder(){
		if(this.leftTree != null) this.leftTree.printPostorder();
		if(this.rightTree != null) this. rightTree.printPostorder();
		System.out.print(this.data + " ");
	}

}
