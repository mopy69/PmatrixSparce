/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

/**
 *
 * @author MarioCampos
 */
public class Vectornbits { int V[];
                          int cant;
                          int numbits;
                          //int numbits

    public Vectornbits(int cantE,int Ncantbits) {//int numbits
        int cantbits=cantE*Ncantbits;  //int cantbits=cantE*numbits
        int NE=cantbits/32;
        if ((cantbits%32)!=0){
            NE++;}
        
        V=new int [NE];
        this.cant =cantE;
        numbits=Ncantbits;
        
    }
    public int cantidad(){
    return cant;
    };
    public void insertar(int ele, int pos){
        
        int mask=(int)((Math.pow(2, numbits)-1)); //int mask=(int)((Math.pow(2,numbits)-1))
        int nbits=sacarbits(pos);//30
        int Nent=sacarentero(pos);//0
        int ele1=ele;
        mask=mask<<nbits;
        mask=~mask;
        V[Nent]=V[Nent]&mask;
        
        ele=ele<<nbits;
        V[Nent]=V[Nent]|ele;
        if((nbits+numbits)>32){//faltan bits por insertar    if((nbits+numbits)>32)
            int mask1=(int)((Math.pow(2,numbits)-1));
            mask1=mask1>>>(32-nbits);
            mask1=~mask1;
            V[Nent+1]=V[Nent+1]&mask1;
            ele1=ele1>>>(32-nbits);
             V[Nent+1]=V[Nent+1]|ele1;
        }
       
    }
    
 public int sacar(int pos){
        
        int mask=(int)((Math.pow(2,numbits)-1));
        int nbits=sacarbits(pos);//30
        int Nent=sacarentero(pos);//0   
        
        mask=mask<< nbits;
        
        mask=mask & V[Nent];
        mask=mask>>>nbits;
        
       if((nbits+numbits)>32){//faltan bits por sacar 
            int mask1=(int)((Math.pow(2,numbits)-1));
            mask1=mask1>>>(32-nbits);
            mask1=mask1 & V[Nent+1];
            mask1=mask1<<(32-nbits);
            mask=mask|mask1;         
        }
        return(mask);
    }

   private int sacarbits(int pos){
  return(((pos-1)*numbits%32));
   
   }               
    private int sacarentero(int pos){
   return((pos-1)*numbits/32);
   
   } 

    @Override
    public String toString() {
        
        String S="V=[ ";
        for (int i = 1; i <= cant; i++) {
            S=S+sacar(i)+" , ";
        }
        S=S+"]";
        return (S);
    }}
    
