/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arboles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author javi
 */
public class ArbolBinBusqueda <T extends Comparable<T>> extends ArbolBin<T> implements BinaryTreeADT<T> {
    NodoBB<T> raiz;
    int cont;
    
    public ArbolBinBusqueda(){
        cont = 0;
        raiz = null;
    }
    
    public ArbolBinBusqueda(T elem){
        raiz = new NodoBB<T>(elem);
        cont = 1;
        
    }
    
    public NodoBB<T> search(T elem){
        return search(elem, raiz);
    }
    
    private NodoBB<T> search(T elem, NodoBB<T> nodo){
        if (nodo == null)
            return null;
        NodoBB<T> aux;
        if (nodo.getElem().compareTo(elem) == 0){
            return nodo;
        }
        else{
            if (nodo.getElem().compareTo(elem) > 0){
                aux = search(elem, nodo.getIzq());
                return aux;
            }
            else{
                aux = search(elem, nodo.getDer());
                return aux;
            
            }
        
        }
    
    }
    
    public void inserta(T elem){
        NodoBB<T> actual = raiz;
        NodoBB<T> anterior = raiz;
        
        if (raiz == null){
            raiz = new NodoBB<T>(elem);
            cont++;
            return;
        }
        while (actual != null){
            anterior = actual;
            if (elem.compareTo(actual.getElem()) < 0){
                actual = actual.getIzq();
            }
            else
                actual = actual.getDer();
        
        }
        
        anterior.cuelga(new NodoBB<T>(elem));
        cont++;
    
    }
    
    public void borra (T elem){
        NodoBB<T> actual = search(elem);
        
        if (actual == null)
            return;
        
        // Nodo hoja 
        
        if (actual.getDer() == null && actual.getIzq() == null){
            if (actual == raiz){
                raiz = null; 
            
            }
            else{ 
                
                if (actual == actual.getPapa().getIzq())
                    actual.getPapa().setIzq(null);
                else
                    actual.getPapa().setDer(null);
            }
            cont--;
        }
        
        // Solo tiene un hijo
        
        else if (actual.getIzq() == null || actual.getDer() == null){ // No es necesario que sea exlusivo
            NodoBB<T> hijo;
            if (actual.getIzq() != null){
                hijo = actual.getIzq();
            }
            else{
                hijo = actual.getDer();
            }
           
            
            if (actual == raiz){
                raiz = hijo;
            }
            
            else{
                actual.getPapa().cuelga(hijo); // Reemplaza al actual por el hijo no null 
                
            }


            cont--;
        }
        
        // Tiene dos hijos
        
        
        else if (actual.getIzq() != null && actual.getDer() != null){
            
            // Conseguir sucesor in orden
            
            NodoBB<T> inOrden = actual.getDer();
            while(inOrden.getIzq() != null){
                inOrden = inOrden.getIzq();
            }
            
            actual.setElem(inOrden.getElem());
            
            // Preguntar si in Orden tiene hijo
            
            if (inOrden.getDer() == null){
                if (inOrden.getPapa().getIzq() == inOrden)
                    inOrden.getPapa().setIzq(null);
                else
                    inOrden.getPapa().setDer(null);
            }
            else{
                inOrden.getPapa().cuelga(inOrden.getDer());
            }
            
            cont--;
        } 
        
    }
    
    // Áltura de un árbol
    
    public int altura(){
        return altura(raiz, 0);
    }
    
    private int altura(NodoBB<T> nodo, int cont){
        int cont1 = 0;
        int cont2 = 0;
        if (nodo == null)
            return cont;
        else{
            cont1 = altura(nodo.getIzq(), cont+1);
            cont2 = altura(nodo.getDer(), cont+1);
        }
        return Math.max(cont1, cont2);
    }
    
    private int max(int a, int b, int c){
        if (a >= b){
            if (a>= c)
                return a;
            else
                return c;
        
        }
        else{
            if (b >= c)
                return b;
            else
                return c;
        
        }
    
    }
    
    
    
    
    
    // LO QUE TUVE QUE AGREGAR PARA QUE FUNCIONE EL PROGRAMA 
    
    
    
    
    
    
    
    
    
    
    public Iterator<T> iteratorPreOrder(){
        ArrayList<T> lista = new ArrayList<T>();
        preOrden(raiz, lista);
        return lista.iterator();
    }
    
    private void preOrden(NodoBB<T> nodo, ArrayList<T> lista){
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

    
    private void postOrden(NodoBB<T> nodo, ArrayList<T> lista){
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
    
    private void inOrden(NodoBB<T> nodo, ArrayList<T> lista){
        if (nodo != null){
            inOrden(nodo.getIzq(), lista);
            lista.add(nodo.getElem());
            inOrden(nodo.getIzq(), lista);
        }
        
    
    }
    
    public Iterator<T> iteratorPreOrder2(){
        return preOrder2(raiz);
    
    }
    
    private Iterator<T> preOrder2(NodoBB<T> nodo){
        ArrayList<T> lista = new ArrayList<T>();
        if (nodo == null){
            return lista.iterator();
        }
        
        Stack<NodoBB<T>> pilaNodo = new Stack<NodoBB<T>>();
        pilaNodo.push(nodo);
        
        while (!pilaNodo.empty()){
            NodoBB<T> nodito = pilaNodo.pop();
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
    
    private Iterator<T> iteratorPorNivel(NodoBB<T> nodo){
        ArrayList<T> lista = new ArrayList<T>();
        if (nodo == null)
            return lista.iterator();
        
        ArrayList<NodoBB<T>> bob = new ArrayList <NodoBB<T>>();
        bob.add(nodo);
        
        while (!bob.isEmpty()){
            NodoBB<T> nodito = bob.remove(0);
            
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
        
        ArrayList<NodoBB<T>> cola = new ArrayList<NodoBB<T>>();
        cola.add(raiz);
        
        while (!cola.isEmpty()){
            NodoBB<T> mynode = cola.get(0);
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

