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
public class AlgOrdenamiento <T>{
    
    // Sol. Esponda
    public void seleccionDirecta(int[] datos){
        int i;
        int j;
        int min;
        
        
        for (i = 0; i< datos.length - 1; i++){
            min = i;
            for (j = i+1; j<datos.length; j++){
                if (datos[min] > datos[j]){
                    min = j;
                }
            }
            int aux = datos[min];
            datos[min] = datos[i];
            datos[i] = aux;
        
        }
    
    }
    
    // Sol. kabik
    
    public void selDirR(int[] datos){
        
        selDirR(datos, 0, 0, 0);
    
    }
    
    private void selDirR(int[] datos, int min, int i, int j){
        if(j<datos.length){
            if(datos[min] > datos[j])
                selDirR(datos, j, i, j+1);
            else
                selDirR(datos, min, i, j+1);
        }
        else{
            if(i<datos.length-1){
                int aux = datos[i];
                datos[i] = datos[min];
                datos[min] = aux;
                selDirR(datos, i+1,i+1, i+1);
            }
        }
    }
    
    public void inserDirec(int[] datos){
        
        int i;
        int lim;
        int aux;
        
        for(i = 0; i < datos.length - 1; i ++){
            lim = i+1;
            while (lim > 0 && (datos[lim] <= datos[lim - 1])){
                aux = datos[lim];
                datos[lim] = datos[lim-1];
                datos[lim - 1] = aux;
                lim--;
            
            }
            
        
        }
    
    }
    
    public void inserDirR(int[] datos){
        if(!(datos.length <= 1))
           inserDirR(datos, 1);
    
    }
    
    private void inserDirR(int[] datos, int lim){
        
        if(lim <datos.length)
            inserDirR(datos, lim, lim);
        
    
    }
    
    private void inserDirR(int[]datos, int lim, int i){
        if (i > 0 && (datos[i] < datos[i-1])){
            int aux = datos[i];
            datos[i] = datos[i-1];
            datos[i-1] = aux;
            inserDirR(datos, lim, i-1);
        }
        else
            inserDirR(datos, lim +1);
    }
    
    // Quick Sort recursivo
    
    public void quickSort(int[] datos){
        quickSort(datos, 0, datos.length-1);
        
    
    }
     
    private void quickSort(int[] datos, int min, int max){
        
        if (min < max){
            int pivote = part(datos, min, max -1, max);
            quickSort(datos, min, pivote-1);
            quickSort(datos, pivote+1, max);
        
        }
    
    }
        
    private int part(int[] datos, int i, int j, int pivPos){
        if (i < j){
            while(datos[i] < datos[pivPos] && i < j)
                i++;
            while(datos[j] > datos[pivPos] && i < j)
                j--;
            int aux = datos[i];
            datos[i] = datos[j];
            datos[j] = aux;
            return part(datos, i+1, j-1, pivPos);
        
        }
        else{
            int aux2 = datos[i];
            datos[i] = datos[pivPos];
            datos[pivPos] = aux2;
            return i;
        }
    
    }
    
    // Bubble sort
    

    
    public void bubbleSortR(int[] arr){
        
        bubbleSortR(arr, arr.length-1, 0);
    
    }
    
    private void bubbleSortR(int[] arr, int lim, int i){
        if (lim > 0){
        
            if (i < lim){
                if (arr[i] > (arr[i+1])){
                int aux = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = aux;
                }
                bubbleSortR(arr, lim, i+1);
            }
            else
                bubbleSortR(arr, lim-1, 0);
        
        }
        
        
    
    }
    
    
}
