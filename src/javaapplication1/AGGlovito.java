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
public class AGGlovito extends AG<Glovito>{
    
    public AGGlovito( int N ){
        super( new FGlovito(), N );
    }
    
    public Solucion generar(){
        return new Glovito();
    }

    public Solucion generar( int[] adn ){
        return new Glovito(adn);
    }    
    
    public static void main( String[] args ){
        AGGlovito ag =  new AGGlovito( 20 );
        ag.aplicar(100);
    }    
}
