/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej4;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author profesor
 */
public class Vehiculo {

    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double precio;
    private boolean disponible;

    public void arrancar() {
        System.out.println("Este vehículo está arrancando...");
    }

    // Sobrecarga de métodos reparar
    public void reparar() {
        System.out.println("El vehículo está en el taller");
    }

    public void reparar(int horas) {
        System.out.println("El vehículo está en el taller " + horas
                + " horas");
    }

    public Vehiculo(String matricula, String marca, String modelo, String color, double precio, boolean disponible) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.disponible = disponible;
    }

    public Vehiculo() {
        this.matricula = "";
        this.marca = "Sin marca";
        this.modelo = "Sin  modelo";
        this.color = "Sin color";

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return matricula + ":" + marca + ":" + modelo + ":" + color + ":" + precio + ":" + disponible;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.matricula);
        hash = 29 * hash + Objects.hashCode(this.marca);
        hash = 29 * hash + Objects.hashCode(this.modelo);
        hash = 29 * hash + Objects.hashCode(this.color);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 29 * hash + (this.disponible ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (this.disponible != other.disponible) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        return true;
    }

    public static Vehiculo vAleatorio() {
        Random ale = new Random();
        ArrayList<Integer> matric = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            matric.add(i);
        }

        String[] colores = {"Verde", "Gris", "Blanco", "Rojo", "Rosa", "Amarillo", "Azul"};
        String[] marcas = {"Ford", "Seat", "Peugeot", "Kia", "Audi", "Mercedes", "Nissan"};

        String letmat = "FGH";

        int num = ale.nextInt(matric.size());
        int nummat = matric.get(num);
        matric.remove(num);
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

        Vehiculo v = new Vehiculo(matricula, marcas[ale.nextInt(marcas.length)], mode, colores[ale.nextInt(colores.length)], prec, disp);
        return v;
    }

}
