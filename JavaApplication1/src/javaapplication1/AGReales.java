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
public class AGReales extends AG<Reales>{
    public static int dim;
    public AGReales( Adaptabilidad<Reales> f, int N ){
        super( f, N );
    }
    
    public Solucion generar(){
        return new Reales(dim);
    }

    public Solucion generar( int[] adn ){
        return new Reales(adn);
    }    
    
    public static void main( String[] args ){
        AGReales.dim = 10;        
        AGReales ag =  new AGReales( new Rastrigin(), 200 );
        ag.aplicar(1000);
    }    
}
