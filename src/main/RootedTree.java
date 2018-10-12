package main;


/** Represents a rooted tree. A rooted tree contains a left, right and root component subtree,
 * any of which may be null. Each node in the tree holds a string data object.
 *
 */
public class RootedTree {
	RootedTree right;
	RootedTree left;
	RootedTree root;
	String data;
	
	public RootedTree(RootedTree left, RootedTree root, RootedTree right, String data) {
		this.left = left;
		this.right = right;
		this.root = root;
		this.data = data;
	}
	
	public RootedTree(String data) {  //Singleton tree
		this.data = data;
	}
	
	/** Traverses the tree in order
	 * 
	 * @return a string of elements in order
	 */
	public String getPreorder() {
		String s  = this.data;
		if (this.left!=null){
			s+=" " + this.left.getPreorder();
		}
		if (this.root!=null){
			s+=" " + this.root.getPreorder();
		}
		if (this.right!=null){
			s+=" " + this.right.getPreorder();
		}
		return s;
	}
	
	/** Traverses the tree in level order
	 * 
	 * @return a string of elements in level order
	 */
	public String getLevelOrder() {
		int H = getHeight();
		String s="";
		for (int i=0; i<=H; i++){
			s+=" " + getLevel(i);
		}
		return s.trim();
	}
	
	/** Gets the elements level i in the tree
	 * 
	 * @param i the level of the tree, where i=0 is this
	 * @return string of elements at level i
	 */
	public String getLevel(int i) {
		String s = getLevelHelper(i);
		return s.trim();
	}
	
	public int getHeight() {
		int leftHeight = 0;
		int rightHeight = 0;
		int rootHeight = 0;
		if (this.isLeafNode()){
			return 0;
		}
		if (this.left!=null){
			leftHeight = 1 + this.left.getHeight();
		}
		if (this.root!=null){
			rootHeight = 1 + this.root.getHeight();
		}
		if (this.right!=null){
			rightHeight = 1 + this.right.getHeight();
		}
		
		return Math.max(leftHeight, Math.max(rootHeight, rightHeight));
	}
	
	private String getLevelHelper(int i) {
		String s = "";
		if (i==0){
			s+=this.data + " ";
		}
		if (this.left!=null){
			s+=this.left.getLevelHelper(i-1);
		}
		if (this.root!=null){
			s+=this.root.getLevelHelper(i-1);
		}
		if (this.right!=null){
			s+=this.right.getLevelHelper(i-1);
		}
		return s;
	}
	
	private boolean isLeafNode() {
		return this.left==null && this.right==null && this.root==null;
	}
	
}
