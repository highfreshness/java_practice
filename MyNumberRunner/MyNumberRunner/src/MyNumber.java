
public class MyNumber {
    private int number;

    public MyNumber(int number) {
        this.number = number;
    }

    public boolean isPrime() {
        // 1 또는 음수일 경우
        if(number<2){
            return false;
        }

        for(int i=2; i<=number-1; i++){
            if(number % 2 == 0){
                return false;
            }
        }
        return true;
    }

    public int sumUptoN() {
        int temp = 0;
        for(int i=1; i<=number;i++){
            temp += i;
        }
        return temp;
    }

    public int sumOfDivisors() {
        // 주어진 수의 약수가 아닌 수 더하기
        int sum = 0;
        // 1과 number는 제외
        for(int i= 2; i<=number-1; i++){
            if(number % i ==0){
                sum += i; 
            }
        }
        return sum;
    }

    // public void printNumberTriangle() {
    //     for(int i=1; i<=number; i++){
    //         for(int j=1; j<=i; j++){
    //             System.out.print(j +" ");
    //         }
    //         System.out.println();
    //     }
    // }

    public void printNumberTriangle() {
        String temp="";
        for(int i=1; i<=number; i++){
            temp += Integer.toString(i);
            temp += " ";
            System.out.println(temp);
        }
    }
}

temp