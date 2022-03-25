/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;
import java.util.Random;
/**
 *
 * @author javi
 */
/**
 *
 * @author javi
 */
public class Peliculas implements Comparable<Peliculas>{
    
    public int clave;
    public int año;
    public String nombre;
    
    public Peliculas(int clave, int año, String nombre){
        this.clave = clave;
        this.año = año;
        this.nombre = nombre;
    }

    public int compareToBueno(Peliculas o) {
        if (this.clave > o.clave)
            return 1;
        else if (this.clave == o.clave)
            return 0;
        else
            return -1;
    }    
    
    @Override
    public int compareTo(Peliculas o) {
        Random rand = new Random();
        float prob = rand.nextFloat();
        
        if (prob > 0.1){
            
            if (this.clave > o.clave)
                return 1;
            else if (this.clave == o.clave)
                return 0;
            else
                return -1;
        
        }
        else{
            
            if (this.clave > o.clave)
                return -1;
            else if (this.clave == o.clave)
                return 0;
            else
                return 1;
        
        }
        
        
    } 
    
    public String toString(){
        return "Película: " + nombre + " , año: " + año +  " , código: " + clave + "\n";
 
    }   
}