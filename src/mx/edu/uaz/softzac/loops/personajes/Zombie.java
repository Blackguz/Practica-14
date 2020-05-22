// 2020/28/02 9:11 AM
package mx.edu.uaz.softzac.loops.personajes;

public class Zombie extends Personaje{
  //Atributos
  protected static boolean ataque;
  //Metodos
  public boolean regresarAtaque(){
    return ataque;
  }
  public String toString(){
    return super.toString() +"\t" + ataque;
  }
  public boolean decVida(){
    return (ataque) ?  super.decVida(3):super.decVida(2);
}
  public boolean decVida(int x){
    return (ataque) ?  super.decVida(x*2):super.decVida(x*2);
}
  public boolean equals(Object x){
    if(!(x != null && (x instanceof Zombie))){
      return false;
    }
    Zombie zom = (Zombie)x;
    return ( (this.ataque == zom.ataque) && super.equals(zom) );
}
  public String getIdVida(){
    return super.getIdVida() + " " + ataque;
  }
  //Constructores
  public Zombie(String nombre, int vida, boolean ataque){
    super(nombre, vida);
    this.ataque = ataque;
  }
  public Zombie(String nombre, boolean ataque){
    super(nombre, 3);
    this.ataque = ataque;
  }
  public Zombie(String nombre){
    super(nombre, 3);
    this.ataque = false;
  }
}
// 9:21 AM
