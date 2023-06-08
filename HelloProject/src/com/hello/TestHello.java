package com.hello;
/*
1. 나는 꼬마한테 "왼손 내밀어" 라고 말한다.
	> left
2. 나는 꼬마의 왼손에 1,000원을 준다.
    > left = 1000
3. 나는 꼬마에게 (편의점에서) “누가바”를 사오라고 말한다.
	> cu
	> buyIcecream(left)
4. 꼬마는 편의점으로 간다.
	> new CU
5. 꼬마는 점원한테 “누가바”를 주세오 라고 말한다(왼손을 내밀어 돈을 보여주며).
	> cu.getIcecream(left)
6. 점원이 냉동고에서 “누가바”를 집어온다.
	> (CU내부에서) result = "누가바"
7. 점원은 꼬마 왼손의 돈을 받고 “누가바”를 오른손에 건네준다.
	> return result
8. 꼬마는 오른손에 점원이 준 아이스크림을 받는다.
	> right = cu.getIcecream(left)
9. 집으로 돌아온 꼬마는 나의 왼손에  오른손에 있던 누가바를 준다.
	> syso(right)
 */


public class TestHello {

	public static void main(String[] args) {
		// 1. 나는 꼬마한테 "왼손 내밀어" 라고 말한다.
		Object left;
		// 2. 나는 꼬마의 왼손에 1,000원을 준다.
	    left = 1000;
	    // 9. 집으로 돌아온 꼬마는 나의 왼손에  오른손에 있던 누가바를 준다.
	    Object right = buyIcecream(left);
		System.out.println(right);
	}

	private static Object buyIcecream(Object left) {
		// 3. 나는 꼬마에게 (편의점에서) “누가바”를 사오라고 말한다.
		System.out.println("사와 누가바");
		System.out.println();
		// 4. 꼬마는 편의점으로 간다.
		CU cu = new CU();
		// 5. 꼬마는 점원한테 “누가바”를 주세오 라고 말한다(왼손을 내밀어 돈을 보여주며).
		cu.getIcecream(left);
		// 8. 꼬마는 오른손에 점원이 준 아이스크림을 받는다.
		Object right = cu.getIcecream(left);
		return right;
	}

}
