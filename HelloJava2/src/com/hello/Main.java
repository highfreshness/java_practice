package com.hello;

public class Main {
    public static void main(String[] args) {
        /*
        동생에게 돈을 주고 빵 심부름 시키기(1500원)
        1. 동생에게 돈을 준다.
        2. 편의점을 간다.
        3. 빵을 고른다.(소보로 - 1000원, 생크림빵 - 1500원)
        4. 점원에게 돈을 준다.
        5. 잔돈이 남으면 거스름돈과 빵을 같이 돌려준다.
        */

        int left;

        // 1. 동생에게 돈을 준다.
        left = 1500;

        // 2. 편의점에 간다.
        goConvenience(left);
    }

    private static void goConvenience(int left) {
        String bread;
        CU cu = new CU();
        // 3. 빵을 고른다.(소보로 - 1000원, 생크림빵 - 1500원)
        bread = cu.chooseBread();
        // 4. 점원에게 돈을 준다.
        int change = cu.changeMoney(bread, left);
        // 5. 잔돈이 남으면 거스름돈과 빵을 같이 돌려준다.
        String sentence = String.format("%s빵과, 잔돈 %d원을 가져왔습니다.", bread, change);
        System.out.print(sentence);
    }
}