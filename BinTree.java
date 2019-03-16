
public class BinTree {
	private int height =0;
	//private int level = 0;
	private int size =0;
	TrieNode<String> root;

	public BinTree() {}

	public boolean insert(String str) {
		int level = 0;
		char[] c = str.toCharArray();
		int keyInsert;

		keyInsert = Integer.parseInt(Character.toString(c[level]));


		if (root == null) {
			root = new TrieNode<>();
			if (keyInsert == 0)
				root.setLeft(new TrieNode<>(str, null, null));
			else
				root.setRight(new TrieNode<>(str, null, null));
			size++;
			height++;
			return true;
		} else if (root!=null){

			TrieNode<String> current = root;
 			if (keyInsert == 0) {

				while (current.element() == null && level < c.length) {
					keyInsert = Integer.parseInt(Character.toString(c[level++]));

					if (keyInsert == 0) {
						if (current.left() == null) {
							current.setLeft(new TrieNode<>(str, null, null));
							size++;
							level++;
							if (height < level+1)
								height = level+1;

							return true;
						}
						current = current.left();
					} else {
						if (current.right() == null) {

							current.setRight(new TrieNode<>(str, null, null));
							size++;
							level++;
							if (height < level+1)
								height = level+1;

							return true;
						}
						current = current.right();
					}


				}
 				keyInsert = Integer.parseInt(Character.toString(c[level]));
 				String temp = current.element();
				char[] tempC = temp.toCharArray();
				int keyCurrent = Integer.parseInt(Character.toString(tempC[level]));

				current.setElement(null);
				while (keyCurrent == keyInsert && level < c.length) {
					if (keyInsert == 0)
						current.left();
					else
						current.right();
					keyInsert = Integer.parseInt(Character.toString(c[level]));
					keyCurrent = Integer.parseInt(Character.toString(tempC[level]));
					level++;
				}

				if (keyInsert == 0 && keyCurrent == 1) {
					current.setLeft(new TrieNode<>(str, null, null));
					current.setRight(new TrieNode<>(temp, null, null));
					size++;
					level++;


					if (height < level+1)
						height = level;

				} else if (keyInsert == 1 && keyCurrent == 0) {
					current.setRight(new TrieNode<>(str, null, null));
					current.setLeft(new TrieNode<>(temp, null, null));
					size++;
					level++;

					if (height < level+1)
						height = level+1;

				}


				return true;
			} else {

				while (current.element() == null && level < c.length) {
					keyInsert = Integer.parseInt(Character.toString(c[level++]));

					if (keyInsert == 0) {
						if (current.left() == null) {
							current.setLeft(new TrieNode<>(str, null, null));
							size++;
							level++;
							if (height < level+1)
								height = level+1;

							return true;
						}
						current = current.left();
					} else {
						if (current.right() == null) {

							current.setRight(new TrieNode<>(str, null, null));
							size++;
							level++;
							if (height < level+1)
								height = level+1;

							return true;
						}
						current = current.right();
					}


				}

				keyInsert = Integer.parseInt(Character.toString(c[level]));

				String temp = current.element();
				char[] tempC = temp.toCharArray();
				int keyCurrent = Integer.parseInt(Character.toString(tempC[level]));
				//System.out.println(keyCurrent);
				//System.out.println(keyInsert);
				current.setElement(null);
				while (keyCurrent == keyInsert && level < c.length) {
					if (keyInsert == 0)
						current.left();
					else
						current.right();
					keyInsert = Integer.parseInt(Character.toString(c[level]));
					keyCurrent = Integer.parseInt(Character.toString(tempC[level]));
					level++;
				}

				if (keyInsert == 0 && keyCurrent == 1) {
					current.setLeft(new TrieNode<>(str, null, null));
					current.setRight(new TrieNode<>(temp, null, null));
					size++;
					level++;
					//System.out.println("reached");
				} else if (keyInsert == 1 && keyCurrent == 0) {
					current.setRight(new TrieNode<>(str, null, null));
					current.setLeft(new TrieNode<>(temp, null, null));
					size++;
					level++;
					//System.out.println("reached");
				}
				if (height < level+1)
					height = level+1;

				return true;
			}

		}
		return false;
	}



	private myList<String> trieToList() {
		myList<String> list = new myList<>();
		inorder(root,list);
		return list;
	}

	private void inorder(TrieNode<String> node, myList<String> list){
		if (node==null) return;
		inorder(node.left(),list);
		if(node.element()!=null)
			list.append(node.element());
		inorder(node.right(),list);
	}

	public void largest() {
		if(root==null) return;
		String k=moveRight(root);
		System.out.println( k);
	}

	private String moveRight(TrieNode<String> node){
		if(node.element()!=null) return node.element();
		if(node.right()==null) return moveRight(node.left());
		return moveRight(node.right());
	}


	public void smallest() {
		if(root==null) return;
		String k= moveLeft(root);
		System.out.println(k);
	}

	private String moveLeft(TrieNode<String> node){
		if(node.element()!=null) return node.element();
		if(node.left()==null) return moveLeft(node.right());
		return moveLeft(node.left());
	}

	public void search(String str) {
		int level=0;
		char[] c = str.toCharArray();
		int keySearch;
		if(root==null) return;
		TrieNode<String> current=root;
		while(!current.isLeaf()){
			keySearch = Integer.parseInt(Character.toString(c[level++]));
			if(keySearch==0){
				if(current.left()==null) {
					current = current.right();
					continue;
				}
				current=current.left();
			}
			else if (keySearch==1){
				if(current.right()==null) {
					current = current.left();
					continue;
				}
				current=current.right();
			}
		}

		System.out.println( current.element());
	}





	public void size() {
		System.out.println( this.size);
	}

	public void height() {
		System.out.println( this.height);
	}

	public void print() {
		myList<String> list = trieToList();

		for (int i=list.size()-1; i>=0; i--){
			System.out.print(list.getElement(i)+" ");
		}
		System.out.println();
	}
}
