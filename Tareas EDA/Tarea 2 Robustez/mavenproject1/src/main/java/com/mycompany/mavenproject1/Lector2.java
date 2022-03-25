/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author javi
 */
public class Lector2 {
    public Peliculas[] pelisArray = new Peliculas[17770];
    
    public Peliculas convertirListaAPelicula(String[] arrPeli){
        int code = Integer.parseInt(arrPeli[0]);
        int año = Integer.parseInt(arrPeli[1]);
        String nomPeli = arrPeli[2];
        
        Peliculas peli = new Peliculas(code, año, nomPeli);
        return peli;
    
    }
    
    public void txtaLista(String nomArch) throws FileNotFoundException{
        try{
            File txt = new File(nomArch);
            Scanner scanner = new Scanner(txt);
            int i = 0;
            while(scanner.hasNextLine()){
            String[] list = scanner.nextLine().split(",", 3);
            Peliculas peli = convertirListaAPelicula(list);
            pelisArray[i] = peli;
            i++;
            }
        }
        catch (Exception e){
              System.out.println("Archivo inválido");
        
        }
    
    }
   }

