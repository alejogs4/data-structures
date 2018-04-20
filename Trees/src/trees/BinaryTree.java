package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase con la implementacion de un arbol binario
 * @author ochoscar
 */
public class BinaryTree {
    
    ////////////////////////
    // Atributos
    ////////////////////////
    
    private BinaryNode<String> root;
    
    private int leaf = 0;
    
    private int greathestRoute = 0;
    
    public int getLeaf() {
        leaf = 0;
        this.postorder();
        return leaf;
    }
    
    ////////////////////////
    // Metodos
    ////////////////////////
    
    public BinaryTree() {
        BinaryNode<String> n9 = new BinaryNode<>("H", null, null);
        BinaryNode<String> n10 = new BinaryNode<>("J", null, null);
        BinaryNode<String> n12 = new BinaryNode<>("L", null, null);
        BinaryNode<String> n11 = new BinaryNode<>("K", n12, null);
        BinaryNode<String> n8 = new BinaryNode<>("E", null, null);
        BinaryNode<String> n6 = new BinaryNode<>("G", null, n9);
        BinaryNode<String> n7 = new BinaryNode<>("I", n10, n11);
        BinaryNode<String> n4 = new BinaryNode<>("C", null, null);
        BinaryNode<String> n5 = new BinaryNode<>("D", n8, null);
        BinaryNode<String> n2 = new BinaryNode<>("B", n4, n5);
        BinaryNode<String> n3 = new BinaryNode<>("F", n6, n7);
        BinaryNode<String> n1 = new BinaryNode<>("A", n2, n3);
        
        root = n1;
    }
    
    public String preorder() {
        return preorder(root,"");
    }
    
    private String preorder(BinaryNode<String> node,String route) {
        String t = node.getItem();
        if(node.getLeft() == null && node.getRight() == null ) {
            route = route + t;
            System.out.println(route);
            greathestRoute = route.length() > greathestRoute ? route.length() : greathestRoute;
            route = "";
        }
        else {
            route = route + t;
        }
        
        if(node.getLeft() != null) t = t + preorder( node.getLeft(),route );
        if(node.getRight() != null) t = t + preorder( node.getRight(),route );
        
        return t;
    }
    
    public String inorder() {
        return inorder(root);
    }
    
    private String inorder(BinaryNode<String> node) {
        String t = "";
        if(node.getLeft() != null) t = t + inorder( node.getLeft() );
        t += node.getItem();
        if(node.getRight() != null) t = t + inorder( node.getRight() );
        return t;
    }
    
    public String postorder() {
        return postorder(root);
    }
    
    private String postorder(BinaryNode<String> node) {
        String t = "";
         if(node.getLeft() == null && node.getRight() == null) leaf += 1;
         
        if(node.getLeft() != null) t = t + postorder( node.getLeft() );
        if(node.getRight() != null) t = t + postorder( node.getRight() );
        
        t += node.getItem() + " ";
        return t;
    }
    
    public String levelOrder() {
        String tree = "";
        ArrayList<BinaryNode<String>> nodes = new ArrayList<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            BinaryNode<String> aux = nodes.remove(0);
            if(aux.getLeft() != null) nodes.add(aux.getLeft());
            if(aux.getRight() != null) nodes.add(aux.getRight());
            tree += aux.getItem() + " ";
        }
        return tree;
    }

    public String recursiveMethod() {
        return recursiveMethod(root);
    }
    
    private String recursiveMethod(BinaryNode<String> node) {
        int t = Integer.parseInt(node.getItem());
        if(node.getLeft() != null){
            t = t < Integer.parseInt(node.getLeft().getItem()) ? Integer.parseInt(node.getLeft().getItem()) : t;
        }
        if(node.getRight() != null){
             t = t > Integer.parseInt(node.getRight().getItem()) ? t : Integer.parseInt(node.getRight().getItem());
        }
        return t + "";  
    }
    
    public String getGreatherAndLess() {
        int greather = 0;
        int less = 999999;
        String tree[] = postorder().split(" ");
        for(int i = 0; i < tree.length; i++) {
            greather = Integer.parseInt(tree[i]) > greather ? Integer.parseInt(tree[i]) : greather;
            less = Integer.parseInt(tree[i]) < less ? Integer.parseInt(tree[i]) : less;
        }
        return "El mayor es " + greather + " y el menor es " + less;
    }
    
    public int getDeep() {
        int deep = 0;
        Queue< BinaryNode<String> > nodes = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            BinaryNode<String> aux = nodes.poll();
            if(aux.getLeft() != null) nodes.add(aux.getLeft());
            if(aux.getRight() != null) nodes.add(aux.getRight());
           
            if(aux.getLeft() != null || aux.getRight() != null) deep++;
        }
        return deep - 1;
    }
    public void deleteLeaf(){ deleteLeaf(root); }
    
    private void deleteLeaf(BinaryNode<String> node) {        
        if(node.getLeft() != null){
            if(node.getLeft().getLeft() == null && node.getLeft().getRight() == null) node.setLeft(null);
            else deleteLeaf(node.getLeft());
        }
        if(node.getRight() != null){
            if(node.getRight().getLeft() == null && node.getRight().getRight() == null) node.setRight(null);
            else deleteLeaf(node.getRight());
           
        }
        return;
    }
    
    public void swapChilds() { swapChilds(root); }
    
    private void swapChilds(BinaryNode<String> node) {
        if(node.getLeft() != null || node.getRight() != null) {
            BinaryNode<String> aux = node.getLeft() != null ? node.getLeft() : node.getRight();
            if(node.getLeft() != null) {
                node.setLeft(node.getRight());
                node.setRight(aux);
            }
            else {
                node.setRight(node.getLeft());
                node.setLeft(aux);
            }
        }
        
        if(node.getLeft() != null) swapChilds(node.getLeft());
        if(node.getRight() != null) swapChilds(node.getRight());
        return;
    }
    
    public static String reverse(String str) {
        return reverse(str,str.length() - 1,"");
    }
    
    private static String reverse(String str,int length,String reversed) {
        if(length == 0) {
            reversed += str.charAt(length);
            return reversed;
        }
        else {
            reversed += str.charAt(length);
            return reverse(str,length - 1,reversed);
        }
    }
    
    public void insert(String item) {
        ArrayList<BinaryNode<String>> nodes = new ArrayList<>();
        BinaryNode<String> itemToInsert = new BinaryNode<>(item,null,null);
        nodes.add(root);
        while(!nodes.isEmpty()) {
            BinaryNode<String> aux = nodes.remove(0);
            if(aux.getLeft() != null){
                nodes.add(aux.getLeft());
            }else if(aux.getLeft() == null){
                System.out.println(aux.getItem());
                aux.setLeft(itemToInsert);
                break;
            }
            
            if(aux.getRight() != null){
                nodes.add(aux.getRight());
            } else if(aux.getRight() == null && aux.getLeft() != null) {
                System.out.println(aux.getItem());
                aux.setRight(itemToInsert);
                break;
            }
        }
    }
    
    public int getRoute() {
        preorder();
        return this.greathestRoute;
    }
}
