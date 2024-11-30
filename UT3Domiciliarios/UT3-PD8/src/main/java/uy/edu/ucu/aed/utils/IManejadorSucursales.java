package uy.edu.ucu.aed.utils;

public interface IManejadorSucursales {
    public void agregarSucursal(Object sucursal);
    public Object buscarSucursal (String clave);
    public boolean quitarSucursal (String clave);
    public String listarSucursales();
    public int cantSucursales();
    public boolean esVacio();
}
