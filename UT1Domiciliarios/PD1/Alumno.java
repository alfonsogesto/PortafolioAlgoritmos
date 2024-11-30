public class Alumno {
    private String nombre;

    public Alumno() {
        nombre = "Alfonso"; //Antes estaba incializado en nombre=null!
    }

    public String getNombreAdmiracion() {
        return nombre.concat("!");
    }

    public static void main(String[] args) {
        Alumno alumno = new Alumno();
        System.out.println(alumno.getNombreAdmiracion());
        System.out.println(recorrer("Verduras"));
        System.out.println(getValor());
        System.out.println(getPrimerCaracter("calabacin"));
        System.out.println(paraAString(2));
    }

    public static int recorrer(String cadena) {
        int res = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != ' ') {
                res++;
            }
        }
            return res;
    }
 
    public static int getValor() {
        int vector[] = { 6, 16, 26, 36, 46, 56, 66, 76 };
        int idx = 7;
        return vector[idx];
    }

    public static char getPrimerCaracter(String palabra) {
        return (palabra.charAt(0));
    }

    public static String paraAString(int a) {
        return String.valueOf(a);
    }
}   

/*
a) Indicar el error al ejecutar la clase Alumno y corregirlo. ¿cómo lo detectaste?
b) Indicar el error al ejecutar el método “recorrer” y corregirlo. ¿cómo lo detectaste?
c) Indicar el error al ejecutar el método “getValor” y corregirlo. ¿cómo lo detectaste?
d) Indicar el error al ejecutar el método “getPrimerCaracter” y corregirlo. ¿cómo lo detectaste?
e) Indicar el error al ejecutar el método “paraAString” y corregirlo. ¿cómo lo detectaste?

Respuestas:
a) El primer error en la clase Alumno, es que nombre esta incializado en null, entonces luego en la linea 9 cuando se quiere concatenar !
al nombre, este mismo luego arrastra el error y en la linea 14 tampoco imprime el nombre con la "admiración".

b) El metodo recorrer tiene de error tiene el contador que se inicializa en 0, pero el bucle for comienza con i=1, por ende nunca lo haria 
y da una excepción.
 
c)getValor tiene un error es que cuando se ejecuta da error(ArrayIndexOutOfBoundsException) que significa esta fuera del rango de vector, ya 
que idx es =8 pero la lista vector no tiene indice 8, sino que llega hasta el 7 e idx tendria que estar en idx=7 (en caso de querer sacar
el valor del ultimo indice).

d)getPrimerCaracter tiene como primer error que en su sengunda linea el string estaba en null, por lo que a la hora de dar el primer 
caracter nunca iba a funcionar, al correrlo dio como error la excepción "NullPointerException", ademas en el return estaba con charAt(1), 
que eso devolveria el segundo caracter y no el primero, por eso se cambia el return y se inicia en 0, esta vez directamente se pide el 
indice 0 de la palabra y no del string.

e)Al ejecutar el codigo original del metodo paraAString se da una conversion incorrecta del objeto x1 de tipo int a string lo que da el 
error de "ClassCastException". Ademas mi codigo me marca que la linea Object x1 = new Integer(a); usa el constructor "Integrer(a)" el cual
esta descontinuado desde la version 9. Por eso se usa String.valueOf(int) que comvierte al int a valor String.
*/