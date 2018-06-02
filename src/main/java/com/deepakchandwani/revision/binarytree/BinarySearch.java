package com.deepakchandwani.revision.binarytree;

public class BinarySearch {
	
	static int arr[] =  {11,22,33,44,55,66,77,88,99 };
	
	public static void main( String args [])
	{
		
		System.out.println( binarySearchAList (arr , 77));
		
	}
	
	static int binarySearchAList( int[] arr , int number )
	{
		int min = 0;
		
		int max= arr.length-1;
		
		int loop = 1;
		
		while (min<=max)
		{
			
			System.out.println (" loop " + +loop);
			int mid = (min+max)/2;  // find the mid
			
			if (arr[mid]==number)   // found
			{
				return number;
			}
			
			if (arr[mid]<number)    // as mid is less so upper half look
			{
				min=mid+1;          // rearranging the min
			}
			
			if (arr[mid]>number)    // ultaa logic means reverse logic hindi lingo
			{
				max=mid-1;
			}
		}
		
		return -1;
	}

}
