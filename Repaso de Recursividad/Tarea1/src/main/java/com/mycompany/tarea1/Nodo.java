/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea1;

/**
 *
 * @author javi
 */
public class Nodo<T>{
  T elemento;
  Nodo<T> sig;
  Nodo(T elem){
    elemento=elem;
    sig=null;
  }
  public Nodo<T> getSig(){
    return sig;
  }
  public void setSig(Nodo<T> siguiente){
    sig=siguiente;
  }
  public void setElem(T elem){
    elemento=elem;
  }
  public T getElem(){
    return elemento;
  }
}