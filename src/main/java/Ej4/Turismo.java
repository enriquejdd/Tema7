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
public class Turismo extends Vehiculo{
    
    private int numeroPuertas;
    private boolean marchaAutomatica;

    public void activarVelocidadCrucero(){
        
        System.out.println("Activando velocidad crucero en turismo");
        
    }
    
    public Turismo(int numeroPuertas, boolean marchaAutomatica, String matricula, String marca, String modelo, String color, double precio, boolean disponible) {
        // Constructor parametrizado de la super clase (padre)
        super(matricula, marca, modelo, color, precio, disponible);
        // Inicialización de atributos propios
        this.numeroPuertas = numeroPuertas;
        this.marchaAutomatica = marchaAutomatica;
    }
    
    public Turismo(){
        // Llamada al constructor por defecto de la super clase
        super();
        this.numeroPuertas = 4;
        this.marchaAutomatica = true;
    }

    public int getNumeroPuertas() {

        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public boolean isMarchaAutomatica() {
        return marchaAutomatica;
    }

    public void setMarchaAutomatica(boolean marchaAutomatica) {
        this.marchaAutomatica = marchaAutomatica;
    }

    // Sobrescribe el toString de vehiculo
    @Override
    public String toString() {
        String atributosVehiculo = super.toString();
        return atributosVehiculo+ ":" + numeroPuertas + ":" + marchaAutomatica;
    }
    
    
    @Override
    public void arrancar(){
        System.out.println("Este turismo está arrancando...");
    }
    
    public static Turismo tAleatorio() {
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

        String letmat = "LFJ";
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
        
        int puertas = ale.nextInt(5-2+2);
        boolean auto = ale.nextBoolean();

        Turismo t = new Turismo(puertas, auto,matricula, marcas[ale.nextInt(marcas.length)], mode, colores[ale.nextInt(colores.length)], prec, disp);
        return t;
    }
    
}
