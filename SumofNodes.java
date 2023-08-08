class SumofNodes{
	static class Node{
		int data;
		Node left;
		Node right;

		Node(int data){
			this.data = data;
			//initializing left and right node to null
			this.left = null;
			this.right = null;
		}
	}

	static class BinaryTree{
		static int idx = -1; //null

		public static Node buildTree(int nodes[]){
			idx++;         //increase and become 0 for root node
			if(nodes[idx] == -1)
			{
				return null;
			}

			Node newNode = new Node(nodes[idx]);
			newNode.left = buildTree(nodes);
			newNode.right = buildTree(nodes);

			return newNode;
		}

	}

	public static int sumofnodes(Node root){
		if(root == null)
		{
			return 0;
		}

		int leftsum = sumofnodes(root.left);
		int rightsum = sumofnodes(root.right);

		return leftsum + rightsum + root.data;
	}

	public static void main(String args[]){
		int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(arr);
		System.out.println(root.data);  // returns root node i.e 1.
		int sum = sumofnodes(root);
		System.out.println(sum);
	}
}