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
public class Mutacion {
    public int[] aplicar( int[] adn ){
        int[] h = adn.clone();
        double pm = 1.0/adn.length;
        for( int i=0; i<h.length; i++ ){
            if( Math.random() < pm ) h[i] = 1-h[i];
        }
        return h;
    }
}
