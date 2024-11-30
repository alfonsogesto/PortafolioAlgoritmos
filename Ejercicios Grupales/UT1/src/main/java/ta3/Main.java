package ta3;

/**
 * Hello world!
 */
public final class Main {
    

    public static void main(String[] args) {
        String texto = "Si piensas que tu profesor es exigente,... espera a conocer a te jefe !";
        
        ContadorPalabras contadorPalabras = new ContadorPalabras();
        //contadorPalabras.contarPalabras(texto);
        System.out.println("El número de palabras en el texto es: " + contadorPalabras.contarPalabras(texto));

        ContadorPalabras contadorPalabras2 = new ContadorPalabras();
        //contadorPalabras2.palabrasConLargoMayorA(texto, 5);
        System.out.println("El número de palabras con longitud mayor a 5 en el texto es: " + contadorPalabras2.palabrasConLargoMayorA(texto, 5));

    }


}