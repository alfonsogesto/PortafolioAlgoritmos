package uy.edu.ucu.aed.utils;

import uy.edu.ucu.aed.tdas.ArbolAVL;

public class main {
    public static void main(String[] args) {
        // Cargando claves 1
        //String[] lineasArchivoClaves = ManejadorArchivosGenerico
        //.leerArchivo("clavesPrueba.txt");  
        //
//
        //// Cargando consultas
        //String[] lineasArchivoConsulta = ManejadorArchivosGenerico
        //        .leerArchivo("consultaPrueba.txt");
        //
        //ArbolBB<String> arbolBB = new ArbolBB();
        //for (String clave : lineasArchivoClaves) {
        //    arbolBB.insertar(Integer.parseInt(clave), clave);
        //}
//
        //for (String consulta : lineasArchivoConsulta) {
        //    String elemento = arbolBB.buscar(Integer.parseInt(consulta));
        //        System.out.println(elemento);
        //    }
        
        /*
         Main de ArbolAVL
        */

        ArbolAVL<String> arbolAVL = new ArbolAVL<>();
        arbolAVL.insertar("1", "1");
        arbolAVL.insertar("2", "2");
        arbolAVL.insertar("3", "3");
        arbolAVL.insertar("4", "4");
        arbolAVL.insertar("5", "5");

        System.out.println(arbolAVL.getRaiz());
        System.out.println(arbolAVL.buscar("1"));

        arbolAVL.levelOrder(arbolAVL.getRaiz());
    } 

}