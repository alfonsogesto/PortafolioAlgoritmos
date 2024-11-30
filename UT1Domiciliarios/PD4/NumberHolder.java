public class NumberHolder {
    public int anInt;
    public float aFloat;
    
    public static void main(String[] args) {
        NumberHolder holder = new NumberHolder();
        holder.anInt = 42;
        holder.aFloat = 3.14f;
        System.out.println("Valor anInt: " + holder.anInt);
        System.out.println("Valor aFloat: " + holder.aFloat);
    }
}
