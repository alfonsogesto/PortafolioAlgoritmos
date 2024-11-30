package uy.edu.ucu.aed.tdas;

import uy.edu.ucu.aed.utils.ManejadorSucursales;

public class App {
    public static void main(String[] args) {
        ManejadorSucursales manejador = new ManejadorSucursales();
        manejador.cargarSucursales();
        // USO DEL ARCHIVO suc1.txt
        System.out.println(manejador.cantSucursales());
        System.out.println(manejador.listarSucursales());

        manejador.quitarSucursal("Chicago");
        System.out.println(manejador.listarSucursales());


    }
}
