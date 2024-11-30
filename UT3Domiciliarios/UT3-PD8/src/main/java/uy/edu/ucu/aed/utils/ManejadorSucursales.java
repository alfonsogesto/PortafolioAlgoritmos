package uy.edu.ucu.aed.utils;

import java.util.ArrayList;

public class ManejadorSucursales implements IManejadorSucursales {
    
    ArrayList<Object> listaSucursales = new ArrayList<>();

    @Override
    public void agregarSucursal(Object sucursal) {
        this.listaSucursales.add(sucursal);
    }

    @Override
    public Object buscarSucursal(String clave) {
        for(Object sucursal : this.listaSucursales) {
            if(sucursal.toString().equals(clave)) {
                return sucursal;
            }
        }
        return null;
    }

    @Override
    public boolean quitarSucursal(String clave) {
        for(Object sucursal : this.listaSucursales) {
            if(sucursal.toString().equals(clave)) {
                this.listaSucursales.remove(sucursal);
                return true;
            }
        }
        return false;
    }

    @Override
    public String listarSucursales() {
        StringBuilder cadena = new StringBuilder();
        for(Object sucursal : this.listaSucursales) {
                cadena.append(sucursal.toString()).append(" ");
        }
        return cadena.toString();
    }

    @Override
    public int cantSucursales() {
        return this.listaSucursales.size();
    }

    @Override
    public boolean esVacio() {
        return this.listaSucursales.isEmpty();
    }
    
    public void cargarSucursales() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("sucursales.txt");
        for(String linea : lineas) {
            this.listaSucursales.add(new Sucursal(linea));
        }
    }
}
