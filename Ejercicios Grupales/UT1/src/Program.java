package src;

import src.library.ContadorPalabras;

class Principal {
    public static void main (String args[]) {
        ContadorPalabras contador= new ContadorPalabras();
        String s ="aaa 333 aaa";
        System.out.println(contador.contarPalabras(s));


    }
    }
