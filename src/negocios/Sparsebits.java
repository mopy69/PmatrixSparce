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
public class Sparsebits { float VD[];//vector de datos
                          Vectornbits VFC;// vector fila columna a nivel de bits
                          int numbits;//numero de bits de la matris fila columna
                          float ep;// elemento predominante
                          int Nfil;//num. de filas
                          int Ncol;//num. de columnas
                          int dim;// dimencion del vector
                                            
    public Sparsebits(int Nfil, int Ncol,float ep) {
        numbits=calcularbits(Nfil,Ncol);//calculamos el numero de bits para VFC
        this.VD = new float[10];
        this.VFC = new Vectornbits(10,numbits);
        this.ep = ep;
        this.Nfil = Nfil;
        this.Ncol = Ncol;
        this.dim = -1;
    }
    
    private int calcularbits(int fila,int col){
    int i=1;
    while (((int)(Math.pow(2,i)-1)<=(fila*col))){
    i++;
    }
    return(i);
    }
   
    public void set(int fila,int col, float ele){
    if((fila>Nfil)||(col>Ncol)){
    System.out.println("Error fila y columna fuera de Rango");
    System.exit(1);
    }
    else{
        int FC=((fila-1)*Ncol)+col;
       //hay elementos
         int posFC=buscarFC(fila,col);
         if (posFC>dim)//no existe
         { if (ele!=ep){//inserta
             
           dim++;
           VD[dim]=ele;
           VFC.insertar(FC, dim+1);
         }
         }
         else{//existe el elemento en la fila y columna
          if (ele!=ep){
          VD[posFC]=ele;
          }
          else{ //eliminar el elemento
              for (int i = posFC; i < dim; i++) {
                  VD[i]=VD[i+1];
                  VFC.insertar(VFC.sacar(i+2),i+1);  
              }
           dim--;
          }
         
         }
    }      
    }
      
  private int buscarFC(int fila,int col){
  int i=0;
  int FC=((fila-1)*Ncol)+col;
  while ((i<=dim)&&(VFC.sacar(i+1)!=FC))
      i++;
  return(i); 
  }  
    
 public float get(int fila, int col){
  int i=buscarFC(fila,col); 
  if (i<=dim)
      return(VD[i]);
  else
      return(ep);
 }   

    @Override
    public String toString() {
        
       String S="M=["+'\n';
       
        for (int i = 1; i <= Nfil; i++) {
            for (int j = 1; j<=Ncol; j++) {
                 S=S+ get(i,j)+"   ";
            }
            S=S+'\n';
          }
        S=S+"]";
        
        return (S);
    }
    
}
