/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Implementa un programa que guarde exactamente 50 líneas de texto en un
 * fichero, cuyo nombre se deja a tu elección. En cada línea se irán generando
 * letras aleatorias (entre la ‘a’ y la ‘Z’) y se irán separando por comas (,)
 * hasta que la letra que se vaya a escribir sea ‘x’ o ‘X’.
 *
 * @author Enrique
 */
public class Ej3 {

    public static void main(String[] args) {
        Random ale = new Random();
        int numLineas = 50;
        String nomFichero = "letrasAleatorias.txt";

        String letra = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz";
        int cantidad = letra.length();
        char resultado;

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(nomFichero))) {

            for (int i = 0; i < numLineas; i++) {
                resultado = letra.charAt(ale.nextInt(cantidad));
                if (resultado != 'X' && resultado != 'x') {
                    flujo.write(resultado + ",");
                } else {
                    flujo.write(resultado);
                    flujo.newLine();
                }

                if (i + 1 == 50) {
                    flujo.write(resultado);
                }
                flujo.flush();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
