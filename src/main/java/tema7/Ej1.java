/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 1.- Implementa un programa que genere un fichero de texto en la carpeta raíz
 * del proyecto, llamado “matriz.txt”, donde se escriba la siguiente tabla de
 * valores numéricos. Utiliza el tabulador para ir separando cada número y el
 * salto de línea para añadir nuevas líneas. Ten en cuenta que el programa debe
 * ser escalable, de forma que se pueda generar cualquier matriz que siga el
 * patrón.
 *
 * 100 101 102 103 200 201 202 203 300 301 302 303 400 401 402 403
 *
 *
 * @author Enrique
 */
public class Ej1 {

    public static void main(String[] args) {
        String nomFichero = "matriz.txt";
        int[][] num = new int[3][3];

//        int num[][] = {{100, 101, 102, 103}, {200, 201, 202, 203}, {300, 301, 302, 303}, {400, 401, 402, 403}};
        int inicial = 100;

        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(nomFichero))) {

            for (int i = 0; i < num.length; i++) {
                for (int j = 0; j < num[i].length; j++) {
                    if (j == 0 && i == 0) {
                        num[0][0] = inicial;
                    }
                    if (j == 0) {
                        num[i][j] = inicial + (inicial * i);
                        flujo.write(num[i][j] + "\t");
                    } else {
                        num[i][j] = inicial + (inicial * i) + j;
                        flujo.write(num[i][j] + "\t");
                    }
                }
                flujo.newLine();

            }
            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
