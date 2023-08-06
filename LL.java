class LL{
	Node head;
	private int size;

	LL(){
		this.size=0;
	}

	class Node{
		String data;
		Node next;

		Node(String data){
			this.data = data;
			this.next = null;
			size++;
		}
	}

	//add first
	public void addFirst(String data){
		Node newnode = new Node(data);
		if(head == null){
			head = newnode;
			return;
		}

		newnode.next = head;
		head = newnode;
	}

	//add last
	public void addLast(String data){
		Node newnode = new Node(data);
		if(head == null){
			head = newnode;
			return;
		}

		Node currentnode = head;
		while(currentnode.next != null){
			currentnode = currentnode.next;
		}

		currentnode.next = newnode;
	}

	//print list
	public void printlist(){
		if(head == null){
			System.out.println("list is empty");
			return;
	
		}
		Node currentnode = head;
		while(currentnode != null){
			System.out.print(currentnode.data + " -> ");
			currentnode = currentnode.next;
		}

		System.out.println("NULL");
	}


	//delete first
	public void deleteFirst(){
		if(head == null){
			System.out.println("List is empty");
			return;
		}
		size--;
		head = head.next;
	}


	//delete last
	public void deleteLast(){
		if(head == null){
			System.out.println("List is empty");
			return;
		}

		size--;
		if(head.next == null){
			head = null;
			return;
		}

		Node secondLast = head;
		Node last = head.next;
		while(last.next != null){
			last = last.next;
			secondLast = secondLast.next;
		}

		secondLast.next = null;

	}

	//size
	public int getsize(){
		return size;
	}


	//reverse a list - iteration
	public void reverse(){
		if(head == null || head.next == null){
			return ;
		}

		Node prev = head;
		Node curr = head.next;
		while(curr != null){
			Node nextnode = curr.next;
			curr.next = prev;

			//update
			prev = curr;
			curr = nextnode;
		}

		head.next = null;
		head = prev;
	}



	public static void main(String args[]){
		LL list = new LL();
		list.addFirst("a");
		list.addFirst("is");
		list.printlist();

		list.addLast("list");
		list.addFirst("this");
		list.printlist();

		System.out.println(list.getsize());

		list.deleteFirst();
		list.deleteLast();
		list.printlist();

		System.out.println(list.getsize());

		list.reverse();
		list.printlist();
	}
}