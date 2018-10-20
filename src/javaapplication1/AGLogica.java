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
public class AGLogica extends AG<Logica>{
    
    public AGLogica( int N ){
        super( new FLogica(), N );
    }
    
    public Solucion generar(){
        return new Logica();
    }

    public Solucion generar( int[] adn ){
        return new Logica(adn);
    }    
    
    public static void main( String[] args ){
        AGLogica ag =  new AGLogica( 10 );
        ag.aplicar(30);
    }
    
}
