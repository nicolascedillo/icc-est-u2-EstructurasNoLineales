package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Node;

public class ArbolBinario{
    private Node root;
    private int peso;
    private boolean equilibrado;
    private List<Node> desequilibrados;

    public ArbolBinario(){
        this.root = null;
        equilibrado = true;
        desequilibrados = new ArrayList<>();
    }

    public void insert(int value){
        root = insertRec(root, value);
        peso++;
    }

    private Node insertRec(Node padre, int value) {
        if(padre == null){
            return new Node(value);
        }

        if(value < padre.getValue()){
            padre.setLeft(insertRec(padre.getLeft(), value));

        }else if(value > padre.getValue()){
            padre.setRight(insertRec(padre.getRight(), value));

        }
        return padre;
    }

    public void imprimirArbolInOrder(){
        imprimirInOrder(root);
    }

    private void imprimirInOrder(Node node){
        if(node != null){
            imprimirInOrder(node.getLeft());
            System.out.print(node.getValue() + ", ");
            imprimirInOrder(node.getRight());
        }

    }

    public void imprimirArbolPreOrder(){
        imprimirPreOrder(root);
    }

    private void imprimirPreOrder(Node node){
        if(node != null){
            System.out.print(node.getValue() + ", ");
            imprimirPreOrder(node.getLeft());
            imprimirPreOrder(node.getRight());
        }

    }

    public void imprimirArbolPostOrder(){
        imprimirPostOrder(root);
    }

    private void imprimirPostOrder(Node node){
        if(node != null){
            imprimirPostOrder(node.getLeft());
            imprimirPostOrder(node.getRight());
            System.out.print(node.getValue() + ", ");
        }
    }

    public boolean search(int value){
        return searchRec(root, value);
    }

    private boolean searchRec(Node node, int value){
        if(node == null){
            return false;
        }

        if(value<node.getValue()){
            return searchRec(node.getLeft(), value);
        }else if(value>node.getValue()){
            return searchRec(node.getRight(), value);
        }
        return true;
    }

    public int getHeight(){
        return getHeightRec(root);
    }

    public int getHeightRec(Node node){
        if(node == null){
            return 0;
        }

        int leftHeight = getHeightRec(node.getLeft());
        int rightHeight = getHeightRec(node.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int getWeight(){
        return peso;
    }

    public void imprimirArbolInOrderWithHeight(){
        imprimirInOrderWithHeight(root);
    }

    private void imprimirInOrderWithHeight(Node node){
       if(node != null){
        imprimirInOrderWithHeight(node.getLeft());
        System.out.print(node.getValue() + " (" + getHeightRec(node) + ") " + ", ");
        imprimirInOrderWithHeight(node.getRight());
        }
    }

    public void imprimirArbolInOrderEquilibrio(){
        imprimirInOrderEquilibrio(root);
    }

    private void imprimirInOrderEquilibrio(Node node){
       if(node != null){
        imprimirInOrderEquilibrio(node.getLeft());
        System.out.print(node.getValue() + " (" + getEquilibrio(node) + ") " + ", ");
        if(getEquilibrio(node)<-1 || getEquilibrio(node)>1){
            equilibrado = false;
            desequilibrados.add(node);
        }
        imprimirInOrderEquilibrio(node.getRight());
        }
    }

    private int getEquilibrio(Node node){
        if(node == null){
            return 0;
        }
        return getHeightRec(node.getLeft()) - getHeightRec(node.getRight());
    }

    public boolean estaEquilibrado(){
        return equilibrado;
    }

    public void listadoDesequilibrados(){
        for(Node node: desequilibrados){
            System.out.println(node + " (" + getEquilibrio(node) + ") ");
        }
    }
}