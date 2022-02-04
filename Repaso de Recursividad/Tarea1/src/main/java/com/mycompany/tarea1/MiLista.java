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
import java.util.Stack;

public class MiLista<T>{
  Nodo<T> cabeza;
  int cont;

  public MiLista(){
    cabeza= new Nodo<T>(null);
    cont=0;
  }
  public void inserta(T elem){
    Nodo<T> actual, nuevo=new Nodo<T>(elem);
    actual=cabeza;
    while(actual.getSig()!=null)
      actual=actual.getSig();

    actual.setSig(nuevo);
    cont++;
  }
    public void insertaMejor(T elem){
      Nodo<T> nuevo=new Nodo<T>(elem);
      nuevo.setSig(cabeza.getSig());
      cabeza.setSig(nuevo);
      cont++;   
    }
  
  public void imprime(){
    Nodo<T> actual;
    actual=cabeza.getSig();
    while(actual!=null){
      System.out.println(actual.getElem());
      actual=actual.getSig();
    }

  }
  public void imprimeAlrevez(){//con Stack
    Stack<T> pila=new Stack<T>();
    Nodo<T> actual=cabeza.getSig();

    while(actual!=null){
      pila.push(actual.getElem());
      actual=actual.getSig();
    }

    while(!pila.isEmpty())
      System.out.println(pila.pop());


  }
  public void imprimeR(){
    imprimeR(cabeza.getSig());
  }
  private void imprimeR(Nodo<T> actual){
    if (actual==null)
      return;

    //Si intercambio las sigui
  //entes dos lineas cambio de 
    //imprimir al derecho y alrevez el contenido de la li
    System.out.println(actual.getElem());
    imprimeR(actual.getSig());

  }

  public int ContarElem(){
      return ContarElem(0,cabeza.getSig());
  }
  private int ContarElem(int c, Nodo<T> actual){
      if(actual==null)
          return c;
      return ContarElem(++c, actual.getSig());
  }

  private int otroCuenta(Nodo<T> actual){
    if (actual==null)
      return 0;
    return otroCuenta(actual.getSig())+1;
  }
  
  // Ejercicio 2. Invierte lista cambiando los apuntadores
  
  public void invierteLista(){
      Nodo<T> apuntador = cabeza.getSig();
      Nodo<T> actual = cabeza.getSig();
      if (actual == null)
          System.out.println("Lista vacía");
      
      else{
          while(actual.getSig() != null)
              actual = actual.getSig();
          cabeza.setSig(actual);
          invierteLista(apuntador, apuntador, actual);
          
      }
  }
  private void invierteLista(Nodo<T> inicio, Nodo<T> apuntador, Nodo<T> actual){
      
      if (actual == apuntador)
          actual.setSig(null);
      else{
          while (apuntador.getSig() != actual)
              apuntador = apuntador.getSig();
          actual.setSig(apuntador);
          invierteLista(inicio, inicio, apuntador);
      
      }
  
  }
  
  // 3. Invierte lista sin cambiar los apuntadores
  
  public void invierteListaS(){
      Nodo<T> inicio = cabeza.getSig();
      Nodo<T> fin = cabeza.getSig();
      if (inicio == null)
          System.out.println("Lista vacía");
      else{
          while(fin.getSig() != null)
              fin = fin.getSig();
          invierteListaS(inicio, inicio, fin, null);
      
      }
      
  }
  
  private void invierteListaS(Nodo<T> inicio, Nodo<T> apuntador, Nodo<T> fin, T dato){
      
      if ((inicio == fin) || (fin.getSig() == inicio))
          System.out.println("");
      else{
          while(apuntador.getSig() != fin)
              apuntador = apuntador.getSig();
          dato = fin.getElem();
          fin.setElem(inicio.getElem());
          inicio.setElem(dato);
          invierteListaS(inicio.getSig(), inicio.getSig(), apuntador, dato);
      }
  }
  
  // Solución al problema 4. 
  
  public void permuta(String s){
      permuta(s,"");
  }
  private void permuta(String s,String algo){
      if(s.length()==0){
          System.out.println(algo);
      }
      for(int i=0;i<s.length();i++){
          String c=s.substring(i,i+1);
          String resto=s.substring(0,i)+s.substring(i+1);
          permuta(resto,c+algo);
//System.out.println(resto);
      }
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public void permutaJ(String cad){
      permutaJ(cad, "");
  
  }
  
  
  private void permutaJ(String cad, String subcad){
      if (cad.length() == 0)
          System.out.println(subcad);
      
      for(int i = 0; i < cad.length(); i++)
          permutaJ(cad.substring(0, i) + cad.substring(i+1), cad.substring(i, i+1) + subcad);
  
  }
  
  
}
