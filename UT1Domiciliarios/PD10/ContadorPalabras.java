import java.util.Arrays;

public class ContadorPalabras {
    public ContadorPalabras() {}

    public String contarPalabras(String texto) {
        int contador = 0;
        boolean enPalabra = false;
        int vocal = 0;
        int consonante = 0;
        
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
        
            if (Character.isLetter(caracter)) {
                if (!enPalabra) {
                    enPalabra = true;
                    contador++;
                
                    if (Character.toString(caracter).matches("[aeiouAEIOU]")) {
                        vocal++;
                    } else {
                        consonante++;
                    }
                }
            } else {
                enPalabra = false;
            }
        }
        System.out.println("vocales: " + vocal + " consonantes: " + consonante);
        return "palabras: " + contador;
    }

    public String[] palabrasComunes(String[] palabra1, String[] palabra2) {
        return Arrays.stream(palabra1)
                     .filter(palabra -> Arrays.asList(palabra2).contains(palabra))
                     .toArray(String[]::new);
    }
}

/*
La nueva funcionalidad lo que hace es recibir dos arrays de cadenas de texto palabra1 
y palabra2 y lo que devuelve es una array con las palabras que se encuentran en los dos. 
Este usa metodo stream para filtrar las palabras repetidas en ambos arrays, el resultado
de eso se devuelve. Luego en main se dan los arrays con las palabras a evaluar, se llama 
al metodo palabrasComunes y se printea.
*/