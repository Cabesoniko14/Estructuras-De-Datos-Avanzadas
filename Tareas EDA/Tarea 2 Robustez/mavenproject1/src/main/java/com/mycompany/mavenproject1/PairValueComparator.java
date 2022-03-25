/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Comparator;

/**
 *
 * @author javi
 */
public class PairValueComparator implements Comparator<Par> {
    
    public int compare(Par p1, Par p2) {
            if (p1.value < p2.value) {
                return -1;
            } else if (p1.value > p2.value) {
                return 1;
            } else {
                return 0;
            }
        }
    
}
