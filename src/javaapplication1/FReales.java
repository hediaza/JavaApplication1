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
public class FReales implements Adaptabilidad<Reales>{
   public double evaluar( Reales r ){
       double x = r.vector[0];
       double y = r.vector[1];
       return x*x+3*y+x*y-y*y-7*x;
   } 
}
