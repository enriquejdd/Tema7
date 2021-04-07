/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Implementa un programa que vaya escribiendo líneas de texto en un archivo. El
 * archivo se llamará “teclado.txt” y se creará en la raíz del proyecto. El
 * programa irá solicitando líneas de texto al usuario (cada línea termina con
 * un salto de línea , ‘\n’) y las irá escribiendo en el fichero. Cuando en una
 * nueva línea el usuario introduzca el texto “EOF”, el programa terminará y esa
 * línea no se escribirá en el fichero. Controla las posibles excepciones que
 * pudieran ocurrir.
 *
 * @author Enrique
 */
public class Ej2 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String nomFichero = "teclado.txt";

        String texto = "";
        String salida = "EOF";

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(nomFichero))) {
            do {
                System.out.println("¿Qué desea escribir en el archivo?");
                texto = teclado.nextLine();
                if (!texto.equals(salida)) {
                    flujo.write(texto);
                    flujo.newLine();
                }
            } while (!texto.equals(salida));

        } catch (IOException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace(); -- Remarca todos los datos de la excepcion cuando se de
        }

    }
}
