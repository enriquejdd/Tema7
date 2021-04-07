/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Implementa un programa para leer los datos del fichero del ejercicio 1. El
 * programa, al finalizar de leer la matriz debe mostrar la suma de todos los
 * valores.
 *
 * @author enrique
 */
public class Ej5 {

    // Método que se encarga de abrir el fichero de ruta "idFichero"
    // y carga los objetos Persona en una lista, que devuelve
    public static void main(String[] args) {

        // Fichero a leer
        String idFichero = "matriz.txt";

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        int valor = 0;

//        System.out.println("Leyendo el fichero: " + idFichero);
//
//        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
//        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
//        // las operaciones con el archivo
//        try (Scanner datosFichero = new Scanner(new FileReader(idFichero))) {
//
//            // Mientras haya líneas por leer
//            while (datosFichero.hasNextLine()) {
//
//                linea = datosFichero.nextLine(); //Se lee la línea
//                System.out.println(linea); // Se imprime en pantalla
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        }

        // El mismo ejemplo pero separando cada elemento
        // leído usando el método split() de la clase String */
        try (Scanner datosFichero = new Scanner(new FileReader(idFichero))) {

            System.out.println("Separando cada elemento del fichero: ");

            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador coma
                tokens = linea.split(",");

                for (String string : tokens) {
                    valor = valor + Integer.parseInt(string);

                }

                System.out.println(valor);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

}
