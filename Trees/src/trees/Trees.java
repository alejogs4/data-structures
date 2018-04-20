/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author s115e19
 */
public class Trees {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        /*System.out.println(bt.preorder());
        System.out.println(bt.inorder());
        System.out.println(bt.levelOrder());
        System.out.println(bt.getGreatherAndLess());
                System.out.println(bt.preorder());
        System.out.println(bt.getDeep());
        System.out.println(bt.getRoute());
        System.out.println(bt.getLeaf());
                System.out.println(bt.getLeaf());
        bt.deleteLeaf();
                bt.swapChilds();
        System.out.println(bt.levelOrder());
        String str = "hola";
        */
        System.out.println(bt.levelOrder());
        bt.insert("Y");
        System.out.println(bt.levelOrder());
        bt.insert("R");
        System.out.println(bt.levelOrder());
        bt.insert("Q");
        bt.insert("X");
        hanoi(8, "A", "B", "C");
        System.out.println(sum(16));

        //System.out.println(reverse(str,str.length() -1 ,""));
       
    }
        static String reverse(String str,int length,String reversed) {
        if(length == 0) {
            reversed += str.charAt(length);
            return reversed;
        }
        else {
            reversed += str.charAt(length);
            return reverse(str,length - 1,reversed);
        }
    }
        
    static void hanoi(int numberOfTower,String origin,String aux,String destinity) {
        if(numberOfTower > 0) {
            hanoi(numberOfTower - 1,origin,destinity,aux);
            System.out.println(numberOfTower + " de " + origin + " hasta " + destinity);
            hanoi(numberOfTower - 1,aux,origin,destinity);
        }
    }
    
    static int sum(int num) {
        if(num < 10) {
            return num;
        }
        return num + sum(num % 10);

    }
    
    
    
}