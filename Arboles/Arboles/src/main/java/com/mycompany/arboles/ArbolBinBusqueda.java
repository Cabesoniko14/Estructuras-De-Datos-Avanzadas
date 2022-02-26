/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arboles;

/**
 *
 * @author javi
 */
public class ArbolBinBusqueda <T extends Comparable<T>> extends ArbolBin<T> implements BinaryTreeADT<T> {
    protected NodoBB<T> raiz;
    
    public ArbolBinBusqueda(){
        super();
    }
    
    public ArbolBinBusqueda(T elem){
        super(elem);
        raiz = new NodoBB<T>(elem);
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
        NodoBB<T> nuevo = new NodoBB<T>(elem);
        NodoBB<T> anterior = null;
        
        if (raiz == null){
            raiz = nuevo;
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
        
        anterior.cuelga(nuevo);
    
    }
    
    
    
}
