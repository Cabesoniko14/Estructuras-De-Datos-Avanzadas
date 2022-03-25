/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arboles;

/**
 *
 * @author javi
 */
public class Main {
    
    public static void main(String[] args) {
        
      ArbolAVL test = new ArbolAVL();
      test.inserta(30);
      test.inserta(2);
      test.inserta(0);
      test.inserta(100);
      test.inserta(90);
      test.inserta(40);
      test.inserta(-100);
      test.inserta(20);
      test.inserta(1);
      test.inserta(-110);
      test.inserta(10);
     
      
      System.out.println("\n");
      test.imprimirPorNivel();
       
      test.borrar(2);
      System.out.println("\n");
      test.imprimirPorNivel();
       
      test.borrar(30);
      System.out.println("\n");
      test.imprimirPorNivel();
  
    }
    
}
