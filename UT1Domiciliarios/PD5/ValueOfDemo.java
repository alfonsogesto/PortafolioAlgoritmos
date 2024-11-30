public class ValueOfDemo {
    public static void main(String[] args) {
        // this program requires two arguments on the command line
        if (args.length == 2) {
            // convert strings to numbers
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);

            // do some arithmetic
            System.out.println("a + b = " + (a + b));
            System.out.println("a - b = " + (a - b));
            System.out.println("a * b = " + (a * b));
            System.out.println("a / b = " + (a / b));
            System.out.println("a % b = " + (a % b));
        } else {
            System.out.println("This program requires two command-line arguments.");
        }
    }
}
/*
Parte 1 
*PS C:\Users\Alfonso\Desktop\PD5> javac ValueOfDemo.java
PS C:\Users\Alfonso\Desktop\PD5> java ValueOfDemo 13.4 66.1
a + b = 79.5
a - b = -52.699997
a * b = 885.7399
a / b = 0.20272315
a % b = 13.4
Parte 2: Modificada en el codigo
*/