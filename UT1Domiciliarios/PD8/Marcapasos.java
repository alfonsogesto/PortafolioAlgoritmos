public class Marcapasos {
    short presionSanguinea; // Rango: 0-250
    short frecuenciaCardiaca; // Rango: 0-226
    short nivelAzucarSangre; // Rango 0-1000
    int fuerzaMax; // Rango: 0-3000000000
    float minTiempoEntreLatidos; // Valor en Decimales
    float bateriaRestante; // Porcentaje con decimales
    String codigoDelFabricante; // 8 caracteres maximo

    public Marcapasos(short presionSanguinea, short frecuenciaCardiaca, short nivelAzucarSangre,
            int maximaFuerza, float minTiempoEntreLatidos, float bateriaRestante, String codigoFabricante) {

        this.presionSanguinea = presionSanguinea;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.nivelAzucarSangre = nivelAzucarSangre;
        this.fuerzaMax = fuerzaMax;
        this.minTiempoEntreLatidos = minTiempoEntreLatidos;
        this.bateriaRestante = bateriaRestante;
        this.codigoDelFabricante = codigoDelFabricante;
    }

    public static void main(String[] args) {
        Marcapasos marcapaso = new Marcapasos((short) 120, (short) 80, (short) 100, 2000000000, 0.75f, 85.5f, "AB1234CD");
        System.out.println("El marcapasos y sus datos han sido registrados");
    }

}
/*
 *Calculo de memoria:
 Espacio que ocupan de memoria:
    Short: 16 bits
    Float: 32 bits
    int 32 bits
    String 16 bits

    Resultado: 16*3 + 32*2 + 16 = 128
 */