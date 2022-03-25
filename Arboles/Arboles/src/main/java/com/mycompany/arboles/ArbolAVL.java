/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arboles;

import java.util.ArrayList;

/**
 *
 * @author javi
 */
public class ArbolAVL <T extends Comparable<T>> extends ArbolBin<T> implements BinaryTreeADT<T> {
    
    protected NodoAVL<T> raiz;
    
    public ArbolAVL(){
        super();
    }
    
    public ArbolAVL(T elem){
        super(elem);
        raiz = new NodoAVL<T>(elem);
    }
    
    public NodoAVL<T> busca(T elem){
        return busca(elem, this.raiz);
    }
    
    private NodoAVL<T> busca(T elem, NodoAVL<T> nodo){
        if (nodo == null)
            return null;
        NodoAVL<T> aux;
        if (nodo.getElem().compareTo(elem) == 0){
            return nodo;
        }
        else{
            if (nodo.getElem().compareTo(elem) > 0){
                aux = busca(elem, nodo.getIzq());
                return aux;
            }
            else{
                aux = busca(elem, nodo.getDer());
                return aux;
            
            }
        
        }
    
    }
    
    public void imprimirPorNivel(){
        if (raiz == null){
            return;
        }
        
        ArrayList<NodoAVL<T>> cola = new ArrayList<NodoAVL<T>>();
        cola.add(raiz);
        
        while (!cola.isEmpty()){
            NodoAVL<T> nodito = cola.get(0);
            System.out.print("Elemento del nodo: " + nodito.elem + ", factor de equilibrio:  " + nodito.fe + ", altura: " + nodito.altura + "\n");
            cola.remove(0);
            
            if (nodito.getIzq() != null){
                cola.add(nodito.getIzq());
            }
            if (nodito.getDer() != null){
                cola.add(nodito.getDer());
            }
        
        }
    
    }
    
    public void inserta(T elem){
        if (busca(elem) != null)
            return;
        NodoAVL<T> actual = inserta2(elem);
        NodoAVL<T> papa = actual.papa;
        int alturaVieja;
        boolean termine = false;
        
        while (!termine && papa != null){
            alturaVieja = papa.altura;
            papa.actualizarAltura();
            papa.actualizarFE();
            
            
            if (vabs(papa.fe) > 1){
                papa = rotar(papa); 
                
            
            }
            
            if (alturaVieja == papa.altura) 
                termine = true;
            papa = papa.papa;
         
        }
        
    }
    
