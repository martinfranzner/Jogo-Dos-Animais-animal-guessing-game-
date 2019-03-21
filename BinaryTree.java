/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodosanimais;

/**
 *
 * @author martinfranzner
 */
public class BinaryTree {

    Node root;

    //first verify if there is no root, then add root node
    public void addRoot(Node r){
        if(root != null){
            System.out.println("Unpossible to add root node!");
        }
        else {
            root = r;            
        }
    }
   
}
class Node {
        String value;
        Node left;
        Node right;
        boolean isQuestion;
        Node(String value, Node r, Node l, boolean iQ) {
            this.value = value;
            right = r;
            left = l;
            isQuestion = iQ;
        }
        
        public void setLeft(Node newLeft) {                    
        left = newLeft;
        }
        public void setRight(Node newRight) {                    
        right = newRight;
        }
        public Node getLeft( ) {
            return left;                                               
        } 
        public Node getRight( ) {
            return right;                                               
        } 
        
}