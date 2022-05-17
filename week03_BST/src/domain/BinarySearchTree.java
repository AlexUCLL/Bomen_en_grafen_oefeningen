package domain;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	public BinarySearchTree(E data, BinarySearchTree<E> leftTree, BinarySearchTree<E> rightTree) {
		super(data, leftTree, rightTree);
	}
			
	public BinarySearchTree(E data) {
		super(data);
	}

	public boolean lookup(E data) {
		if(data.compareTo(this.data) == 0){
			return true;
		}
		if(data.compareTo(this.data)>0){
			if(this.rightTree == null){return false;}
			return this.rightTree.lookup(data);
		}
		if(data.compareTo(this.data)<0){
			if(this.leftTree == null){return false;}
			return this.leftTree.lookup(data);
		}
		return true;

	}

	public boolean addNode(E data) {
		if(data.compareTo(this.data)==0) {
			throw new IllegalArgumentException("");
		}
		if(data.compareTo(this.data)>0){
			if(this.rightTree==null){
				this.rightTree = new BinarySearchTree<>(data);
			}else {
				this.rightTree.addNode(data);
			}
		}
		if (data.compareTo(this.data)<0){
			if(this.leftTree == null){
				this.leftTree = new BinarySearchTree<>(data);
			}else {
				this.leftTree.addNode(data);
			}
		}
		return false;
	}
	public void cleanUp() {
		if (this.data != null) {
			if (this.leftTree != null) {
				if (this.leftTree.data == null) {
					this.leftTree = null;
				} else {
					this.leftTree.cleanUp();
				}
			}
			if (this.rightTree != null) {
				if (this.rightTree.data == null) {
					this.rightTree = null;
				} else {
					this.rightTree.cleanUp();
				}
			}
		}
	}

	public boolean removeNode(E data) {
		if (data == null) {
			throw new IllegalArgumentException();
		}
		if (this.data == null) {
			return false;
		}
		if (this.data.compareTo(data) == 0) {//data gevonden
			if (this.isLeaf()) {
				this.data = null;
				return true;
			} else {
				if (this.leftTree != null) {
					E grootsteLinks = this.leftTree.searchGreatest();
					this.data = grootsteLinks;
					boolean verwijderenGelukt = this.leftTree.removeNode(grootsteLinks);
					if (verwijderenGelukt) {
						this.leftTree.cleanUp();
					}
					return verwijderenGelukt;
				} else{
					E kleinsteRechts = this.rightTree.searchGreatest();
					this.data = kleinsteRechts;
					boolean verwijderenGelukt = this.rightTree.removeNode(kleinsteRechts);
					if (verwijderenGelukt) {
						this.rightTree.cleanUp();
					}
					return verwijderenGelukt;
				}
			}
		} else {
			if (this.data.compareTo(data) > 0) {//zoek in linkerboom
				return (this.leftTree == null ? false : this.leftTree.removeNode(data));
			} else {//zoek in rechterboom
				return (this.rightTree == null ? false : this.rightTree.removeNode(data));
			}
		}
	}

	public E searchSmallest(){
		if(this.leftTree == null){
			return this.data;
		}return this.leftTree.searchSmallest();
	}

	public E searchGreatest(){
		if(this.rightTree == null){
			return this.data;
		}return this.rightTree.searchGreatest();
	}
}


