/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arboles;

/**
 *
 * @author javi
 */
public class NodoAVL<T extends Comparable<T>>{
    T elem;
    NodoAVL<T> izq, der,papa;
    int fe;
    int altura;
    int nivel;

    public NodoAVL (T dato){
    
        elem = dato;
        izq = null;
        der = null;
        papa=null;
        altura = 0;
    }


   public void setDer (NodoAVL<T> actual){
        der = actual;
    }
    public void setIzq (NodoAVL<T> actual){
        izq = actual;
    }
    public NodoAVL<T> getDer(){
      return der;
    }
    public NodoAVL<T> getIzq(){
      return izq;
    }
    public T getElem(){
        return elem;
    }
    public NodoAVL<T> getPapa(){
      return papa;
    }
    public void setPapa(NodoAVL<T> actual){
    papa=actual;
    }
    public void setElem(T elemento){
      elem=elemento;
    } 
    public void cuelga(NodoAVL<T> actual){ // le agregas el nodo actual y 
      if (actual==null)
        return;
      if(actual.getElem().compareTo(elem)<=0)
        izq=actual;
      else
        der=actual; 
      actual.setPapa(this);
    }
    
    public void actualizarFE(){
        
        if (izq == null){
            if (der == null)
                this.fe = 0;
            else
                this.fe = der.altura;
        }
        else{
            if (der == null)
                this.fe = -1*izq.altura;
            else
                this.fe = der.altura - izq.altura;
            
        
        }
    
    }
    
    public void actualizarAltura(){
        altura(this, 0);
        
    }
    
    private void altura(NodoAVL<T> nodo, int cont){
        int cont1 = 0;
        int cont2 = 0;
        if (nodo == null)
            this.altura = cont;
        else{
            cont1 = alturaR(nodo.getIzq(), cont+1);
            cont2 = alturaR(nodo.getDer(), cont+1);
        }
        this.altura = Math.max(cont1, cont2);
    }
    
    
    private int max(int a, int b){
        if (a >= b)
                return a;
        
        else
                return b;
    }
    
    
    
    
    
    // Métodos extra
    
    public int feR(){
        if (izq == null){
            if (der == null)
                return 0;
            else
                return der.altura;
        }
        else{
            if (der == null)
                return -1*izq.altura;
            else
                return der.altura - izq.altura;
            
        
        }
        
    }
    
    public int alturaR(){
        return alturaR(this, 0);
    }
    
    private int alturaR(NodoAVL<T> nodo, int cont){
        int cont1 = 0;
        int cont2 = 0;
        if (nodo == null)
            return cont;
        else{
            cont1 = alturaR(nodo.getIzq(), cont+1);
            cont2 = alturaR(nodo.getDer(), cont+1);
        }
        return Math.max(cont1, cont2);
    }
    
    


  
}