/* Parte 1
String s = "1";
while(s!="1000")
    {
        s += "0";
    }
}
El codigo de este bucle infinito nunca se cerrará ya que al string s="1" se le agrega un 0 continuamente por lo que nunca será igual
a la comparacion que se hace en el while. Esto pasa debido a que == en java compara las referencias de memoria del objeto y no la textual,
por lo que para el programa eso nunca será igual. La diferencia con C# es que en dicha comparación este programa devolveria true solo si 
las cadenas tuviesen el mismo contenido, ya que == en C# compararia los valores de los objetos   

*/
