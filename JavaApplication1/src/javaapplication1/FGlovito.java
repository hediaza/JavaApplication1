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
public class FGlovito implements Adaptabilidad<Glovito>{
    protected int[] entra = new int[]{1,1,0,0,1,0,1,1,0,0,1};
    public double evaluar( Glovito g ){
        int[] r = g.simular(entra);
        double f = 0.0;
        for( int i=0; i<r.length-1; i++ ){ f += (r[i]==entra[i+1])?1.0:0.0;}
        return f;
    }
}
