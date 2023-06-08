package com.hello;

import java.util.Scanner;

public class CU {

    public String chooseBread() {
        String bread;
        // 3. 빵을 고른다.(소보로, 생크림빵)
        Scanner sc = new Scanner(System.in);
        System.out.println("둘 중 원하는 빵을 입력해주세요 : soboro or cream");
        bread = sc.nextLine();
        return bread;
    }

    public int changeMoney(String bread, Object left) {
        int price;
        if (bread.equals("soboro")){
            price = 1000;
        }
        else{
            price = 1500;
        }
        return (int)left - price;
    }
}