    private NodoAVL<T> rotar(NodoAVL<T> actual){
        NodoAVL papa = actual.papa;
        
        // IZQ - IZQ
        
        if (actual.fe == -2  && (actual.izq.fe == -1 || actual.izq.fe == 0)){
            NodoAVL<T> alfa = actual;
            NodoAVL<T> beta = alfa.izq;
            NodoAVL<T> D = alfa.der;
            NodoAVL<T> gamma = beta.izq;
            NodoAVL<T> C = beta.der;
            NodoAVL<T> A = gamma.izq;
            NodoAVL<T> B = gamma.der;
            if (A != null)
                gamma.cuelga(A);
            else
                gamma.izq = null;
            if (B != null)
                gamma.cuelga(B);
            else
                gamma.der = null;
            if (C != null)
                alfa.cuelga(C);
            else
                alfa.izq = null;
            if (D != null)
                alfa.cuelga(D);
            else
                alfa.der = null;
            
            beta.cuelga(alfa);
            beta.cuelga(gamma);
            if (papa!=null)
                papa.cuelga(beta);
            else
                raiz = beta;
            beta.papa=papa;
            gamma.actualizarAltura();
            gamma.actualizarFE();
            alfa.actualizarAltura();
            alfa.actualizarFE();
            beta.actualizarAltura();
            beta.actualizarFE();
            
            
            return beta;
        
        }
        
        // DER - IZQ
        
        // Se hace de abajo hacia arriba. Las fe de los nodo hoja no cambia
        
        if (actual.fe == 2 && (actual.der.fe == -1)){
            
            NodoAVL<T> alfa = actual;
            NodoAVL<T> A = alfa.izq;
            NodoAVL<T> beta = alfa.der;
            NodoAVL<T> gamma = beta.izq;
            NodoAVL<T> D = beta.der;
            NodoAVL<T> B = gamma.izq;
            NodoAVL<T> C = gamma.der;
            
            if (A != null)
                alfa.cuelga(A);
            else
                alfa.izq = null;
            if (B != null)
                alfa.cuelga(B);
            else
                alfa.der = null;
            if (C != null)
                beta.cuelga(C);
            else
                beta.izq = null;
            if (D != null)
                beta.cuelga(D);
            else
                beta.der = null;
            
            gamma.cuelga(alfa);
            gamma.cuelga(beta);
            if (papa != null)
                papa.cuelga(gamma);
            else
                raiz = gamma;
            gamma.papa= papa;
            gamma.actualizarAltura();
            gamma.actualizarFE();
            alfa.actualizarAltura();
            alfa.actualizarFE();
            beta.actualizarAltura();
            beta.actualizarFE();
            
            
            return gamma;
        
        }
        
        // IZQ - DER
        
        if (actual.fe == - 2 && (actual.izq.fe == 1)){
            NodoAVL<T> alfa = actual;
            NodoAVL<T> beta = alfa.izq;
            NodoAVL<T> D = alfa.der;
            NodoAVL<T> A = beta.izq;
            NodoAVL<T> gamma = beta.der;
            NodoAVL<T> B = gamma.izq;
            NodoAVL<T> C = gamma.der;
            
            if (A != null)
                beta.cuelga(A);
            else
                beta.izq = null;
            if (B != null)
                beta.cuelga(B);
            else
                beta.der = null;
            if (C != null)
                alfa.cuelga(C);
            else
                alfa.izq = null;
            if (D != null)
                alfa.cuelga(D);
            else
                alfa.der = null;
            gamma.cuelga(beta);
            gamma.cuelga(alfa);
            if (papa != null)
                papa.cuelga(gamma);
            else
                raiz = gamma;
            gamma.papa = papa;
            
            alfa.actualizarAltura();
            alfa.actualizarFE();
            beta.actualizarAltura();
            beta.actualizarFE();
            gamma.actualizarAltura();
            gamma.actualizarFE();
            
            return gamma;
            
        
        }
        
        // DER - DER
        
        if (actual.fe == 2 && (actual.der.fe == 1 || actual.der.fe == 0)){
            NodoAVL<T> alfa = actual;
            NodoAVL<T> A = alfa.izq;
            NodoAVL<T> beta = alfa.der;
            NodoAVL<T> B = beta.izq;
            NodoAVL<T> gamma = beta.der;
            NodoAVL<T> C = gamma.izq;
            NodoAVL<T> D = gamma.der;
            
            if (A != null)
                alfa.cuelga(A);
            else
                alfa.izq = null;
            if (B != null)
                alfa.cuelga(B);
            else
                alfa.der = null;
            if (C != null)
                gamma.cuelga(C);
            else
                gamma.izq = null;
            if (D != null)
                gamma.cuelga(D);
            else
                gamma.der = null;
            beta.cuelga(alfa);
            beta.cuelga(gamma);
            if (papa != null)
                papa.cuelga(beta);
            else
                raiz = beta;
            beta.papa=papa;
            
            alfa.actualizarAltura();
            alfa.actualizarFE();
            beta.actualizarAltura();
            beta.actualizarFE();
            gamma.actualizarAltura();
            gamma.actualizarFE();
            
            return beta;
            
        }
        
        return null;
    
    }
    
    
    
