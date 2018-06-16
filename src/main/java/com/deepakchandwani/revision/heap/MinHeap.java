package com.deepakchandwani.revision.heap;

public class MinHeap<T extends Comparable> extends HeapBase  {

	public MinHeap(Class clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}
	
	public MinHeap (Class clazz , int size )
	{
		super(clazz,size);
	}
	
	public void siftDown(int index)
	{
		int leftChild = getIndexOfLeftChild(index);
		int rightChild = getIndexOfLeftChild(index);
		
		// assume smaller index is -1
		
		int smallerIndex=-1;
		
		//3 possible scenarios
		
		// both not null
		if (leftChild !=-1 && rightChild!=-1) 
		{
			smallerIndex=getElementAtIndex(leftChild).compareTo(getElementAtIndex(rightChild))<0? leftChild:rightChild;
			
		}
		// left not null
		
		else if (leftChild !=-1 ) 
		{
			smallerIndex=leftChild;
		}
		
		// right not null;
		else if ( rightChild!=-1) 
		{
			smallerIndex=rightChild;
		}
		
		// if it is in correct position then it is good
		if (smallerIndex==-1) return ;
		
		// now compare the smaller child 
		
		if(getElementAtIndex(smallerIndex).compareTo(getElementAtIndex(index))<0)
		
		{
			swap(smallerIndex, index);
			siftDown(smallerIndex);
		}
	}
	
	  
	public void siftUp(int index )
	{
		// get Parent index
		int parentIndex = getParentIndex(index);
		
		if (parentIndex!=-1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex))<0 )
		{
			swap(parentIndex, index);
			siftUp(parentIndex);
		}
	}
	
	public void insert (T element){
		
		if ( count>=array.length) throw new RuntimeException(" Array Is Full ");
		
		// array has space 
		
		// insert in end
		
		array[count]=element;
		
		siftUp(count);
		
		count++;
	}
	
	public T removeMinElement()
	{
		T min = getMinPriorityElement();
		
		array[0]= array[count-1];
		
		count--;
		
		siftDown(0);
		
		return min;
	}

	private T getMinPriorityElement() {
		
		if (count==0) throw new RuntimeException(" Heap is Empty");
		T min = (T) array[0];
		// we do not decrement count here as we are getting the element
		return min;
	}
}
