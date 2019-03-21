/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodosanimais;

import javax.swing.JOptionPane;
import jogodosanimais.Node;

/**
 *
 * @author martinfranzner
 */


public class JogoDosAnimais {

    
    public static BinaryTree start(BinaryTree bt){
        Node root;
        Node childL;
        Node childR;
        String rootArgument = "vive na agua?";
        String leftAnimal = "macaco";
        String rightAnimal= "tubarao";

        root = new Node(rootArgument, null, null,true);
        childL = new Node(leftAnimal,null,null,false);
        childR = new Node(rightAnimal,null,null,false);

        bt.addRoot(root);
        bt.root.setLeft(childL);
        bt.root.setRight(childR);
        
        return bt;
    
    }
    
    public static void main(String[] args) {
        // TODO code application logic here        
    int ret =0;
    BinaryTree bt = new BinaryTree();
    
    bt = start(bt);
    
    Node pointer;
    Node lastNodeExec;
    Node beforeLast = null;
    String beforeLastRorL = "";
    
    String lastComand = "";
    String input= "";
    String inputArgument = "";
    
 
    boolean w = true;
    while(w){
        //iterator nodes
        pointer = bt.root;
        lastNodeExec = bt.root;
        lastNodeExec = pointer;
        
        JOptionPane.showMessageDialog( null, "Pense em um animal", "Jogo dos Animais", JOptionPane.OK_OPTION );    
        ret = JOptionPane.showConfirmDialog( null, "O animal que voce pensou " + pointer.value, "Jogo do Animais", JOptionPane.YES_NO_OPTION );

        if(ret == JOptionPane.YES_OPTION ) {
            lastComand = "R";
            pointer = pointer.getRight();

        }else {
            lastComand = "L";
            pointer = pointer.getLeft();

        }
        while(pointer != null){
            //pass the last comand before the node that stoped
            beforeLastRorL = lastComand;
            
            //check if is an animal or question to show in the screen
            if(pointer.isQuestion == true){
                ret = JOptionPane.showConfirmDialog( null, "O animal que voce pensou " + pointer.value, "Jogo do Animais", JOptionPane.YES_NO_OPTION );      
            }
            else{
                ret = JOptionPane.showConfirmDialog( null, "O animal que voce pensou seria um " + pointer.value  + "?", "Jogo do Animais", JOptionPane.YES_NO_OPTION );
            }
            if(ret == JOptionPane.YES_OPTION ) {
                lastComand = "R";
                beforeLast = lastNodeExec;
                lastNodeExec = pointer;
                pointer = pointer.getRight();

            } else {
                lastComand = "L";
                beforeLast = lastNodeExec;
                lastNodeExec = pointer;
                pointer = pointer.getLeft();
            }

        }

        if( "R".equals(lastComand)){
            JOptionPane.showMessageDialog(null, "Acertei, de novo!");
        }
        else{
            //dont let the user cancel or dont type an animal or the quality of the animal
            input = JOptionPane.showInputDialog("Qual o animal que voce pensou?");
            while(input == null){
                JOptionPane.showMessageDialog(null, "Por favor digite um animal!");
                input = JOptionPane.showInputDialog("Qual o animal que voce pensou?");
            }
            
            inputArgument = JOptionPane.showInputDialog("Um(a) " + input + "_______ mas um(a) " + lastNodeExec.value + " nao.");
            while(inputArgument == null){
                JOptionPane.showMessageDialog(null, "Por favor digite a frase, vai ser legal :)");
                inputArgument = JOptionPane.showInputDialog("Um(a) " + input + "_______ mas um(a) " + lastNodeExec.value + " nao.");
            }
            
            if("R".equals(beforeLastRorL)){
                Node animal = new Node(input,null,null, false);
                Node toBeInserted = new Node(inputArgument,animal,lastNodeExec, true);
                beforeLast.setRight(toBeInserted);
            }
            else { //if the one before was to the left on the tree
                Node animal = new Node(input,null,null, false);
                Node toBeInserted = new Node(inputArgument,animal,lastNodeExec, true);
                beforeLast.setLeft(toBeInserted);
            }

        }

        ret = JOptionPane.showConfirmDialog( null, "Continuar jogar?", "Jogo do Animais", JOptionPane.YES_NO_OPTION );
        if(ret == JOptionPane.YES_OPTION ) {

        }
        else {
            w = false;
        }
    }
    JOptionPane.showMessageDialog( null, "Obrigado por jogar! :)", "Jogo dos Animais", JOptionPane.OK_OPTION ); 
       
    }
    
}
