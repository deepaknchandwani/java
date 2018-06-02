package com.deepakchandwani.revision.binarytree;

public class PreOrder_InOrder_PostOrder {
	
	/*
	 * 			https://www.youtube.com/watch?v=eL8NZ-21lqI   very good explanation at youtube english and hindi but concept is good
	 * 
	
									    F
										
								 D			   J
								
								
							B		 E		G		K
							         |
							      no child    
							
						A		C				I
				

							*/
	
	
	// Pre Order       				In Order      				 Post Order
	// FDBACEJGIK                   ABCDEFGIJK					 ACBEDIGKJF
	
	// root  left right             left root right              left right root
	
	
	//								free fall                    break the leafs
	
	
	public static void main(String [] args)
	{
		PreOrder_InOrder_PostOrder preOrder_InOrder_PostOrder = new PreOrder_InOrder_PostOrder();
		preOrder_InOrder_PostOrder.preOrderT(preOrder_InOrder_PostOrder.createTestNode());
		System.out.println();
		preOrder_InOrder_PostOrder.inOrderT(preOrder_InOrder_PostOrder.createTestNode());
		System.out.println();
		preOrder_InOrder_PostOrder.postOrderT(preOrder_InOrder_PostOrder.createTestNode());
	}
	
	public Node createTestNode() {
		Node node = new Node(

							"F",
					
									new Node("D",				
														//getNode("B")
																		new Node("B",				
																				getNode("A")
																																								
																				,
																		
																				getNode("C")
															
															) 
														,
												
														getNode("E")
									
									)
					
							, 							
									new Node("J",							
														//getNode("G")
																		new Node("G",				
																				null
																																								
																				,
																		
																				getNode("I")
																					
																				)	
									,
							
														getNode("K")
									
									)
					
							)
					
							;

		;
		return node;

}

	Node getNode(String data) {
		return new Node(data);
	}
	
	
	void preOrderT(Node node)
	{
		if (node==null) return;
		System.out.print(node.data);
		preOrderT(node.left);
		preOrderT(node.right);
	}
	
	void inOrderT(Node node)
	{
		if (node==null) return;
		
		inOrderT(node.left);
		System.out.print(node.data);
		inOrderT(node.right);
	}
	
	void postOrderT(Node node)
	{
		if (node==null) return;
		
		postOrderT(node.left);
		postOrderT(node.right);
		System.out.print(node.data);
	}
}