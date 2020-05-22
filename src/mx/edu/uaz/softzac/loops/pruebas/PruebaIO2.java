package mx.edu.uaz.softzac.loops.pruebas;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import mx.edu.uaz.softzac.loops.personajes.*;

public class PruebaIO{
  public static void main(String[] args) {
    String path = System.getProperty("user.home") + System.getProperty("file.separator");
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el nombre del archivo a leer en el home del usuario");
    String file = sc.next();
    path += file;
    File archivo = new File(path);
    if (!archivo.exists() || archivo.isDirectory()) {
      System.out.println("No se puede continuar con el programa");
      System.exit(0);
    }
    try {
      BufferedReader entrada = new BufferedReader(new FileReader(archivo));
      int lineas =Integer.parseInt(entrada.readLine());
      String s ="";
      //ArrayList<String> listper = new ArrayList<String>();
      for(int i =0; i < lineas;i++){
        s += entrada.readLine()+",";
      }
      String[] pers = s.split(",");
      Personaje[] Lpersonajes = new Personaje[lineas];
      int contador = 0;
      int l =0;
      while(contador < Lpersonajes.length) {
        if(pers[l] == "F" || pers[l] == "Z" || pers[l] == "P"){
            switch (pers[l]) {
                case "F": Lpersonajes[contador] = new Planta(pers[l+1],
                          Integer.parseInt(pers[l+2]),pers[l+3].charAt(0));
                          contador ++;
                          break;
                case "P":Lpersonajes[contador] = new Personaje(pers[l+1],
                         Integer.parseInt(pers[l+2]));
                         contador++;
                         break;
                case "Z":Lpersonajes[contador] = new Zombie(pers[l+1],
                         Integer.parseInt(pers[l+2]),Boolean.parseBoolean(pers[l+3]));
                         contador++;
                         break;
            }
         }else{
           l++;
         }
      }
      for (Personaje x: Lpersonajes ) {
        System.out.println(x);
      }
    }catch (FileNotFoundException fnfe) {
      fnfe.printStackTrace();
    }catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
