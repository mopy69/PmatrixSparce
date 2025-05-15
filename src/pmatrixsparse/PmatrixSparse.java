/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pmatrixsparse;

import negocios.Sparse;
import negocios.Sparsebits;

/**
 *
 * @author MarioCampos
 */
public class PmatrixSparse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
      /*Sparse A=new Sparse(10,10,0);
      A.set(1,3, 8);
      A.set(1,7, 1);
      A.set(3,3, 10);
      A.set(5,8, 2);
      A.set(7,2, 15);
      A.set(4,7, 20);
      A.set(9,1, 18);
      A.set(10,10,1);
      A.set(10,1, 0);
      System.out.println(A);
      A.set(10,10,2);
      A.set(1, 3, 0);
      System.out.println(A);*/
      
      Sparsebits A=new Sparsebits(100,100,0);
      A.set(1,3, 8);
      A.set(1,7, 1);
      A.set(3,3, 10);
      A.set(5,8, 2);
      A.set(7,2, 15);
      A.set(4,7, 20);
      A.set(9,1, 18);
      A.set(10,10,1);
      A.set(10,1, 0);
      System.out.println(A);
      A.set(10,10,2);
      A.set(1, 3, 0);
      A.set(100,100, 200);
      System.out.println(A);
      
      
        
      
      
      
      
    }
    
}
