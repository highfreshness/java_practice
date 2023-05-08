
public class WhileNumberPlayer {
    private int limit;

    public WhileNumberPlayer(int limit) {
        this.limit = limit;
    }

    // public void printSquaresUptoLimit() {
    //     for(int i=1; i<=number; i++){
    //         if( i * i <= limit){
    //             System.out.print(( i * i ) + " ");
    //         }
    //     }
    // }

    public void printSquaresUptoLimit() {
        int i = 1;
        while(i*i<limit){
            System.out.print(i*i + " ");
            i++;
        }
    }

    // public void printCubeUptoLimit() {
    //     double temp;
    //     for(int i=1; i<=number; i++){
    //         temp = Math.pow(i, 3);
    //         if(temp <= limit){
    //             System.out.print((int)temp + " ");
    //         }
    //     }
    // }

    public void printCubeUptoLimit() {
        int i = 1;
        while(i * i * i < limit){
            System.out.print(i*i*i + " ");
            i++;
        }
    }
    
}
