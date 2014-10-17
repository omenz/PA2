
public class BST {
	private int count;
	private Term root;
	//which initializes an instance variable called "root" as null and an instance variable called "count" as 0.
	public BST(){
		root = null;
		count = 0;
	}

	//which returns the number of unique words in the document (i.e., count).
	public int size(){
		return count;
	}

	//which adds a new Term or increments frequencies if the term already exists in the BST.
	public void add(String documentName, String word){
		WebPages wp = new WebPages();
		Term wordT = new Term(word);
		TreeNode<Term> root = new TreeNode<Term>(wp.termsTree.getRootItem()); 
	}

	//which returns the Term object for the word. If printDepth is true, then get should keep
	//track of how deep in the tree it finds word and print out the value at the end in the form
	//" At depth 1" (At is preceded by 2 spaces). If the word is not found, it should print the 
	//deepest level that it checked.
	public Term get(String word, Boolean printDepth){
		//found tells us when we found our word and stops searching
		Boolean found = false;
		//store our term to return
		Term temp = null;
		//term starts at depth 1
		int depth = 1;
		WebPages wp = new WebPages();
		BinaryTree<Term> tempTree = wp.termsTree;
		while(!found){
			//if root and term are equal then set temp to term to return and stop searching
			if(tempTree.getRootItem().getName().equals(word)){
				temp =  tempTree.getRootItem();
				found = true;
			}
			//See if less then root
			else if(tempTree.getRootItem().getName().compareTo(word)<0){
				//if so set temp tree to left sub tree and increase depth
				if(tempTree.getRoot().getLeft()!=null){
					depth++;
					tempTree = tempTree.detachLeftSubtree();
				}
				//if left subtree empty means word doesn't exist
				else{
					temp = null;
					found = true;
				}
			}
			//if not equal to or less then it most be greater than, so to the right
			else{
				//if so set temp tree to right sub tree and increase depth
				if(tempTree.getRoot().getRight()!=null){
					depth++;
					tempTree = tempTree.detachRightSubtree();
				}
				//if right subtree empty means word doesn't exist
				else{
					temp =  null;
					found = true;
				}
			}
		}
		
		if(printDepth){
			System.out.println("  At depth " + depth );
		}
		return temp;

	}

}
