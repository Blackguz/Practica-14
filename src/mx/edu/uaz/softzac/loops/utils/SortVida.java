package mx.edu.uaz.softzac.loops.utils;
import java.util.Comparator;
import mx.edu.uaz.softzac.loops.personajes.*;
//metodos
public class SortVida implements Comparator<Personaje>{
	public int compare(Personaje per1, Personaje per2) {
	return per1.getVida() - per2.getVida();
	}
}
