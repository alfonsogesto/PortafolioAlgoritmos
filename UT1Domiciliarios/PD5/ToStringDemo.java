public class ToStringDemo {
    public static void main(String[] args) {
        double d = 888.51;
        String s = Double.toString(d);
        int dot = s.indexOf('.');
        System.out.println(dot + " digits " +
                "before decimal point.");
        System.out.println((s.length() - dot - 1) +
                " digits after decimal point.");
    }
}
/*
 1. La salida al ejectuar es: 
3 digits before decimal point.
2 digits after decimal point.

2. Se imprime primero "3 digits before decimal point" 
debido a que la cadena fouble de 888.51 tiene 3 caracteres
antes del decimal y por eso devuelve el 3. 

La impresion de " digits after decimal point" se imprime debido 
a que identifica que el número continua luego del . y suma cuantas
posiciones de numeros le siguen, restando el punto del decimal.
 */