class QueueusingLinkedlist{
	static class Node{
		int data;
		Node next;

		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	static class Queue{
		static Node head = null;
		static Node tail = null;

		public static boolean isEmpty()
		{
			return head == null && tail == null;  //add from both
		}

		//enqueue
		public static void add(int data){
			Node newnode = new Node(data);
			if(isEmpty())
			{
				head = tail = newnode;    //both fron and rear at 0th index
				return;
			}

			tail.next = newnode;
			tail = newnode;
		
		}

		//dequeue
		public static int remove(){
			if(isEmpty()) {
               System.out.println("empty queue");
               return -1;
           }

			//remove from front
            int front = head.data;  //return the removed element

			//if only one element or single node
			if(head == tail)
			{
				tail = null;
			}

			head = head.next;

			return front;
		}

		public static int peek(){
			if(isEmpty()) {
               System.out.println("empty queue");
               return -1;
           }

           int front = head.data;
           
           //only one node
			if(head == tail)
			{
				tail = null;
			}

			return front;
		}
	}


	public static void main(String args[]){
		Queue q = new Queue();
		q.add(1);
		q.add(2);
		q.add(3);

		while(!q.isEmpty())
		{
			System.out.println(q.peek());
			q.remove();
		}
	}
}