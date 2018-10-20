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
public class Rastrigin implements Adaptabilidad<Reales>{
        
    public double evaluar(Reales r){   
        double sumatoria = 0.0;
        double A = 10.0;
        double resultado;
        int n = r.vector.length;
                
        for (int i = 0; i < n; i++) {
            sumatoria += (r.vector[i] * r.vector[i]) - (A*Math.cos(2*Math.PI*r.vector[i]));
        }
        
        resultado = n * A + sumatoria;
        
        return -resultado;
    }
}
