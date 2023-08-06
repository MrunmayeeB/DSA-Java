import java.util.*;

class LinkedL{
	public static void main(String args[]){

		LinkedList<Integer> list = new LinkedList<Integer>();

		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int j = sc.nextInt();

		for(int k=m;k<=j;k++)
		{
			list.add(k);
		}
		System.out.println(list);

		for (int i = list.size() - 1; i >= 0; i--) {
	  			if ((int) list.get(i) > 25) {
	    			list.remove(i);
	      }
	      System.out.println(list);
	    }
		System.out.println(list);

	}
}