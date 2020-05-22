package mx.edu.uaz.softzac.loops.pruebas;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import mx.edu.uaz.softzac.loops.personajes.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class PruebaOutIO{
  public static void main(String[] args) {
    String path2 = System.getProperty("user.home") + System.getProperty("file.separator");
    ArrayList<Personaje> lista =new ArrayList<Personaje>();
      try {
        FileInputStream f = new FileInputStream(path2+"pvsz.out");
        ObjectInputStream r = new ObjectInputStream(f);
        for (int i = 0; i<4;i++) {
          lista.add((Personaje)r.readObject());
        }
        r.close();
        for (Personaje x: lista ) {
          System.out.println(x);
        }
      }catch (ClassNotFoundException cnfe) {
        cnfe.printStackTrace();
      } catch(IOException e) {
        e.printStackTrace();
      }
  }
}
