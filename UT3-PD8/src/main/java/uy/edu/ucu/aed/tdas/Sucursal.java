package uy.edu.ucu.aed.tdas;

    interface ISucursal {
        public String retornarCiudad();
    }

    public class Sucursal implements ISucursal {
        private String nombreCiudad;

        public Sucursal(String nombre) {
            this.nombreCiudad = nombre;
        }

        public String retornarCiudad() {
            return this.nombreCiudad;
        }
        public String toString() {
            return this.nombreCiudad;
        }
    }

