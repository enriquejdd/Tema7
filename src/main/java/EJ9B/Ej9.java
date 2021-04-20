/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJ9B;

import Ej7.*;
import Ej4.Deportivo;
import Ej4.Furgoneta;
import Ej4.Turismo;
import Ej4.Vehiculo;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Realiza un programa que lea los datos del ejercicio 4. Para ello creará una
 * lista de objetos de tipo Vehiculo. El programa irá almacenando en la lista
 * los objetos leídos desde el archivo de texto “vehículos.csv”. Una vez
 * cargados todos los datos en la lista, ordena los vehículos por Marca y
 * muestra el resultado por consola
 *
 * @author Enrique
 */
public class Ej9 {

    public static void main(String[] args) {
        // Fichero a leer
        String idFichero = "vehículos.csv";
        String idDeportivo = "deportivos.csv";
        String idTurismo = "turismos.csv";
        String idFurgoneta = "furgonetas.csv";
        String textoAñadir = "";

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        try (Scanner datosFichero = new Scanner(new FileReader(idFichero))) {

            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();

                tokens = linea.split(":");
                Vehiculo tmp = new Vehiculo();

                if (tmp instanceof Deportivo) {
                    Deportivo deport = new Deportivo();

                    deport.setMatricula(tokens[1]);
                    deport.setMarca(tokens[2]);
                    deport.setModelo(tokens[3]);
                    deport.setColor(tokens[4]);
                    deport.setPrecio(Double.parseDouble(tokens[5]));
                    deport.setDisponible(Boolean.valueOf(tokens[6]));
                    deport.setCilindrada(Integer.valueOf(tokens[7]));
                    vehiculos.add(deport);

//                    textoAñadir = deport.toString();
//                    try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idDeportivo))) {
//                        flujo.write(textoAñadir);
//                        flujo.newLine();
//                        flujo.flush();
//                    } catch (IOException e) {
//                        System.out.println(e.getMessage());
//                    }
                } else if (tmp instanceof Turismo) {
                    Turismo t1 = new Turismo();

                    t1.setMatricula(tokens[1]);
                    t1.setMarca(tokens[2]);
                    t1.setModelo(tokens[3]);
                    t1.setColor(tokens[4]);
                    t1.setPrecio(Double.parseDouble(tokens[5]));
                    t1.setDisponible(Boolean.valueOf(tokens[6]));
                    t1.setNumeroPuertas(Integer.valueOf(tokens[7]));
                    t1.setMarchaAutomatica(Boolean.valueOf(tokens[8]));
                    vehiculos.add(t1);

//                    textoAñadir = t1.toString();
//                    try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idTurismo))) {
//                        flujo.write(textoAñadir);
//                        flujo.newLine();
//                        flujo.flush();
//                    } catch (IOException e) {
//                        System.out.println(e.getMessage());
//                    }
                } else if (tmp instanceof Furgoneta) {
                    Furgoneta f1 = new Furgoneta();

                    f1.setMatricula(tokens[1]);
                    f1.setMarca(tokens[2]);
                    f1.setModelo(tokens[3]);
                    f1.setColor(tokens[4]);
                    f1.setPrecio(Double.parseDouble(tokens[5]));
                    f1.setDisponible(Boolean.valueOf(tokens[6]));
                    f1.setCarga(Integer.valueOf(tokens[7]));
                    f1.setVolumen(Integer.valueOf(tokens[8]));
                    vehiculos.add(f1);

//                    textoAñadir = f1.toString();
//                    try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFurgoneta))) {
//                        flujo.write(textoAñadir);
//                        flujo.newLine();
//                        flujo.flush();
//                    } catch (IOException e) {
//                        System.out.println(e.getMessage());
//                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

//        crearArchivoDeportivo(vehiculos);
//        crearArchivoFurgoneta(vehiculos);
//        crearArchivoTurismo(vehiculos);
//        
        Comparator<Vehiculo> criterioPrecio = (c1, c2) -> c1.getMarca().compareTo(c2.getMarca());

        Collections.sort(vehiculos, criterioPrecio);

        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.println(vehiculos.toString());
        }

//        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idDeportivo))) {
//            vehiculos.stream().filter((v) -> (v instanceof Deportivo)).map((v) -> new Deportivo(((Deportivo) v).getCilindrada(), v.getMatricula(), v.getMarca(), v.getModelo(), v.getColor(), v.getPrecio(), v.isDisponible())).forEachOrdered((d1) -> {
//                añadirDeportivo(d1);
//                System.out.println("Creadp el dep");
//            });
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
    }

//    public static void añadirDeportivo(Deportivo v) {
//        String idDeportivo = "deportivos.csv";
//
//        try (ObjectOutputStream flujo = new ObjectOutputStream(new FileOutputStream(idDeportivo))) {
//            flujo.writeObject(v.toString());
//        } catch (FileNotFoundException e) {
//            System.out.println("El fichero no existe");
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//    }

}
//    
//    public static void crearArchivoTurismo(ArrayList<Vehiculo> vehi) {
//        String idTurismo = "turismos.csv";
//        
//        for (Vehiculo v : vehi) {
//            if (v instanceof Deportivo) {
//                try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idTurismo))) {
//                    flujo.write(v.toString());
//                    flujo.newLine();
//                    flujo.flush();
//                } catch (IOException e) {
//                    System.out.println(e.getMessage());
//                }
//            }
//        }
//    }
//    
//    public static void crearArchivoFurgoneta(ArrayList<Vehiculo> vehi) {
//        String idFurgoneta = "furgonetas.csv";
//        
//        for (Vehiculo v : vehi) {
//            if (v instanceof Deportivo) {
//                try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFurgoneta))) {
//                    flujo.write(v.toString());
//                    flujo.newLine();
//                    flujo.flush();
//                } catch (IOException e) {
//                    System.out.println(e.getMessage());
//                }
//            }
//        }
//    }

