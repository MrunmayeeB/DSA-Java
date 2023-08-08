class HeightofTree{
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

	public static int height(Node root){
		if(root == null)
		{
			return 0;
		}

		int leftht = height(root.left);
		int rightht = height(root.right);

		int myht = Math.max(leftht,rightht) + 1;

		return myht;
	}

	public static void main(String args[]){
		int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(arr);
		System.out.println(root.data);  // returns root node i.e 1.
		int ht = height(root);
		System.out.println(ht);
	}
}