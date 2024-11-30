public class Contador {
    final int MAX_CONT = 50;
    int contador = 1;
    int incremento = 1;
    
    public Contador(){

    }

    public static void main(String[] args) {
        Contador contador = new Contador();
        System.out.println("Mostrar contador normal");
        contador.mostrarContador();
        System.out.println("Mostrar contador doWhile");
        contador.contadorDoWhile();
        System.out.println("Mostrar contador For");
        contador.contadorFor();
        
    }

    public void mostrarContador(){
        while(contador <= MAX_CONT){
            System.out.println(contador);
            contador += incremento;
        }
    }

    public void contadorDoWhile(){
        contador =1;
        do{
            System.out.println(contador);
            contador += incremento;
        } while (contador <= MAX_CONT);
    }

    public void contadorFor() {
        contador=1;
        for (;contador <= MAX_CONT; contador+=incremento){
            System.out.println(contador);
        }
    }
}