package uy.edu.ucu.aed.tdas;

import uy.edu.ucu.aed.utils.UtilGrafos;

public class Programa {

//     /**
//      * @param args the command line arguments
//      */
    public static void main(String[] args) {
            TGrafoActores grafoNoDirigido =  UtilGrafos.cargarGrafo("./src/actores.csv", "./src/en_pelicula.csv",
                        false, TGrafoActores.class);
        
        
                String[] actores = {"John_Goodman", "Tom_Cruise", "Jason_Statham", "Lukas_Haas", "Djimon_Hounsou", "Harrison_Ford", "Kevin Bacon"};
        
                for (String actor : actores) {
                    int numBacon = grafoNoDirigido.numBacon(actor);
                    System.out.println("El número de Bacon de " + actor + " es: " + numBacon);
                }
        

    }
}