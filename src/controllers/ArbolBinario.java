package controllers;

import models.Node;

public class ArbolBinario{
    private Node root;

    public ArbolBinario(){
        this.root = null;
    }

    public void insert(int value){
        root = insertRec(root, value);
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

}