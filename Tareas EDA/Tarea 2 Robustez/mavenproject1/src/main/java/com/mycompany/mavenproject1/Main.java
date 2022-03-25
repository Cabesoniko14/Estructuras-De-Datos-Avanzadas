/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.math.*;

/**
 *
 * @author javi
 */
public class Main <T extends Comparable<T>> {
    
    public static void main(String[] args)  throws FileNotFoundException  {
        
        Lector2 test = new Lector2();
        test.txtaLista("/Users/javi/Desktop/movie_titles2.txt"); 
        AlgoritmosOrdenamiento alg = new AlgoritmosOrdenamiento();
        
        // ENTRADA: n = 10
        
        
        // Tomar muestra de la lista
        
        Peliculas[] muestra1 = new Peliculas[1000];
        
        for (int i = 0; i < muestra1.length; i++){
            muestra1[i] = test.pelisArray[i];
        }
        
        Peliculas[] muestra2 = new Peliculas[1000];
        
        for (int i = 0; i < muestra2.length; i++){
            muestra2[i] = test.pelisArray[i];
        }
        
        alg.bubbleSort(muestra1);
        alg.mergeSortBueno(muestra2);
        
        // Insertion sort, selection sort,  andan atm
        // Aleatorizar pelisArray
        for (int i = 0; i< muestra1.length; i++){
            System.out.println(muestra1[i]);
        }
        
        System.out.println(alg.spearman(muestra1, muestra2));
    
    }

}