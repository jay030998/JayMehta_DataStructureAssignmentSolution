package com.greatlearning.datastructureassignentsolution.question2;

public class SkewedTree {
	
	public static Node node;
    static Node prevNode = null;
    static Node headNode = null;
    
	static class Node{
		
		int key;
		Node left,right;
		
		public Node(int data) {
			key=data;
			left=right=null;
		}
	}
	
	static void binaryTreeToSkewedTree(Node root, int order) {
		if(root == null) {
			return;
		}
		if(order > 0) {
			binaryTreeToSkewedTree(root.right, order);
		}else
		{
			binaryTreeToSkewedTree(root.left, order);
		}
		
		Node rightNode = root.right;
        Node leftNode = root.left;
        
        if(headNode == null)
        {
            headNode = root;
            root.left = null;
            prevNode = root;
        }
        else
        {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }
        
        if(order > 0) {
        	binaryTreeToSkewedTree(leftNode, order);
        }
        else {
        	binaryTreeToSkewedTree(rightNode, order);
        }
	}
	
	static void traverseRightSkewed(Node root)
    {
        if(root == null)
        {
            return;
        }

        System.out.print(root.key + " ");
        traverseRightSkewed(root.right);       
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SkewedTree tree = new SkewedTree();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left= new Node(55);
		
		int order = 0;
        binaryTreeToSkewedTree(node, order);
        traverseRightSkewed(headNode);
        
	}

}
