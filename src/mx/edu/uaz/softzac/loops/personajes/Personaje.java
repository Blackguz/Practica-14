// 2020/20/03 8:30
package mx.edu.uaz.softzac.loops.personajes;

import java.io.Serializable;

public class Personaje implements Comparable<Personaje>, Serializable{
   // Atributos
  protected String nombre;
  protected int vida;
  protected static int ID;
  protected int id;

   //METODOS
   public int getVida(){
    return vida;
}
  public boolean setAddVida(){
   if(this.vida < 99 && (this.vida + 1 <= 99)){
   this.vida = this.vida + 1;
    return true;
   }else{
    return false;
   }
}
  public boolean addVida(int vida){
   if(vida < 99 && (vida + this.vida <= 99)){
   this.vida = this.vida +vida;
   return true;
   }else{
    return false;
   }
}
  public boolean decVida(int vida){
   if(this.vida >= 1 && (this.vida - vida >= 0)){
   this.vida = this.vida - vida;
    return true;
   }else{
     return false;
   }
}
  public boolean decVida(){
   if(this.vida >= 1 && (this.vida - 1 > 0)){
   this.vida = this.vida - 1;
    return true;
   }else{
    return false;
   }
 }
  public String getNombre(){
   return nombre;
}
  public void setNombre(String x){
   this.nombre = x;
}
  public String toString(){
   return (id + " " + nombre + "\t" + vida);
}
  public boolean equals(Object x){
    if(!(x != null && (x instanceof Personaje))){
      return false;
    }
    Personaje per = (Personaje)x;
    return (nombre.equals(per.nombre) && this.vida == per.vida);
}
public int compareTo(Personaje per){
  return this.nombre.compareTo(per.nombre);
}
public int hashCode(){
 return nombre.hashCode()+vida*7;
}
/*
Para solucionar los otros errores se tuvo que quitar el "final" para poder sobre escribir
el metodo en los otros.
*/
  public String getIdVida(){
    return id + " " + vida;
  }
  //Constructor
 public Personaje(String nombre, int vida){
  ID ++;
  id += ID;
  this.nombre = nombre;
  if(vida > 99 || vida <= 0){
   this.vida = vida;
  }else{
   this.vida = vida;
  }
}
  public Personaje(String nombre){
    this(nombre, 3);
  }
}

//
