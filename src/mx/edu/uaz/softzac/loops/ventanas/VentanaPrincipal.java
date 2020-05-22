package mx.edu.uaz.softzac.loops.ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;

public class VentanaPrincipal{
  //Atributos
  JFrame f;
  JLabel lblFile;
  JTextField txtFile;
  JButton btnOpen;
  JTextArea txtCont;
  JLabel lblN;
  JLabel lblLeidos;
  JButton btnExit;
  //Constructores
  public VentanaPrincipal(){
    f = new JFrame("Practica 14");
    lblFile = new JLabel("Nombre del archivo");
    txtFile = new JTextField(20);
    btnOpen = new JButton("Abrir archivo");
    txtCont = new JTextArea(30, 40);
    lblLeidos = new JLabel("Caracteres leidos");
    lblN = new JLabel("0");
    btnExit = new JButton("Salir");
  }
  //Metodos
  public void initComponents(){
    f.setLayout(new FlowLayout());
    f.add(lblFile);
    f.add(txtFile);
    f.add(btnOpen);
    f.add(txtCont);
    f.add(lblLeidos);
    f.add(lblN);
    f.add(btnExit);
    f.setSize(550,580);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    btnOpen.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        openFile();
      }
    });
    btnExit.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        f.dispose();
      }
    });
  }


  //metodo main
  public static void main(String[] args) {
    VentanaPrincipal v = new VentanaPrincipal();
    v.initComponents();
  }
  //metodos
  public void openFile(){
    String file = txtFile.getText();
    String sep = System.getProperty("file.separator");
    String path = System.getProperty("user.home")+sep+file;
    System.out.println(path);
    txtCont.setText(file);

    File archivo = new File(path);
    if (!archivo.exists()) {
      JOptionPane.showMessageDialog(null, "El archivo no existe");
    }else if(archivo.isDirectory()){
      getList(archivo);
    }else if(archivo.isFile()){
      getContenido(archivo);
    }
  }
  public void getContenido(File x){
    try {
      BufferedReader entrada = new BufferedReader(new FileReader(x));
      String s = entrada.readLine();
      int contadorCharts = 0;
      while(s!=null){
        contadorCharts += s.length();
        txtCont.append(s);
        txtCont.append("\n");
        s = entrada.readLine();
      }
      lblN.setText(""+contadorCharts);
    }catch (FileNotFoundException fnfe) {
      fnfe.printStackTrace();
    }catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
  public void getList(File x){
    String[] s = x.list();
    int contadorCharts = 0;
    for (String a : s ) {
      txtCont.append(a);
      txtCont.append("\n");
      contadorCharts += a.length() ;
    }
    lblN.setText(""+contadorCharts);
  }
}
