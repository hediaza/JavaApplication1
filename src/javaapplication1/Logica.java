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
public class Logica extends Solucion{
    protected int[] negaciones;
    public Logica() {
        negaciones = new int[4];
        for( int i=0; i<negaciones.length; i++){
            negaciones[i] = (Math.random()<0.5)?0:1;
        }
    }

    public Logica(int[] adn) {
       super( adn );
       negaciones = adn.clone();
    }
    
    public int[] codifica(){
        return negaciones.clone();
    }
    
    public boolean evaluar( boolean a, boolean b ){
        return ((negaciones[0]==1)?!a:a && (negaciones[1]==1)?!b:b ) || 
               ((negaciones[2]==1)?!a:a && (negaciones[3]==1)?!b:b );
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        if( negaciones[0]==1 ) sb.append('-');
        sb.append('a');
        sb.append(" y ");
        if( negaciones[1]==1 ) sb.append('-');
        sb.append('b');
        sb.append(')');
        sb.append(" o ");
        sb.append('(');
        if( negaciones[2]==1 ) sb.append('-');
        sb.append('a');
        sb.append(" y ");
        if( negaciones[3]==1 ) sb.append('-');
        sb.append('b');
        sb.append(')');
        return sb.toString();
    }
}
