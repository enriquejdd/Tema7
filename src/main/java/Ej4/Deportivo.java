/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej4;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author profesor
 */
public class Deportivo extends Vehiculo {

    private int cilindrada;

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public Deportivo() {
        // Implícitamente está llamando a super();
    }

    public Deportivo(int cilindrada, String matricula, String marca, String modelo, String color, double precio, boolean disponible) {
        super(matricula, marca, modelo, color, precio, disponible);
        this.cilindrada = cilindrada;
    }

    public void activarModoSport() {
        System.out.println("Activando modo sport en deportivo");
    }

    @Override
    public String toString() {
        return super.toString() + ":" + cilindrada;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.cilindrada;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (!super.equals(obj)) {
            return false;
        }

        final Deportivo other = (Deportivo) obj;

        if (this.cilindrada != other.cilindrada) {
            return false;
        }
        return true;
    }

    public static Deportivo dAleatorio() {
        Random ale = new Random();
        String[] colores = {"Verde", "Gris", "Blanco", "Rojo", "Rosa", "Amarillo", "Azul"};
        String[] marcas = {"Ford", "Seat", "Peugeot", "Kia", "Audi", "Mercedes", "Nissan"};
        
        ArrayList<Integer> matric = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            matric.add(i);
        }
        int num = ale.nextInt(matric.size());
        int nummat = matric.get(num);
        matric.remove(num);

        String letmat = "THR";
        String numMat = "" + nummat;
        String matricula;

        int mod = ale.nextInt(10);
        String mode = "" + mod;

        int prec = ale.nextInt(35000);
        boolean disp = ale.nextBoolean();

        switch (numMat.length()) {
            case 1:
                matricula = "00" + numMat + letmat;
                break;
            case 2:
                matricula = "0" + numMat + letmat;
                break;
            default:
                matricula = numMat + letmat;
                break;
        }

        int cili = ale.nextInt(150);

        Deportivo d = new Deportivo(cili, matricula, marcas[ale.nextInt(marcas.length)], mode, colores[ale.nextInt(colores.length)], prec, disp);
        return d;
    }

}
