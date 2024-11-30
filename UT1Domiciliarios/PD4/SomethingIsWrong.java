public class SomethingIsWrong {
    public static void main(String[] args) {
    Rectangle myRect = new Rectangle(); //El error de la parte A se encontraba aca ya que inicialmente decia: Rectangle myRect; 
    myRect.width = 40;
    myRect.height = 50;
    System.out.println("myRect's area is " + myRect.area());
    }
}
//Clases creadas debido a que sino se imposibilitaba la resolucion completa del codigo
class Rectangle{
    int width;
    int height;

    public int area(){
        return height*width;
    }
    
}
