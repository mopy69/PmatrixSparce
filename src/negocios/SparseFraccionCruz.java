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
public class SparseFraccionCruz {
                      Fraccion VD[];//vector de datos
                      
                       int VFC[];// vector fila columna
                      
                      Fraccion ep;// elemento predominante
                      
                      int Nfil;//num. de filas
                      int Ncol;//num. de columnas
                      int dim;// dimencion del vector

    public SparseFraccionCruz(int Nfil, int Ncol,int epnum, int epdeno) {
        if((Nfil%2!=0)&&(Ncol%2!=0)){
        VD = new Fraccion[10];
        this.VFC = new int [10];
        ep=new Fraccion(epnum,epdeno,'+');
        this.Nfil = Nfil;
        this.Ncol = Ncol;
        this.dim = -1;
        }
    }
    
    public void set(int fila,int col, int elenum, int eledeno, char signo){
    if((Ncol/2+1==col)||(Ncol/2+1==col)){
        Fraccion ele=new Fraccion(elenum,eledeno,signo);
        
    if((fila>Nfil)||(col>Ncol)){
    System.out.println("Error fila y columna fuera de Rango");
    System.exit(1);
    }
    else{
        int FC=((fila-1)*Ncol)+col;
       //hay elementos
         int posFC=buscarFC(fila,col);
         if (posFC>dim)//no existe
         { if (!ele.esIgualA(ep)){//inserta
             
           //if dim=VD.lenght
           //redimencionar();
           dim++;
           VD[dim]=ele;
           VFC[dim]=FC;
         }
         }
         else{//existe el elemento en la fila y columna
          if (ele!=ep){
          VD[posFC]=ele;
          }
          else{ //eliminar el elemento
              for (int i = posFC; i < dim; i++) {
                  VD[i]=VD[i+1];
                  VFC[i]=VFC[i+1];  
              }
           dim--;
          }
         
         }
    }
    }      
    }
      
  private int buscarFC(int fila,int col){
  int i=0;
  int FC=((fila-1)*Ncol)+col;
  while ((i<=dim)&&(VFC[i]!=FC))
      i++;
  return(i); 
  }  
    
 public Fraccion get(int fila, int col){    
 Fraccion cero=new Fraccion(0,1,'+');
     int i=buscarFC(fila,col); 
  if (i<=dim)
      return(VD[i]);
  else
     return ep;
 }   

    @Override
    public String toString() {
        
       String S="M=["+'\n';
       
        for (int i = 1; i <= Nfil; i++) {
            for (int j = 1; j<=Ncol; j++) {
                 S=S+ get(i,j).AString()+"\t";
            }
            S=S+'\n';
          }
        S=S+"]";
        
        return (S);
    }
    
        public static void main(String[] args) {
        // TODO code application logic here
        
      SparseFraccionCruz A=new SparseFraccionCruz(7,5,0,1);
      A.set(1,1, 3,5,'-');
      A.set(3,1, 4,5,'-');
      A.set(1,3, 7,5,'-');
      System.out.println(A);
        }
    
}
