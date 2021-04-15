/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author profesor
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        for (int i = 0; i < 90; i++) {
            if (i < 31) {
                vehiculos.add(Turismo.tAleatorio());
            } else if (i > 30 && i < 61) {
                vehiculos.add(Deportivo.dAleatorio());
            } else {
                vehiculos.add(Furgoneta.fAleatorio());
            }
        }

        String nomFichero = "vehículos.csv";
        String turismo = "0:";
        String deportivo = "1:";
        String fragoneta = "3:";

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(nomFichero))) {

            for (Vehiculo e : vehiculos) {
                String resp = "";
                if (e instanceof Deportivo) {
                    resp = deportivo + ((Deportivo) e).toString();
                    flujo.write(resp);
                }
                if (e instanceof Turismo) {
                    resp = turismo + ((Turismo) e).toString();
                    flujo.write(resp);
                }
                if (e instanceof Furgoneta) {
                    resp = fragoneta + ((Furgoneta) e).toString();
                    flujo.write(resp);
                }
                flujo.newLine();
            }
            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
