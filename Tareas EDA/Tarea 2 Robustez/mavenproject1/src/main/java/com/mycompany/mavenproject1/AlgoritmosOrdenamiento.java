/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.sql.Array;
import java.math.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author javi
 */

public class AlgoritmosOrdenamiento <T extends Comparable<T>>{
    
    public int cont = 0;
    
    // 1. Selection sort
    
    public void selectionSort(T arr[])
    {
        int n = arr.length;
  
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j].compareTo(arr[min_idx]) < 0)
                    min_idx = j;
  
            // Swap the found minimum element with the first
            // element
            T temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
    
    // 2. Insertion sort
    
    public void insertionSort(T[] datos){
        
        
        int l = datos.length;
       
        
        for (int i = 1; i < l; i++){
            int j = i - 1;
            T aux = datos[i]; // hasta donde llega la iteración actual
            
            while (j >= 0 && datos[j].compareTo(aux) > 0){
                cont++;
                datos[j + 1] = datos[j];
                j = j - 1;
            
            }
            datos[j+1] = aux;
        
        }
        
    }
    
   
    
    // 3. Quick Sort recursivo
    
    public void quickSort(T[] datos){
        quickSort(datos, 0, datos.length-1);
    }
     
    private void quickSort(T[] datos, int min, int max){
        
        if (min < max){
            int pivote = part(datos, min, max);
            quickSort(datos, min, pivote-1);
            quickSort(datos, pivote+1, max);
        
        }
    
    }
        
    private int part(T[] datos, int min, int max){
        
        if (min < max){
            if (datos[min].compareTo(datos[min+1]) > 0){  // SWAP por el siguiente y avanza MIN
                cont++;
                T aux = datos[min];
                datos[min] = datos[min+1];
                datos[min+1] = aux;
                return part(datos, min+1, max);
                
            }
            else{ // SWAP por el final y reduce MAX
                cont++;
                T aux = datos[min+1];
                datos[min+1] = datos[max];
                datos[max] = aux;
                return part(datos, min, max-1);
            }
        
        }
        else{
            return min;
        
        }
    }
        
        // 4. Merge sort recursivo
        
    public void mergeSort(T[] datos){
        mergeSort(datos, 0, datos.length-1);
    }
    
    private void mergeSort(T[] datos, int min, int max){
        
        if (min < max){
            int mitad = (max-min)/2 + min;
            mergeSort(datos, min, mitad);
            mergeSort(datos, mitad+1, max);
            merge(datos, min, mitad, max);
        }
    
    }
    
    
    private void merge(T[]datos, int izq, int mid, int der){
        
        // Creamos dos arrays temporales distintos para cada segmento del arreglo datos
        // Creamos sus tamaños, que servirán como límites para los while al copiar datos
        
        int limMid = mid - izq + 1;
        int limMax = der - mid;
        
        T[] arrIzq = (T[]) new Comparable[limMid];
        T[] arrDer = (T[]) new Comparable[limMax];
        
        // Copiar arreglo izquierdo
        
        for (int i = 0; i < limMid; ++i)
            arrIzq[i] = datos[izq + i];
        
        for (int j = 0; j < limMax; ++j){
            arrDer[j] = datos[mid + 1 + j];
        }
        
        
        int k = izq;
        int i = 0;
        int j = 0;
        while (i < limMid && j < limMax){
            cont++;
            if (arrIzq[i].compareTo(arrDer[j]) <= 0){
                datos[k] = arrIzq[i];
                i++;
            }
            else{
                datos[k] = arrDer[j];
                j++;
            }
            k++;
        }
        
        while(i < limMid){
            datos[k] = arrIzq[i];
            i++;
            k++;
            
        }
        
        while (j < limMax){
            datos[k] = arrDer[j];
            j++;
            k++;
        
        }
    
    }
    
    // Bubble Sort
    
    public void bubbleSort(T arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j].compareTo(arr[j+1]) > 0)
                {
                    // swap arr[j+1] and arr[j]
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
    
    
    /// PARA ORDENAR BIEN
    
    public void selectionSortBueno(Peliculas arr[])
    {
        int n = arr.length;
  
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j].compareToBueno(arr[min_idx]) < 0)
                    min_idx = j;
  
            // Swap the found minimum element with the first
            // element
            Peliculas temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
    
    // 2. Insertion sort
    
    public void insertionSortBueno(Peliculas[] datos){
        
        
        int l = datos.length;
       
        
        for (int i = 1; i < l; i++){
            int j = i - 1;
            Peliculas aux = datos[i]; // hasta donde llega la iteración actual
            
            while (j >= 0 && datos[j].compareToBueno(aux) > 0){
                cont++;
                datos[j + 1] = datos[j];
                j = j - 1;
            
            }
            datos[j+1] = aux;
        
        }
        
    }
    
   
    
    // 3. Quick Sort recursivo
    
    public void quickSortBueno(Peliculas[] datos){
        quickSortBueno(datos, 0, datos.length-1);
    }
     
    private void quickSortBueno(Peliculas[] datos, int min, int max){
        
        if (min < max){
            int pivote = partBueno(datos, min, max);
            quickSortBueno(datos, min, pivote-1);
            quickSortBueno(datos, pivote+1, max);
        
        }
    
    }
        
    private int partBueno(Peliculas[] datos, int min, int max){
        
        if (min < max){
            if (datos[min].compareToBueno(datos[min+1]) > 0){  // SWAP por el siguiente y avanza MIN
                cont++;
                Peliculas aux = datos[min];
                datos[min] = datos[min+1];
                datos[min+1] = aux;
                return partBueno(datos, min+1, max);
                
            }
            else{ // SWAP por el final y reduce MAX
                cont++;
                Peliculas aux = datos[min+1];
                datos[min+1] = datos[max];
                datos[max] = aux;
                return partBueno(datos, min, max-1);
            }
        
        }
        else{
            return min;
        
        }
    }
        
        // 4. Merge sort recursivo
        
    public void mergeSortBueno(Peliculas[] datos){
        mergeSortBueno(datos, 0, datos.length-1);
    }
    
    private void mergeSortBueno(Peliculas[] datos, int min, int max){
        
        if (min < max){
            int mitad = (max-min)/2 + min;
            mergeSortBueno(datos, min, mitad);
            mergeSortBueno(datos, mitad+1, max);
            mergeBueno(datos, min, mitad, max);
        }
    
    }
    
    
    private void mergeBueno(Peliculas[]datos, int izq, int mid, int der){
        
        // Creamos dos arrays temporales distintos para cada segmento del arreglo datos
        // Creamos sus tamaños, que servirán como límites para los while al copiar datos
        
        int limMid = mid - izq + 1;
        int limMax = der - mid;
        
        Peliculas[] arrIzq = new Peliculas[limMid];
        Peliculas[] arrDer = new Peliculas[limMax];
        
        // Copiar arreglo izquierdo
        
        for (int i = 0; i < limMid; ++i)
            arrIzq[i] = datos[izq + i];
        
        for (int j = 0; j < limMax; ++j){
            arrDer[j] = datos[mid + 1 + j];
        }
        
        
        int k = izq;
        int i = 0;
        int j = 0;
        while (i < limMid && j < limMax){
            cont++;
            if (arrIzq[i].compareToBueno(arrDer[j]) <= 0){
                datos[k] = arrIzq[i];
                i++;
            }
            else{
                datos[k] = arrDer[j];
                j++;
            }
            k++;
        }
        
        while(i < limMid){
            datos[k] = arrIzq[i];
            i++;
            k++;
            
        }
        
        while (j < limMax){
            datos[k] = arrDer[j];
            j++;
            k++;
        
        }
    
    }
    
    // Bubble Sort
    
    public void bubbleSortBueno(Peliculas arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j].compareToBueno(arr[j+1]) > 0)
                {
                    // swap arr[j+1] and arr[j]
                    Peliculas temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
    
    ///////// Spearman
    
    public Double spearman(Peliculas [] X, Peliculas [] Y) {
        /* Error check */
        if (X == null || Y == null || X.length != Y.length) {
            return null;
        }
        
        /* Create Rank arrays */
        int [] rankX = getRanks(X);
        int [] rankY = getRanks(Y);

        /* Apply Spearman's formula */
        int n = X.length;
        double numerator = 0;
        for (int i = 0; i < n; i++) {
            numerator += Math.pow((rankX[i] - rankY[i]), 2);
        }
        
        numerator *= 6;
        return 1 - numerator / (n * ((n * n) - 1));
    }
    
    public static int[] getRanks(Peliculas [] array) {
        int n = array.length;
        
        /* Create Pair[] and sort by values */
        Par [] pair = new Par[n];
        for (int i = 0; i < n; i++) {
            pair[i] = new Par(i, array[i].clave);
        }
        Arrays.sort(pair, new PairValueComparator());

        /* Create and return ranks[] */
        int [] ranks = new int[n];
        int rank = 1;
        for (Par p : pair) {
            ranks[p.index] = rank++;
        }
        return ranks;
    }
    
    

    
    
}
    
    

