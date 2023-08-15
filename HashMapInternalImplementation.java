import java.util.*;

class HashMapInternalImplementation{
	static class HashMap<K,V>  //generics -> general data types
	{
		private class Node 
		{
			K key; 			//key of type K
			V value; 		//value of type V
		

			public Node(K key, V value)  //constructor for Node class
			{
				this.key = key;
				this.value = value;
			}
		}


		private int n;  	//total number of nodes
		private int N;		//Array size or number of buckets

		private LinkedList<Node> buckets[];  //array of type linkedlist with nodes
				// int 				arr[]

		@SuppressWarnings("unchecked")  //to remove waernings from output
		public HashMap() 	//contructor of HashMap class
		{
			this.N = 4;
			this.buckets = new LinkedList[4];   //to make empty linkedlist at every index(bucket) of array(buckets[])
			for(int i=0;i<4;i++){
				this.buckets[i] = new LinkedList<>();
			}
		}

		private int hashFunction(K key)
		{
			int bi = key.hashCode();   //inbuilt function or algo in java that retuns bucketindex
			return Math.abs(bi) % N;	//bucket index should be positive(abs function) and between 0 to N-1(% N(remainder))
		}

		private int searchinLL(K key, int bi)
		{
			LinkedList<Node> ll = buckets[bi];  //linkedlist at bucket index
			for(int i=0;i<ll.size();i++)
			{
				if(ll.get(i).key == key)
				{
					return i;          //di -> index at ll where key is present
				}
			}

			return -1;
		}

		@SuppressWarnings("unchecked")
		private void rehash() 
		{
			LinkedList<Node> oldBucket[] = buckets;  //new array to store all elements of buckets
			buckets = new LinkedList[N*2];			//buckets of double size

			for(int i=0; i<N*2; i++) 
			{
				buckets[i] = new LinkedList<>();    //add empty linkedlist at every index of new array
			}
					
			for(int i=0; i<oldBucket.length; i++) 
			{
				LinkedList<Node> ll = oldBucket[i];
				for(int j=0; j<ll.size(); j++)
				{
					Node node = ll.get(j);				//add nodes from oldbucket to new array
					put(node.key, node.value);
				}
			}
		}

		//put function
		public void put(K key, V value)
		{
			int bi = hashFunction(key);     //returns bucket index of array
			int di = searchinLL(key,bi);	//returns dataindex in linkedlist stored at bi(array)

			if(di == -1) //key doesn't exist
			{
				buckets[bi].add(new Node(key,value));   //we will add new node with passed key and 
																//value at bi index of array buckets
				n++;  //increase number of nodes
			}
			else //if key exists
			{
				Node node = buckets[bi].get(di);      //we will get node or dataindex di from present at bi and store that in node
				node.value = value;						//then update the value in the node with new value passed
			}

			//for rehashing
			double lambda = (double)n/N ;
			if(lambda > 2.0)
			{
				rehash();
			}
		}


		public boolean containsKey(K key)
		{
			int bi = hashFunction(key);     //returns bucket index of array
			int di = searchinLL(key,bi);	//returns dataindex in linkedlist stored at bi(array)
			
			if(di == -1)
			{ //key doesn't exist
				return false;
			} 
			else 
			{ //key exists
				return true;
			}
		}


		public V remove(K key)
		{
			int bi = hashFunction(key);     //returns bucket index of array
			int di = searchinLL(key,bi);	//returns dataindex in linkedlist stored at bi(array)

			if(di == -1)    //key doesn't exist
			{ 
				return null;
			} 
			else 			//key exists
			{ 
				Node node = buckets[bi].remove(di);  //remove the node at di
				n--;
				
				return node.value;   //return value of removed node
			}
		}


		public V get(K key) 
		{
			int bi = hashFunction(key);     //returns bucket index of array
			int di = searchinLL(key,bi);	//returns dataindex in linkedlist stored at bi(array)

			if(di == -1)
			{ //key doesn't exist
				return null;
			} 
			else 
			{ //key exists
				Node node = buckets[bi].get(di);
				return node.value;
			}
		}


		public ArrayList<K> keySet() 
		{
			ArrayList<K> keys = new ArrayList<>();

			for(int i=0; i<buckets.length; i++)
			{ //bi
				LinkedList<Node> ll = buckets[i];
				for(int j=0; j<ll.size(); j++)
				{ //di
				Node node = ll.get(j);
				keys.add(node.key);
				}
			}
			return keys;
		}


		public boolean isEmpty() {
		return n == 0;
		}
	}



	public static void main(String args[]){
		HashMap<String, Integer> map = new HashMap<>();
		map.put("India", 190);
		map.put("China", 200);
		map.put("US", 50);

		ArrayList<String> keys = map.keySet();

		for(int i=0; i<keys.size(); i++) 
		{
			System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
		}

		map.remove("India");
		System.out.println(map.get("India"));
	}
}