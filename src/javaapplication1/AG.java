/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author EST_2F_MCA_000
 */
public abstract class AG<T> {
    protected Adaptabilidad<T> f;
    protected Cruce c = new Cruce();
    protected Mutacion m = new Mutacion();
    protected Solucion gDios;
    protected int[][] poblacion;
    protected double[] queBuenoSoy;
    
    public AG( Adaptabilidad<T> f, int N ){
        poblacion = new int[N][];
        queBuenoSoy = new double[N];
        for( int i=0; i<N; i++ ){
            gDios = generar();
            poblacion[i] = gDios.codifica();
            queBuenoSoy[i] = f.evaluar((T)gDios);
        }
        this.f = f;
    }
    
    public abstract Solucion generar();

    public abstract Solucion generar( int[] adn );
    
    
    public void imprimir( int iteracion, FileWriter fileWriter){
        //System.out.println( "*********" + iteracion + "**********");
        int N = poblacion.length;
        int k=0;
        for( int i=1; i<N; i++ ){
            if( queBuenoSoy[i] > queBuenoSoy[k]) k=i;
        }
        gDios = generar(poblacion[k]);
        //System.out.println(gDios);
        //System.out.println(f.evaluar((T)gDios));
        if (iteracion % 1000 == 0) {
            //System.out.println( "*********" + iteracion + "**********"); 
            
            try {
                String valor = String.valueOf(f.evaluar((T)gDios));
                fileWriter.append(valor);
                fileWriter.append(",");
                //System.out.println(valor);
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            } 
        }
        
    }
    
    public T aplicar( int ITER, FileWriter fileWriter){
        int N = poblacion.length;
        for( int i=0; i<ITER; i++ ){
            int[][] padres = new int[N][];
            for( int j=0; j<N; j++ ){
                int s = (int)(Math.random()*N);
                for( int k=1; k< 4; k++ ){
                    int s1 = (int)(Math.random()*N);
                    if( queBuenoSoy[s] < queBuenoSoy[s1] ){ s = s1; }
                }
                padres[j] = poblacion[s];
            }
            for( int k=0; k<N; k+=2 ){
                int[][] hijos = c.aplicar(padres[k], padres[k+1]);
                poblacion[k] = m.aplicar(hijos[0]);
                poblacion[k+1] = m.aplicar(hijos[1]);
                gDios = generar(poblacion[k]);
                queBuenoSoy[k] = f.evaluar((T)gDios);
                gDios = generar(poblacion[k+1]);
                queBuenoSoy[k+1] = f.evaluar((T)gDios);
            }
            
            imprimir( i, fileWriter);
            
        }
        int k=0;
        for( int i=1; i<N; i++ ){
            if( queBuenoSoy[i] > queBuenoSoy[k]) k=i;
        }
        gDios = generar(poblacion[k]);
        System.out.println(gDios);
        System.out.println(f.evaluar((T)gDios));
        return (T)gDios;
    }     
}
