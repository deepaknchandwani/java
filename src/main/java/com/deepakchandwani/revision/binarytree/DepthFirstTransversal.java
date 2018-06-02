package com.deepakchandwani.revision.binarytree;


public class DepthFirstTransversal {
	
	public static void main(String [] args)
	{
		new DepthFirstTransversal().depthFirstTransversal();
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
	
	
	 void depthFirstTransversal()
	{
		Node node = createTestNode();
		
		depthT(node);    
		 
		
	}
	 
	 void depthT(Node node)
	 {
		 
		 if (node==null) return;
		 System.out.println(node.data);
		 
		 depthT(node.left);
		 depthT(node.right);
	 }

}
