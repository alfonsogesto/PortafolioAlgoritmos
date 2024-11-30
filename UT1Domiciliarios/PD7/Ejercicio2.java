/*
EJERCICIO #2
Observa los siguientes fragmentos de código:
1.
String s1 = "Hola";
String s2 = "Hola";
if ( s1 == s2 ) {
System.out.println( "True" );
} else {
System.out.println( "False" );
}

2.
String s1 = new String("Hola");
String s2 = "Hola";
if ( s1 == s2 ) {
System.out.println( "True" );
} else {
System.out.println( "False" );
}

1)¿Qué sentencia se ejecuta como resultado del If en cada caso y por qué? Busca en internet
referencias que te permitan explicar las respuestas a las preguntas anteriores. Asegúrate que
las mismas sean autoritativas y cítalas adecuadamente en tu respuesta.
2)Propone una versión correcta del código del Ejercicio #1.
Ayuda: investiga cómo funciona el método intern() de la clase String.

RESPUESTAS:
1) Se imprime la sentencia 1 ya que en este caso, tanto `s1` como `s2` se asignan al literal "Hola". 
En Java, la JVM los almacena de forma tal que para la misma string es almacenada automaticamente y en
el mismo lugar, lo que significa que se almacenan en una ubicación específica de memoria. Esto se hace 
para ayudar a la JVM a optimizar la misma y reducir su memoria utilizada.

FUENTE UTILIZADA: https://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java

2) Codigo utilizado con equals(), referenciado en la respuesta anterior y uso adquirido a traves del
foro stackoverflow

String s1 = "Hola";
String s2 = "Hola";
if (s1.equals(s2)) {
    System.out.println("True");
} else {
    System.out.println("False");
}

*/