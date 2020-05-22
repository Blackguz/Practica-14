package mx.edu.uaz.softzac.loops.pruebas;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import mx.edu.uaz.softzac.loops.personajes.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class PruebaIO{
  public static void main(String[] args) {
    String path = System.getProperty("user.home") + System.getProperty("file.separator");
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el nombre del archivo a leer en el home del usuario");
    String file = sc.next();
    path += file;
    File archivo = new File(path);
    ArrayList<Personaje> personajes = new ArrayList<Personaje>();
    if (!archivo.exists() || archivo.isDirectory()) {
      System.out.println("No se puede continuar con el programa");
      System.exit(0);
    }
    try {
      BufferedReader entrada = new BufferedReader(new FileReader(archivo));
      int lineas =Integer.parseInt(entrada.readLine());
      String s ="";
      for(int i =0; i < lineas;i++){
        s = entrada.readLine();
        String[] pers = s.split(",");
        switch (pers[0]) {
            case "F":
                      personajes.add(new Planta(
                        pers[1],
                        Integer.parseInt(pers[2]),
                        pers[3].charAt(0) ));
                      break;
            case "P":
                     personajes.add(new Personaje(pers[1],Integer.parseInt(pers[2])));
                     break;
            case "Z":
                      personajes.add(new Zombie(
                      pers[1],
                      Integer.parseInt(pers[2]),
                      Boolean.parseBoolean(pers[3]) ));
                      break;
        }
      }
    }catch (FileNotFoundException fnfe) {
      fnfe.printStackTrace();
    }catch (IOException ioe) {
      ioe.printStackTrace();
    }
    //Aquí va la serialización
    String path2 = System.getProperty("user.home") + System.getProperty("file.separator");
      try {
        FileOutputStream f = new FileOutputStream(path2+"pvsz.out");
        ObjectOutputStream r = new ObjectOutputStream(f);
        for (Personaje x: personajes ) {
          r.writeObject(x);
        }
        r.close();
      } catch(IOException e) {
        e.printStackTrace();
      }
  }
}
