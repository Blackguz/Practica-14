	// 2020/28/02 8:00 AM
/**
*@Author Roman
*/
package mx.edu.uaz.softzac.loops.personajes;

public class Planta extends Personaje{
  //atributos
  protected static char escudo;

  
  //Metodos
  public char getEscudo(){
    return escudo;
  }
  public String toString(){
    return super.toString() + "\t" + escudo;
  }
  public boolean decVida(){
    return (escudo == 'A') ?  super.decVida(2):super.decVida(1);
}
  public boolean decVida(int x){
    return (escudo == 'A') ?  super.decVida(x*2):super.decVida(x);
}
  public boolean equals(Object x){
    if(!(x != null && (x instanceof Planta))){
      return false;
    }
    Planta plan = (Planta)x;
    return (this.escudo == plan.escudo) && (super.equals(plan));
}
/*
*Aquí me daba un erro en la escritura de este metodo debido a que tenia "final", así que se le remueve *al metodo original y se sobre escribe aquí.
*/
  public String getIdVida(){
    return super.getIdVida() + escudo;  
  }
  //constructores
  public Planta(String nombre, int vida, char escudo){
    super(nombre, vida);
    this.escudo = escudo;
  }
  public Planta(String nombre, char escudo){
    this(nombre, 3, escudo);
  }
  public Planta(String nombre, int vida){
    this(nombre, vida, 'A');
  }
  public Planta(String nombre){
    this(nombre, 3,'A');
  }
}
// 9:10false;
