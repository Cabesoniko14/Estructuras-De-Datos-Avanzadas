/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arboles;

import java.util.Iterator;

/**
 *
 * @author javi
 */
public interface BinaryTreeADT <T>{
    public boolean isEmpty();
    public int size();
    public boolean contains(T elem);
    public Iterator<T> iteratorPreOrder();
    public Iterator<T> iteratorPostOrder();
    public Iterator<T> iteratorInOrder();
    public Iterator<T> iteratorPorNivel();
    
}
