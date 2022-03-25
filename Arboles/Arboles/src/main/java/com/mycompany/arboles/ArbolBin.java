/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arboles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author javi
 */
public class ArbolBin <T extends Comparable<T>> implements BinaryTreeADT<T>{
    
    protected NodoBin<T> raiz;
    protected int cont;

    public ArbolBin(){
        raiz=null;
        cont=0;
    }
    public ArbolBin(T elem){
        raiz= new NodoBin<T>(elem);
        cont=1;
    }
    
    @Override
    public boolean isEmpty() {
        return cont == 0;
    }

    @Override
    public int size() {
        return cont;
    }

    @Override
    public boolean contains(T elem) {
        boolean band = false;
        return contains(elem, raiz);
        
    }
    
    private boolean contains(T elem, NodoBin<T> nodo){
        if (nodo != null){
            if (nodo.getElem().equals(elem))
                return true;
            if (contains(elem, nodo.getIzq()))
                return true;
            else
                return contains(elem, nodo.getDer());
        
        }
        return false;
    
    }
    
    // Preorden, postorden, inotrden

    public Iterator<T> iteratorPreOrder(){
        ArrayList<T> lista = new ArrayList<T>();
        preOrden(raiz, lista);
        return lista.iterator();
    }
    
    private void preOrden(NodoBin<T> nodo, ArrayList<T> lista){
        if (nodo != null){
            lista.add(nodo.getElem());
            preOrden(nodo.getIzq(), lista);
            preOrden(nodo.getDer(), lista);
        
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayList<T> lista = new ArrayList<T>();
        postOrden(raiz, lista);
        return lista.iterator();
    }

    
    private void postOrden(NodoBin<T> nodo, ArrayList<T> lista){
        if (nodo != null){
            postOrden(nodo.getIzq(), lista);
            postOrden(nodo.getDer(), lista);
            lista.add(nodo.getElem());
        }
    
    }

    
    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayList<T> lista = new ArrayList<T>();
        inOrden(raiz, lista);
        return lista.iterator();
    }
    
    private void inOrden(NodoBin<T> nodo, ArrayList<T> lista){
        if (nodo != null){
            inOrden(nodo.getIzq(), lista);
            lista.add(nodo.getElem());
            inOrden(nodo.getIzq(), lista);
        }
        
    
    }
    
    public Iterator<T> iteratorPreOrder2(){
        return preOrder2(raiz);
    
    }
    
    private Iterator<T> preOrder2(NodoBin<T> nodo){
        ArrayList<T> lista = new ArrayList<T>();
        if (nodo == null){
            return lista.iterator();
        }
        
        Stack<NodoBin<T>> pilaNodo = new Stack<NodoBin<T>>();
        pilaNodo.push(nodo);
        
        while (!pilaNodo.empty()){
            NodoBin<T> nodito = pilaNodo.pop();
            lista.add(nodito.getElem());
            
            if (nodito.getDer() != null)
                pilaNodo.add(nodo.getDer());
            if(nodito.getIzq() != null)
                pilaNodo.add(nodo.getIzq());
        
        }
        
        return lista.iterator();
    
    }
    
    // Por nivel
    
    public Iterator<T> iteratorPorNivel(){
        return iteratorPorNivel(raiz);
    
    }
    
    private Iterator<T> iteratorPorNivel(NodoBin<T> nodo){
        ArrayList<T> lista = new ArrayList<T>();
        if (nodo == null)
            return lista.iterator();
        
        ArrayList<NodoBin<T>> bob = new ArrayList <NodoBin<T>>();
        bob.add(nodo);
        
        while (!bob.isEmpty()){
            NodoBin<T> nodito = bob.remove(0);
            
            if (nodito.getDer() != null)
                bob.add(nodo.getDer());
            if (nodito.getIzq() != null)
                bob.add(nodo.getIzq());
        
        }
        
        return lista.iterator();
    
    }
    
   
    
    public void imprimirPorNivel(){
        if (raiz == null){
            System.out.println("fuck");
            return;
        }
        
        ArrayList<NodoBin<T>> cola = new ArrayList<NodoBin<T>>();
        cola.add(raiz);
        
        while (!cola.isEmpty()){
            NodoBin<T> mynode = cola.get(0);
            System.out.print(mynode.elem + " ");
            cola.remove(0);
            
            if (mynode.getIzq() != null){
                cola.add(mynode.getIzq());
            }
            if (mynode.getDer() != null){
                cola.add(mynode.getDer());
            }
        
        }
    
    }

    
       
 }
    
    
        
    
    
    
    
    

