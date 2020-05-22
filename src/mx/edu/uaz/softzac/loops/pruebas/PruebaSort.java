package mx.edu.uaz.softzac.loops.pruebas;
import mx.edu.uaz.softzac.loops.personajes.*;
import mx.edu.uaz.softzac.loops.utils.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Collections;

public class PruebaSort {
	public static void main(String[] args) {

		///orden natural
		TreeSet<Personaje> pers= new TreeSet<Personaje>();
		pers.add(new Personaje("Diana",9));
		pers.add(new Planta ("Fernando",50));
		pers.add(new Zombie("Arayeli",80,false));
		pers.add(new Personaje("Erick",99));
		pers.add(new Planta("Juventino",5));
		pers.add(new Zombie("Elias",80,false));
		pers.add(new Personaje("Pablo",77));
		pers.add(new Planta ("Roman",15));
		pers.add(new Zombie("Joseph",38,false));
		pers.add(new Personaje("Juan",49));
		pers.add(new Planta("Emmanuel",66));
		for(Personaje p1: pers){
		 System.out.println(p1);
		 }

		 //por vida
		System.out.println("----------------------------------------------");

		LinkedList<Personaje> list2= new LinkedList<Personaje>();
		list2.add(new Personaje("Diana",9));
		list2.add(new Planta ("Fernando",50));
		list2.add(new Zombie("Arayeli",80,false));
		list2.add(new Personaje("Erick",99));
	  list2.add(new Planta("Juventino",5));
		list2.add(new Zombie("Elias",80,false));
   	list2.add(new Personaje("Pablo",77));
		list2.add(new Planta ("Roman",15));
		list2.add(new Zombie("Joseph",38,false));
		list2.add(new Personaje("Juan",49));
		list2.add(new Planta("Emmanuel",66));
		Comparator<Personaje> c = new SortVida();
		Collections.sort(list2,c);
		for (Personaje p2 : list2) {
			System.out.println(p2);
		}

	}
}
