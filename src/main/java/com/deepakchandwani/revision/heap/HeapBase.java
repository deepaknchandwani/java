package com.deepakchandwani.revision.heap;

import java.lang.reflect.Array;

public abstract class HeapBase <T extends Comparable> {
	
	private static int size=130;
	T[] array ;
	int count =0;
	
	public HeapBase (Class clazz)
	{
		this(clazz, size);
	}
	
	public HeapBase(Class clazz , int size)
	{
		array= (T[]) Array.newInstance(clazz,size);
	}
	
	public int getIndexOfLeftChild (int i )
	
	{
		int leftChildIndex = 2*i + 1;
		
		if ( leftChildIndex >= count)  // as we have array length starts at o even > should be good imp point
		{
			return -1;
		}
		
		return leftChildIndex;
		
	}
	
   public int getIndexOfRightChild (int i )
	
	{
		int rightChildIndex = 2*i + 2;
		
		if ( rightChildIndex >= count)
		{
			return -1;
		}
		
		return rightChildIndex;
		
	}
   
    public int getParentIndex(int i)
    {
    	if (i< 0 || i> count) return -1;
    	return (i-1)/2;
    	
    }
    
    public void swap ( int i , int j)
    {
    	T temp = array[i];
    	array[i]=array[j];
    	array[j]=temp;
    }
    
    public int getCount()
    {
    	return count;
    }
    
    public boolean isEmpty()
    {
    	return count==0;
    }
    
    public boolean  isFull()
    {
    	return count == array.length;
    }
    
    public T getElementAtIndex(int i)
    {
    	
    	if (i < 0 || i > count) throw  new RuntimeException (" Array Index Out Of Bound : Index at " + i);;
    	
    	return array[i];
    }

}
