package ta3;

/*
El objetivo es implementar un programa en Java que cuente la cantidad
de palabras en una frase, como no se puede utilizar la función "split" usaremos la lógica de conteo 
de palabras que encapsulará en la función ContadorPalabras y se probará en una clase Principal con el método main.  
En cambio, se utilizarán métodos como isLetter para identificar caracteres alfabéticos y determinar 
las palabras que hay en la frase. 
 */

public class ContadorPalabras {
    public ContadorPalabras() {}

    public String contarPalabras(String texto) {
        
        int contador = 0;
        boolean enPalabra = false;
        int vocal = 0;
        int consonante= 0;
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
        
            if (Character.isLetter(caracter)) {
                if (!enPalabra) {
                    enPalabra = true;
                    contador++;
                
                if(texto.contains(Character.toString(caracter)))
                {
                    vocal++;
                }
                else 
                {
                    consonante++;
                }
                }
            } else {
                enPalabra = false;
            }
            
            
        }
        System.out.println("vocales: "+ vocal + " consonante: " + consonante);
        return "palabras: "+ contador;
    }

    public int palabrasConLargoMayorA(String texto, int longitudMinima) {
        int contador = 0;
        int contadorDePalabrasMayores = 0;
        //boolean enPalabra = false;
        String palabra = "";
        
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
        

            if (Character.isLetter(caracter)) {
                palabra += caracter;
            }
            if (caracter == ' ' || caracter == '.')  {
                if (palabra.length() > longitudMinima) {
                    palabra = "";
                    contadorDePalabrasMayores++;
                } else {
                    palabra = "";
                }
            }
        }
        
        return contadorDePalabrasMayores;
    }
}




 /*
    
Luego de abierto el archivo, podemos leer cada una de las líneas contenido en el mismo mediante el método
“readLine()” de la clase BufferedReader. Por lo general queremos leer todas las líneas del archivo, por lo que
debemos iterar hasta que no existan más líneas por leer.
String linea = br.readLine();
while (linea != null) {
System.out.println(linea);
linea = br.readLine();
}
*/