/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.selecciondirecta;

/**
 *
 * @author javi
 */
public class Prueba {
    
    public static void main(String[] args) {
        
        AlgOrdenamiento test = new AlgOrdenamiento();
        int datos[] = {1,8,0,3,2, 7, 12, 4};
        for (int j=0; j < 8; j++)
                System.out.print(datos[j] + " ");
        System.out.println("\n");
        
        test.mergeSort(datos);
        for (int j=0; j < 8; j++)
                System.out.print(datos[j] + " ");
    }
}
