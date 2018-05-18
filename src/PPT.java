public class PPT{

	public static void main(String[] args) {
		if(args.length<1){
			System.err.println("USAGE: java PPT [depth]");
			return;
		}
		int depth = Integer.parseInt(args[0]);
		Node n = new Node(depth);//create the first node
		System.out.println("Root node: " + n);

	}
}