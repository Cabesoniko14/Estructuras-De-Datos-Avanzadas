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
    
    // Preorden, postOrden, inOrden iterativos
    public Iterator<T> preOrden2(){
        ArrayList<T> lista = new ArrayList<T>();
        Stack<NodoBin<T>> pila = new Stack<NodoBin<T>>();
        if (isEmpty())
            return lista.iterator();
        pila.add(raiz);
        
        while(!pila.empty()){
            NodoBin<T> actual = pila.pop();
            lista.add(actual.getElem());
            if (actual.getDer() != null)
                pila.add(actual.getDer());
            if (actual.getIzq() != null)
                pila.add(actual.getIzq());
        }
        
        return lista.iterator();
    
    }
    
    // Por nivel
    
    public Iterator<T> iteratorPorNivel(){
        ArrayList<T> lista = new ArrayList<T>();
        ArrayList<NodoBin<T>> cola = new ArrayList<NodoBin<T>>() {};
        if (isEmpty())
            return lista.iterator();
        cola.add(raiz);
        
        while(!cola.isEmpty()){
            NodoBin<T> actual = cola.remove(0);
            lista.add(actual.getElem());
            if (actual.getDer() != null)
                cola.add(actual.getDer());
            if (actual.getIzq() != null)
                cola.add(actual.getIzq());
        }
        
        return lista.iterator();
    
    }
    
}
