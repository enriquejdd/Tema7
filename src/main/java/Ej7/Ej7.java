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
                System.out.println("Entre en el fichero");
                linea = datosFichero.nextLine();

                tokens = linea.split(":");
                Vehiculo tmp = new Vehiculo();
                System.out.println("Cree el nuevo vehiculo");

                for (int i = tokens.length; i > 0; i--) {
                    if (i != 0) {
                        tmp.setMatricula(tokens[1]);
                        System.out.println("Añadi la matricula");
                        tmp.setMarca(tokens[2]);
                        System.out.println("Añadi la marca");
                        tmp.setModelo(tokens[3]);
                        System.out.println("Añadi el modelo");
                        tmp.setColor(tokens[4]);
                        System.out.println("Añadi el color");
                        tmp.setPrecio(Double.parseDouble(tokens[5]));
                        System.out.println("Añadi el precio");
                        tmp.setDisponible(Boolean.valueOf(tokens[6]));
                        System.out.println("Añadi la disponibilidad");
                        if (tmp instanceof Deportivo) {
                            ((Deportivo) tmp).setCilindrada(Integer.valueOf(tokens[7]));
                        } else if (tmp instanceof Turismo) {
                            ((Turismo) tmp).setNumeroPuertas(Integer.valueOf(tokens[7]));
                            ((Turismo) tmp).setMarchaAutomatica(Boolean.valueOf(tokens[8]));
                        } else if (tmp instanceof Furgoneta) {
                            ((Furgoneta) tmp).setCarga(Integer.valueOf(tokens[7]));
                            ((Furgoneta) tmp).setVolumen(Integer.valueOf(tokens[8]));
                        }
                    }
                }

//                for (String string : tokens) {
//                    tmp.setMatricula(tokens[1]);
//                    System.out.println("Añadi la matricula");
//                    tmp.setMarca(tokens[2]);
//                    System.out.println("Añadi la marca");
//                    tmp.setModelo(tokens[3]);
//                    System.out.println("Añadi el modelo");
//                    tmp.setColor(tokens[4]);
//                    System.out.println("Añadi el color");
//                    tmp.setPrecio(Integer.valueOf(tokens[5]));
//                    System.out.println("Añadi el precio");
//                    tmp.setDisponible(Boolean.valueOf(tokens[6]));
//                    System.out.println("Añadi la disponibilidad");
//                    if (tmp instanceof Deportivo) {
//                        ((Deportivo) tmp).setCilindrada(Integer.valueOf(tokens[7]));
//                    } else if (tmp instanceof Turismo) {
//                        ((Turismo) tmp).setNumeroPuertas(Integer.valueOf(tokens[7]));
//                        ((Turismo) tmp).setMarchaAutomatica(Boolean.valueOf(tokens[8]));
//                    } else if (tmp instanceof Furgoneta) {
//                        ((Furgoneta) tmp).setCarga(Integer.valueOf(tokens[7]));
//                        ((Furgoneta) tmp).setVolumen(Integer.valueOf(tokens[8]));
//                    }
//                }
                vehiculos.add(tmp);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.println(vehiculos.toString());
        }
    }
}
