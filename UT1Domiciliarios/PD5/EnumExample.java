public class EnumExample{
   public enum Player{
    Messi, Suarez,CR7, Neymar, Valverde, ViniJR
   } 

   public static void main(String[] args) {
    Player[] players = Player.values();
   
    for (Player player : players){
        System.out.println(player);
        }
    } 
}