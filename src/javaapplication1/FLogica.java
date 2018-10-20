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
public class FLogica implements Adaptabilidad<Logica>{
    public double evaluar( Logica logica ){
        double f=0.0;
        if( !logica.evaluar(false, false)) f++;
        if( logica.evaluar(false, true)) f++;
        if( logica.evaluar(true, false)) f++;
        if( !logica.evaluar(true, true)) f++;
        return f;
    }
}
