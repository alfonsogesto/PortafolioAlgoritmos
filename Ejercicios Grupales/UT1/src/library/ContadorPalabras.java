package src.library;

public class ContadorPalabras {
    /*
     * La función deberá recorrer una cadena de caracteres y diferenciar las
     * palabras para poder contarlas.
     * Podemos plantear dos casos, caso 1; luego de una cadena de caracteres hay un
     * espacio y luego otra cadena de caracteres ("aaa aaa")
     * y con al menos una letra
     * caso 2, que haya solamente una única cadena de caracteres. ("aaa").
     * Para el caso uno, la solución sería contar los espacios y sumarle 1.
     * para el caso 2 es checkear que no hayan espacios y que no sea un string
     * vacío, en ese caso el resultado es 1.
     */
    public String contarPalabras(String frase) {
        int contador = 0;
        int aux = 0;
        int consonante = 0;
        int vocal = 0;
        String texto = "AEIOUaeiou";  
        for (int i = 0; i < frase.length(); i++) {
            
            char letra = frase.charAt(i);

            if (Character.isLetter(letra)) {
                aux++;
               //Identificamos que haya una letra y luego se chequea si es vocal y en base a eso se suma al contador de vocales o de consonantes
               //No se hace un return de estas variables porque la letra no lo pide, pero los resultados son correctos
                if(texto.contains(Character.toString(letra)))
                {
                    vocal++;
                }
                else 
                {
                    consonante++;
                }

            }
            if (frase.charAt(i) == ' ' && (aux > 0)) {
                contador++;
                aux = 0;
            }

        }

        if (aux != 0) {
            contador++;
        }
        System.out.println("vocales: "+ vocal + " consonante: " + consonante);
        return "palabras: "+ contador;
    }
}