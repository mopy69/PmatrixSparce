/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios;

/**
 *
 * @author MC
 */
public class Fraccion {
    int nume;
    int deno;
    
public Fraccion(){
    this.nume=0;
    this.deno=1;
}

public Fraccion(int nume,int deno,char signo) {
    this.deno=Math.abs(deno);
    if(signo=='+'){
        this.nume=+Math.abs(nume);
    } else {
        this.nume=-Math.abs(nume);
    }
}

public int getNume(){
    return Math.abs(nume);
}

public int getDeno(){
    return deno;
}

public char getSigno(){
    if(nume>=0) {
        return '+';
    }  else {
        return '-';
    }
}

public void setNume(int nume){
    if(this.nume>=0){
        this.nume=nume;
    } else {
        this.nume=-nume;
    }
}

public void setDeno(int deno){
    this.deno=deno;
}

public void setSigno(char signo){
    if(signo=='+'){
        nume=+Math.abs(nume);
    } else {
        nume=-Math.abs(nume);
    }
}

public void Suma(Fraccion A,Fraccion B){
    deno=A.getDeno()*B.getDeno();
    nume=(A.nume*B.getDeno())+(A.getDeno()*B.nume);
    Simplificar();
}

public void Resta(Fraccion A,Fraccion B){
    deno=A.getDeno()*B.getDeno();
    nume=(A.nume*B.getDeno()) - (A.getDeno()*B.nume);
    Simplificar();
}

public void Multiplicar(Fraccion A,Fraccion B){
    deno=A.getDeno()*B.getDeno();
    nume=A.nume*B.nume;
    Simplificar();
}

public void Dividir(Fraccion A,Fraccion B){
    nume=A.nume*B.deno;
    deno=A.deno*B.nume;
    if(deno<0){
        nume=nume*-1;
        deno=Math.abs(deno);
    }
    Simplificar();
}

public void Simplificar(){
    int x=MCD();
    nume=nume/x;
    deno=deno/x;
}

public int MCD(){
    int u=Math.abs(nume);
    int v=Math.abs(deno);
    if(v==0){
        return u;
    } else {
        int z;
        while(v!=0){
            z=u%v;
            u=v;
            v=z;
        }
        return u;
    }
}

public boolean esIgualA(Fraccion otra) {
    return this.nume * otra.deno == this.deno * otra.nume;
}

public String ToString() {
    if (getNume() == 0) {
        return "0\n";
    } else {
        String c = "      " + getNume() + "\n" + getSigno() + "     ---\n" + "      " + getDeno() + "\n";
        return c;
    }
}

public String AString(){
    if(getNume()==0){
        return "0";
}else{  
    return ""+getSigno()+getNume()+"/"+getDeno();
}
}

public static void main(String[] args){
    Fraccion A=new Fraccion(1,4,'+');
    System.out.print(A.ToString());
    Fraccion B=new Fraccion(1,2,'-');
    System.out.print(B.ToString());
    Fraccion C=new Fraccion();
    C.Dividir(A, B);
    System.out.print(C.ToString());
    Fraccion D=new Fraccion();
    D.Dividir(A, B);
    System.out.print(D.ToString());
}
} // corchete final
