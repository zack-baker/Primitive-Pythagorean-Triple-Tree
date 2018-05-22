import java.lang.Math;

/**
*	This class represents a node in the primitive pythagorean triple tree. 
*/
public class Node{

	private int[] vals;
	public static final int[][] A = {{1,-2,2},{2,-1,2},{2,-2,3}};
	public static final int[][] B = {{1,2,2},{2,1,2},{2,2,3}};
	public static final int[][] C = {{-1,2,2},{-2,1,2},{-2,2,3}};

	private Node[] children = new Node[3];

	private Node parent;

	private boolean isChildless;


	/**
	*	Standard constructor. Verifies if vals is a proper pythagorean triple
	*/	
	public Node(int[] vals, Node parent, int depth) throws InvalidTripleException{
		//verif if vals is in fact a primitive pythagorean triple
		verifyVals(vals);
		this.parent = parent;
		this.vals = vals;
		System.out.println("Verification passed, node " + this + " created");
		if(depth>0){
			isChildless = false;
			generateChildren(depth-1);
		}else{
			isChildless = true;
		}
	}

	/**
	*	Default Constructor. Use {3,4,5} as the vals array (the root pythagorean triple)
	*	@return a Node with values 3,4,5
	*/
	public Node(int depth){
		this.vals = new int[3];
		vals[0] = 3;
		vals[1] = 4;
		vals[2] = 5;
		this.parent = null;
		if(depth>0){
			isChildless = false;
			generateChildren(depth-1);
		}else{
			isChildless = true;
		}
	}

	/**
	*	This method verifies using a variety of checks to see if the provided array of values is a valid primitive pythagorean triple.
	*	@param vals - triple of values to verify
	*	@return true if vals is a proper primitive pythagorean triple
	*/
	public boolean verifyVals(int[] vals){
		System.out.print("Verifying tuple " );
		for(int i=0;i<vals.length;i++){
			System.out.print(vals[i] + " ");

		}
		System.out.println("");
		if(vals.length!=3){
			throw new InvalidTripleException("Triple must be exactly 3 elements");
		}
		if(vals[0]<1 || (vals[1]<1 || vals[2]<1)){
			throw new InvalidTripleException("All elements must be positive");
		}
		int gcd = getGCD(getGCD(vals[0],vals[1]),vals[2]);
		if(gcd!=1){
			throw new InvalidTripleException("A primitive triple's elements must all be relatively prime");
		}
		int left = (int)(Math.pow(vals[0],2) + Math.pow(vals[1],2));
		int right = (int)Math.pow(vals[2],2);
		if(left!=right){
			throw new InvalidTripleException("The triple must satisfy a^2+b^2 = c^2");
		}

		return true;
	}

	/**
	*	This method generates and sets the three children of the node using matricies A,B and C
	*	@param depth - the number of layers for each child to generate. 
	*/
	public void generateChildren(int depth){
		int[] c1 = applyMatrix(A);
		int[] c2 = applyMatrix(B);
		int[] c3 = applyMatrix(C);
		children[0] = new Node(c1, this, depth);
		children[1] = new Node(c2, this, depth);
		children[2] = new Node(c3, this, depth);
	}

	public int[] applyMatrix(int[][] matrix){
		int[] res = {0,0,0};
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				res[i] += vals[j]*matrix[i][j];
			}
		}
		return res;
	}
	/**
	*	This method recursively calculates the gcd of the given input
	*	@param a - integer to calculate GCD for
	*	@param b - integer to calculate GCD for
	*	@return gcd of a and b
	*/
	public int getGCD(int a, int b){
		if(b==0){
			return a;
		}
		return getGCD(b,a%b);
	}

	//getter methods

	/**
	*	This method returns the node's parent
	*	@return the parent node
	*/
	public Node getParent(){
		return parent;
	}
	/**
	*	This method returns the values of the node
	*	@return the values composing the triple represented by the node
	*/
	public int[] getVals(){
		return vals;
	}
	/**
	*	This method returns the children nodes of the node
	*	@return - an array of nodes representing the children nodes
	*/
	public Node[] getChildren(){
		return children;
	}
	
	/**
	*	This method prints the full tree starting with this node	
	*/
	public void printTree(int tablevel){
		System.out.println(toString());
		if(!isChildless){
	
			for(int i=0;i<children.length;i++){
				System.out.print("(" + tablevel + ")");
				for(int j=0;j<tablevel;j++){

					System.out.print("\t");
				}
				children[i].printTree(tablevel+1);
			}
		}
	}
	/**
	*	Overridden toString method
	*	@return - the string '(a,b,c)' where a,b,c are values of the node
	*/
	public String toString(){
		return "(" + vals[0] + "," + vals[1] + "," + vals[2] + ")";

	}
}