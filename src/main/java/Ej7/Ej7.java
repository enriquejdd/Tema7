/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej7;

import Ej4.Deportivo;
import Ej4.Furgoneta;
import Ej4.Turismo;
import Ej4.Vehiculo;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
public class Ej7 {

    public static void main(String[] args) {
        // Fichero a leer
        String idFichero = "vehículos.csv";

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

//                for (int i = tokens.length; i > 0; i--) {
//                    if (i != 0) {
//                        tmp.setMatricula(tokens[1]);
//                        System.out.println("Añadi la matricula");
//                        tmp.setMarca(tokens[2]);
//                        System.out.println("Añadi la marca");
//                        tmp.setModelo(tokens[3]);
//                        System.out.println("Añadi el modelo");
//                        tmp.setColor(tokens[4]);
//                        System.out.println("Añadi el color");
//                        tmp.setPrecio(Double.parseDouble(tokens[5]));
//                        System.out.println("Añadi el precio");
//                        tmp.setDisponible(Boolean.valueOf(tokens[6]));
//                        System.out.println("Añadi la disponibilidad");
//                        if (tmp instanceof Deportivo) {
//                            ((Deportivo) tmp).setCilindrada(Integer.valueOf(tokens[7]));
//                        } else if (tmp instanceof Turismo) {
//                            ((Turismo) tmp).setNumeroPuertas(Integer.valueOf(tokens[7]));
//                            ((Turismo) tmp).setMarchaAutomatica(Boolean.valueOf(tokens[8]));
//                        } else if (tmp instanceof Furgoneta) {
//                            ((Furgoneta) tmp).setCarga(Integer.valueOf(tokens[7]));
//                            ((Furgoneta) tmp).setVolumen(Integer.valueOf(tokens[8]));
//                        }
//                    }
//                }

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
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Comparator<Vehiculo> criterioPrecio = (c1, c2) -> c1.getMarca().compareTo(c2.getMarca());
        Collections.sort(vehiculos, criterioPrecio);

        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.println(vehiculos.toString());
        }
    }
}
