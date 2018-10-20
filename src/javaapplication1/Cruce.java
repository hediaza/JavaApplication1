/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author EST_2F_MCA_000
 */
public class Cruce {
    public int[][] aplicar( int[] adn1, int[] adn2 ){
        int pc = 1+(int)(Math.random() * (adn1.length-1));
        int[] h1 = adn1.clone();
        int[] h2 = adn2.clone();
        for( int i=pc; i<h1.length; i++ ){
            h1[i] = adn2[i];
            h2[i] = adn1[i];
        }
        return new int[][]{h1,h2};         
    } 
}
