import java.lang.Math;

/**
*	This class represents a node in the primitive pythagorean triple tree. 
*/
public class Node{

	private int[] vals;
	public static final int[][] A = {{1,-2,2},{2,-1,2},{2,-2,3}};
	public static final int[][] B = {{1,2,2},{2,1,2},{2,-2,3}};
	public static final int[][] C = {{-1,2,2},{-2,1,2},{-2,2,3}};

	public Node[] children;

	public Node parent;


	/**
	*	Standard constructor. Verifies if vals is a proper pythagorean triple
	*/	
	public Node(int[] vals, Node parent) throws InvalidTripleException{
		//verif if vals is in fact a primitive pythagorean triple
		verifyVals(vals);
		this.parent = parent;
		this.vals = vals;
	}

	/**
	*	Default Constructor. Use {3,4,5} as the vals array (the root pythagorean triple)
	*	@param parent - the parent node for this current node. The root node (3,4,5) has no parent
	*	@return a Node with values 3,4,5
	*/
	public Node(){
		this.vals = new int[3];
		vals[0] = 3;
		vals[1] = 4;
		vals[2] = 5;
		this.parent = null;
	}


	
		

	public boolean verifyVals(int[] vals){
		if(vals.length!=3){
			throw new InvalidTripleException("Triple must be exactly 3 elements");
		}
		if(vals[1]<1 || (vals[2]<1 || vals[3]<1)){
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

	public int getGCD(int a, int b){
		if(b==0){
			return a;
		}
		return getGCD(b,a%b);
	}
}