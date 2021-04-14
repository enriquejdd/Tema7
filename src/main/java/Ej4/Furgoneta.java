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
 * @author enrique
 */
public class Furgoneta extends Vehiculo {

    private int carga; // En kg
    private int volumen; // En m3

    public Furgoneta(int carga, int volumen, String matricula, String marca, String modelo, String color, double precio, boolean disponible) {
        super(matricula, marca, modelo, color, precio, disponible);
        this.carga = carga;
        this.volumen = volumen;
    }

    public Furgoneta() {
        this.carga = 1000;
        this.volumen = 8;
    }   

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    @Override
    public String toString() {
        return super.toString() + ":" + carga + ":" + volumen;
    }   

    public void metodoFurgoneta(){
        System.out.println("Este método es de la clase Furgoneta");
    }
    
    public static Furgoneta fAleatorio() {
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

        String letmat = "KYM";
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
        
        int peso = ale.nextInt(3500-1500+1500);
        int vol = ale.nextInt(100);

        Furgoneta f = new Furgoneta(peso, vol, matricula, marcas[ale.nextInt(marcas.length)], mode, colores[ale.nextInt(colores.length)], prec, disp);
        return f;
    }
}
