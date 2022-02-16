/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arboles;

/**
 *
 * @author javi
 */
public class ArbolBin <T> implements BinaryTreeADT<T>{
    
    public NodoBin<T> raiz;
    public int cont;

    @Override
    public boolean isEmpty() {
        return cont == 0;
    }

    @Override
    public int size() {
        return cont;
    }

    @Override
    public boolean contains(T elem) {
        return true;
    }
    
    
    
}
