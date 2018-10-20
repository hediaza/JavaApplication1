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
public class Glovito extends Solucion{
    protected int[][] estado;
    protected int[][] sale;
    
    public Glovito(){
        estado = new int[4][2];
        sale = new int[4][2];
        for( int i=0; i<4; i++ ){
            for( int j=0; j<2; j++ ){
                estado[i][j] = (int)(Math.random() * 4);
                sale[i][j] = (int)(Math.random() * 2);
            }
        }
    }
    
    public Glovito( int[] adn ){
        estado = new int[4][2];
        sale = new int[4][2];
        int k=0;
        for( int i=0; i<4; i++ ){
            for( int j=0; j<2; j++ ){
                estado[i][j] = 2 * adn[k];
                estado[i][j] += adn[k+1];
                sale[i][j]=adn[k+2];
                k += 3;
            }
        }    
    }
    
    public int[] codifica(){
        int[] adn = new int[24];
        int k=0;
        for( int i=0; i<4; i++ ){
            for( int j=0; j<2; j++ ){
                adn[k] = (estado[i][j]) / 2;
                adn[k+1] = (estado[i][j]) % 2;        
                adn[k+2] = sale[i][j];
                k += 3;
            }
        }    
        return adn;
    }
    
    public int[] simular( int[] entra ){
        int e = 0;
        int[] respuesta = new int[entra.length];
        for( int i=0; i<entra.length; i++ ){
            respuesta[i] = sale[e][entra[i]];
            e = estado[e][entra[i]];
        }
        return respuesta;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for( int i=0; i<4; i++ ){
            sb.append((char)('A'+i));
            sb.append(" | ");
            for( int j=0; j<2; j++ ){
                sb.append((char)('A'+estado[i][j]));
                sb.append(',');
                sb.append(sale[i][j]);
                sb.append(" | ");            
            }
            sb.append('\n');
        }    
        return sb.toString();
    }
    
    public static void main( String[] args ){
        FGlovito f = new FGlovito();
        Cruce c = new Cruce();
        Mutacion m = new Mutacion();
        Glovito g = new Glovito(new int[]{1,0,1,0,1,0,1,1,1,1,0,0,1,1,1,1,0,1,0,1,1,0,1,1});
        System.out.println(g);
        System.out.println(f.evaluar(g));
        Glovito g2 = new Glovito(new int[]{0,1,0,1,1,1,0,0,0,1,0,1,1,1,0,1,1,1,0,0,0,1,1,0});
        System.out.println(g2);
        System.out.println(f.evaluar(g2));
        int[] adn = g.codifica();
        int[][] hijos = c.aplicar(adn, g2.codifica());
        hijos[0] = m.aplicar(hijos[0]);
        hijos[1] = m.aplicar(hijos[1]);
        Glovito gh1 = new Glovito(hijos[0]);
        Glovito gh2 = new Glovito(hijos[1]);
        System.out.println(gh1);
        System.out.println(f.evaluar(gh1));
        System.out.println(gh2);
        System.out.println(f.evaluar(gh2));
    }
}
