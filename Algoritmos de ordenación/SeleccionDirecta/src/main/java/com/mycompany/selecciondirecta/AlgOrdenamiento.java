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
            int pivote = part(datos, min, max);
            quickSort(datos, min, pivote-1);
            quickSort(datos, pivote+1, max);
        
        }
    
    }
        
    private int part(int[] datos, int min, int max){
        
        if (min < max){
            if (datos[min] > datos [min+1]){  // SWAP por el siguiente y avanza MIN
                int aux = datos[min];
                datos[min] = datos[min+1];
                datos[min+1] = aux;
                return part(datos, min+1, max);
                
            }
            else{ // SWAP por el final y reduce MAX
                int aux = datos[min+1];
                datos[min+1] = datos[max];
                datos[max] = aux;
                return part(datos, min, max-1);
            }
        
        }
        else{
            return min;
        
        }
    }
    
    public void mergeSort(int[] datos){
        mergeSort(datos, 0, datos.length-1);
    
    }
    
    private void mergeSort(int[] datos, int min, int max){
        
        if (min < max){
            int mid = min + (max - min)/2;
            mergeSort(datos, min, mid);
            mergeSort(datos, mid+1, max);
            merge(datos, min, mid, max);
        }
    }
    
    private void merge(int[]datos, int izq, int mid, int der){
        
        // Creamos dos arrays temporales distintos para cada segmento del arreglo datos
        // Creamos sus tamaños, que servirán como límites para los while al copiar datos
        
        int limMid = mid - izq + 1;
        int limMax = der - mid;
        
        
        int arrIzq[] = new int[limMid];
        int arrDer[] = new int[limMax];
        
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
            if (arrIzq[i] <= arrDer[j]){
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
