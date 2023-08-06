class selectionsort
{

	public static void printArray(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String args[])
	{
		int arr[]={3,4,2,5,1};

		//selection sort
		for(int i=0;i<arr.length;i++)
		{
			int smallest=i;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[smallest]>arr[j])
				{
				smallest=j;
				}
			}
			int temp=arr[smallest];
			arr[smallest]=arr[i];
			arr[i]=temp;
		}

	 printArray(arr);
	}
}