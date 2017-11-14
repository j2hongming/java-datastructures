package org.j2hongming.datastructure.binarytree;

/**
 * Hello world!
 *
 */
public class BTApp 
{
    public static void main( String[] args )
    {
    	// TreeNode instantiation
        TreeNode nodeA = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");
        TreeNode nodeD = new TreeNode("D");
        TreeNode nodeE = new TreeNode("E");
        TreeNode nodeF = new TreeNode("F");
        TreeNode nodeG = new TreeNode("G");
        TreeNode nodeH = new TreeNode("H");
        TreeNode nodeI = new TreeNode("I");
        
        // construct the Binary Tree
        nodeA.setLeftchild(nodeB); nodeA.setRightchild(nodeC);
        nodeB.setLeftchild(nodeD); nodeB.setRightchild(nodeE);
        nodeE.setLeftchild(nodeG); nodeE.setRightchild(nodeH);
        nodeC.setLeftchild(nodeF);
        nodeF.setRightchild(nodeI);
        
        // link parent pointer
        nodeB.setParent(nodeA); nodeC.setParent(nodeA);
        nodeD.setParent(nodeB); nodeE.setParent(nodeB);
        nodeG.setParent(nodeE); nodeH.setParent(nodeE);
        nodeF.setParent(nodeC);
        nodeI.setParent(nodeF);
        
        BinaryTree BT = new BinaryTree();
        BT.setRoot(nodeA);
//        BT.postOrder(BT.getRoot());
        BT.inOrderUsingParent(BT.getRoot());
        System.out.println();
        BT.inOrderReverseUsingParent(BT.getRoot());
        System.out.println();
        
        BinaryTree BTusingLevelOrderConstuct = new BinaryTree("ABCDEFxxxGHxI");
        BTusingLevelOrderConstuct.inOrderUsingParent(BTusingLevelOrderConstuct.getRoot());
        System.out.println();
        BTusingLevelOrderConstuct.levelOrder(BTusingLevelOrderConstuct.getRoot());
        System.out.println();
        BTusingLevelOrderConstuct.insertLevelOrder("K");
        BTusingLevelOrderConstuct.insertLevelOrder("L");
        BTusingLevelOrderConstuct.insertLevelOrder("M");
        BTusingLevelOrderConstuct.insertLevelOrder("N");
        BTusingLevelOrderConstuct.inOrderUsingParent(BTusingLevelOrderConstuct.getRoot());
    }
}