    public void borrar(T elem){
        NodoAVL<T> actual;
        
        actual = borra(elem); // que me regrese el papá del nodo que eliminé
        
        if (actual == null){ // En caso de que borra deje el árbol vacío
            return;
        }
        
        
        boolean termine = false;
        int alturaVieja;
        while (!termine && actual != null){
            alturaVieja = actual.altura;
            actual.actualizarAltura();
            actual.actualizarFE();
            
            
            if (vabs(actual.fe) > 1){
                actual = rotar(actual); 
                
            
            }
            
            if (alturaVieja == actual.altura) 
                termine = true;
            actual = actual.papa;
         
        }
    
    }
  
//    public void borrarAVL(T elem){
//        
//        NodoAVL<T> actual;
//        
//        actual = borra(elem); // que me regrese el papá del nodo que eliminé
//        
//        if (actual == null){ // En caso de que borra deje el árbol vacío
//            return;
//        }
//        
//        int hant = actual.altura; 
//        int hactual = actual.altura + 1;
//        
//        if (actual == raiz){
//            
//            actual.actualizarAltura();
//            actual.actualizarFE();
//            if (vabs(actual.fe) > 1 )// en valor absoluto
//                actual = rotar(actual);
//        
//        }
//        
//        
//        while (actual != raiz && hant!=hactual){
//            actual = actual.papa;
//            hant = actual.altura;
//            actual.actualizarAltura();
//            actual.actualizarFE();
//            if (vabs(actual.fe) > 1 )// en valor absoluto
//                actual = rotar(actual);
//            hactual = actual.altura;
//            
//            
//        
//        }
//        
//        
//        
//        
//        
//    
//    }
//    
    
    
   

     
    
    // Métodos privados
    
    
    private NodoAVL<T> borra (T elem){ // A MODIFICAR PARA QUE REGRESE EL NODO DE CUYO PAPA COMIENZO A ACTUALIZAR (Izq o der?)
        NodoAVL<T> actual = busca(elem);
        NodoAVL<T> papaElim = null;
        
        if (actual == null)
            return null;
        
        if (actual.getDer() == null && actual.getIzq() == null){
            if (actual == raiz){
                raiz = null;
                
            
            }
            else{
                papaElim = actual.getPapa();
                if (actual == actual.getPapa().getIzq())
                    actual.getPapa().setIzq(null);
                else
                    actual.getPapa().setDer(null);
                
                
                
            }
            cont--;
            
            return papaElim;
        }
        
        // Solo tiene un hijo
        
        else if (actual.getIzq() == null || actual.getDer() == null){ // No es necesario que sea exlusivo
            NodoAVL<T> hijo;
            papaElim = actual.getPapa();
            
            if (actual.getIzq() != null){
                hijo = actual.getIzq();
            }
            else{
                hijo = actual.getDer();
            }
            
            
            if (actual == raiz){
                raiz = hijo;
            }
            
            else{
                actual.getPapa().cuelga(hijo); // Reemplaza al actual por el hijo no null 
                
            }
            


            cont--;
            
            return papaElim;
        }
        
        // Tiene dos hijos
        
        
        else if (actual.getIzq() != null && actual.getDer() != null){
            
            // Conseguir sucesor in orden
            
            NodoAVL<T> inOrden = actual.getDer();
            while(inOrden.getIzq() != null){
                inOrden = inOrden.getIzq();
            }
            
            actual.setElem(inOrden.getElem());
            
            // Preguntar si in Orden tiene hijo
            
            papaElim = inOrden.getPapa();
            
            if (inOrden.getDer() == null){
                if (inOrden.getPapa().getIzq() == inOrden)
                    inOrden.getPapa().setIzq(null);
                else
                    inOrden.getPapa().setDer(null);
            }
            else{
                inOrden.getPapa().cuelga(inOrden.getDer());
            }
            
            cont--;
        } 
        
        return papaElim;
        
    }

    
    private NodoAVL<T> inserta2(T elem){
        NodoAVL<T> actual = raiz;
        NodoAVL<T> anterior = raiz;
        
        if (raiz == null){
            raiz = new NodoAVL<T>(elem);
            cont++;
             raiz.actualizarAltura();
             raiz.actualizarFE();
            return raiz;
        }
        while (actual != null){
            anterior = actual;
            if (elem.compareTo(actual.getElem()) < 0){
                actual = actual.getIzq();
            }
            else
                actual = actual.getDer();
        
        }
        NodoAVL<T> nuevo = new NodoAVL<T>(elem);
        anterior.cuelga(nuevo);
        cont++;
        
        nuevo.actualizarAltura();
        nuevo.actualizarFE();
        
        return nuevo;
    
    }
    
    private int vabs(int dato){
        if (dato >= 0)
            return dato;
        else
            return dato*-1;
    
    }
    
    
  
    
    

}
   
    
    
