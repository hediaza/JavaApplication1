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
public class AproxFuncional implements Adaptabilidad<Reales>{
    
    public double valorReal( double x ){
        return 4*x*x*x*x + 3*x*x*x - 2*x*x + 3*x + 6.0;
    }

    public double valorCalculado( Reales r, double x ){
        return //r.vector[5]*x*x*x*x*x + 
               r.vector[4]*x*x*x*x + 
               r.vector[3]*x*x*x +
               r.vector[2]*x*x +
               r.vector[1]*x + 
               r.vector[0];
    }
    
    
    public double evaluar(Reales r){
        double f=0.0;
        for( double x=-2.0; x<=2.0; x+=0.2 ){
            double vr = valorReal(x);
            double vc = valorCalculado(r, x);
            f += (vr-vc)*(vr-vc);
        }
        return -f;
    }
}
