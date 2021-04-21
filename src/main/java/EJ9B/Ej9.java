/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJ9B;

import Ej4.Deportivo;
import Ej4.Furgoneta;
import Ej4.Turismo;
import Ej4.Vehiculo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
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

        try (Scanner datosFichero = new Scanner(new File(idFichero))) {
            datosFichero.nextLine();
            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();

                tokens = linea.split(":");
                Vehiculo tmp = new Vehiculo();

                if ("1".equals(tokens[0])) {
                    Deportivo deport = new Deportivo();
                    deport.setMatricula(tokens[1]);
                    deport.setMarca(tokens[2]);
                    deport.setModelo(tokens[3]);
                    deport.setColor(tokens[4]);
                    deport.setPrecio(Double.parseDouble(tokens[5]));
                    deport.setDisponible(Boolean.valueOf(tokens[6]));
                    deport.setCilindrada(Integer.valueOf(tokens[7]));
                    vehiculos.add(deport);

                } else if ("0".equals(tokens[0])) {
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

                } else if ("3".equals(tokens[0])) {
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
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        creacionDeportivo(idDeportivo, vehiculos);
        creacionTurismos(idTurismo, vehiculos);
        creacionFurgonetas(idFurgoneta, vehiculos);

        Comparator<Vehiculo> criterioPrecio = (c1, c2) -> c1.getMarca().compareTo(c2.getMarca());
        Collections.sort(vehiculos, criterioPrecio);

        vehiculos.forEach(System.out::println);

    }

    public static void creacionDeportivo(String nomFichero, ArrayList<Vehiculo> vehi) {
        String[] tokens;
        String linea;

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(nomFichero))) {
            for (Vehiculo v : vehi) {

                linea = v.toString();
                tokens = linea.split(":");
                Deportivo d1 = new Deportivo();

                String resp = "";
                if (tokens.length == 7) {
                    d1.setMatricula(v.getMatricula());
                    d1.setMarca(v.getMarca());
                    d1.setModelo(v.getModelo());
                    d1.setColor(v.getColor());
                    d1.setPrecio(v.getPrecio());
                    d1.setDisponible(v.isDisponible());
                    d1.setCilindrada(((Deportivo) v).getCilindrada());

                    resp = d1.toString();
                    flujo.write(resp);
                    flujo.newLine();
                }

            }
            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void creacionTurismos(String nomFichero, ArrayList<Vehiculo> vehi) {
        String[] tokens;
        String linea;

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(nomFichero))) {
            for (Vehiculo v : vehi) {

                linea = v.toString();
                tokens = linea.split(":");
                Turismo t1 = new Turismo();

                String resp = "";
                if (tokens[tokens.length-1].equals("false") || tokens[tokens.length-1].equals("true")) {
                    t1.setMatricula(v.getMatricula());
                    t1.setMarca(v.getMarca());
                    t1.setModelo(v.getModelo());
                    t1.setColor(v.getColor());
                    t1.setPrecio(v.getPrecio());
                    t1.setDisponible(v.isDisponible());
                    t1.setNumeroPuertas(((Turismo) v).getNumeroPuertas());
                    t1.setMarchaAutomatica(((Turismo) v).isMarchaAutomatica());

                    resp = t1.toString();
                    flujo.write(resp);
                    flujo.newLine();
                }

            }
            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void creacionFurgonetas(String nomFichero, ArrayList<Vehiculo> vehi) {
        String[] tokens;
        String linea;

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(nomFichero))) {
            for (Vehiculo v : vehi) {

                linea = v.toString();
                tokens = linea.split(":");
                Furgoneta f1 = new Furgoneta();
                String c = tokens[6];
                int carga = Integer.valueOf(c);
                System.out.println(tokens[7]);
                String volum = tokens[7];
                int vol = Integer.valueOf(volum);
                System.out.println(tokens.length);

                String resp = "";
                if (0 < carga || 0 < vol) {
                    f1.setMatricula(v.getMatricula());
                    f1.setMarca(v.getMarca());
                    f1.setModelo(v.getModelo());
                    f1.setColor(v.getColor());
                    f1.setPrecio(v.getPrecio());
                    f1.setDisponible(v.isDisponible());
                    f1.setCarga(((Furgoneta) v).getCarga());
                    f1.setVolumen(((Furgoneta) v).getVolumen());

                    resp = f1.toString();
                    flujo.write(resp);
                    flujo.newLine();
                }

            }
            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
