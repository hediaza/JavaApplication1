/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

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
        String fileName = "/Users/hernanchodiaz/algoritmos_evo/JavaApplication1/datos.csv";
        FileWriter fileWriter = null;
        AGReales.dim = 10;      
        
        try {
            fileWriter = new FileWriter(fileName);
            for (int i=1; i<=100; i++) {
                System.out.println( "Experimento:" + i); 
                
                AGReales ag =  new AGReales( new Rastrigin(), 200 );
                fileWriter.append(String.valueOf(i));
                fileWriter.append(",");
         
                ag.aplicar(100000, fileWriter);
                
                fileWriter.append("\n");
            }
            
        } catch(IOException e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }    
}
