public class PPT{

	public static void main(String[] args) {
		if(args.length<1){
			return;
		}
		int depth = Integer.parseInt(args[0]);
		Node n = new Node(depth);//create the first node
		System.out.println("Root node: " + n);

	}
}