public class WhilePlayerRunner {
    public static void main(String[] args) throws Exception {
        WhileNumberPlayer player = new WhileNumberPlayer(30);

        player.printSquaresUptoLimit();
        //For limit = 30, output would be 1, 4, 9, 16, 25
        System.out.println();

        player.printCubeUptoLimit();
        //For limit = 30, output would be 1, 8, 27
    }
}
