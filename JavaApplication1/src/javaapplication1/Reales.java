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
public class Reales extends Solucion{
    protected double[] vector;
    public Reales( int dim ){
        vector = new double[dim];
        for( int i=0; i<vector.length; i++ ){
            vector[i] = (5.12*2)*Math.random() - 5.12;
        }
    }
    
    public Reales( int[] adn ){
        vector = new double[adn.length/16];
        int k=0;
        for( int i=0; i<adn.length; i+=16){
            vector[k] = 0;
            int ac = 1;
            for( int j=0; j<16; j++ ){
                vector[k] += adn[i+j]*ac;
                ac *= 2;
            }
            vector[k] /= ac;
            vector[k] = (5.12*2)*vector[k] - 5.12; 
            k++;
        }
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for( int i=0; i<vector.length; i++ ){
                sb.append(vector[i]);
                sb.append(' ');
        }
        return sb.toString();
    }  
    
    public int[] codifica(){
        int[] adn = new int[vector.length*16];
        int k=0;
        for( int i=0; i<vector.length; i++ ){
            double x = (vector[i] + 5.12)/(5.12*2);
            int ac = (int)(x * (1<<16));
            for( int j=0; j<16; j++ ){
                adn[k] = ac % 2;
                ac /= 2;
                k++;
            }
        }
        return adn;
    }    
    
    public static void main( String[] args ){
        for( int i=0; i<10; i++ ){
            Reales r = new Reales(2);
            System.out.println(r);
            int[] adn = r.codifica();
            Reales r2 = new Reales( adn );
            System.out.println(r2);
        }    
    }
}