package com.deepakchandwani.revision.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTransversal {
	
	public static void main(String [] args)
	{
		new BreadthFirstTransversal().breathFirstTransversal();
	}

	public Node createTestNode() {
		Node node = new Node(

							"A",
					
									new Node("B",				
														getNode("D"),
												
														getNode("E")
									
									)
					
							, 							
									new Node("C",							
														getNode("F"),
							
														getNode("G")
									
									)
					
							)
					
							;

		;
		return node;

	}

	Node getNode(String data) {
		return new Node(data);
	}
	
	
	 void breathFirstTransversal()
	{
		Node node = createTestNode();
		
		     
		Queue<Node> queue =  new LinkedList();
		queue.add(node);
				
				while (!queue.isEmpty()){
					
					    Node nodePushedOnQueue = queue.remove();
					    
						System.out.println(nodePushedOnQueue.data);
						
						if (nodePushedOnQueue.left!=null) queue.add(nodePushedOnQueue.left);
						if (nodePushedOnQueue.right!=null) queue.add(nodePushedOnQueue.right);
					
				}
		
	}

}
