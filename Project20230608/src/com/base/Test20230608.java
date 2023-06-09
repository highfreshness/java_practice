package com.base;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test20230608 {

	public static void main(String[] args) throws IOException {
		// printTest();
		// booleanTest();
		// switchState();
		// secondQuiz();
		thirdQuiz();
	}

	private static void thirdQuiz() throws IOException {
		/*
		 * switch의 가장 좋은 예
		 */
		
		// 1. 두 숫자 입력 전에 하나의 기호를 먼저 입력 받는다.
		// Scanner sc = new Scanner(System.in);
		// System.out.println("연산자를 입력해주세요 : ");
		// String op = sc.next();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("연산자를 입력해주세요 : ");
		String op = in.readLine();
		
		// 2. 두 숫자를 입력 받는다.(args :: String[])
		// 3. args[0], args[1]을 정수(int)형으로 변환
		// 5. 기호 : String -> char로 변환
		// 	  숫자 : String -> int로 변환
		// int i1 = Integer.parseInt(args[0]);
		// int i2 = Integer.parseInt(args[1]);

		String i1 = in.readLine();
		System.out.println("첫번째 입력값 :" + i1);
		String i2 = in.readLine();
		System.out.println("두번째 입력값 :" + i2);
		int intI1 = Integer.parseInt(i1);
		int intI2 = Integer.parseInt(i2);
		char opChar = op.charAt(0);
	
		// 6. 기호 모양에 따라 해당 연산을 해 결과를 result에 넣는다.
		int result=0;
		switch (opChar) {
		case '+':
			result = intI1 + intI2;
			break;
		case '-':
			result = intI1 - intI2;
			break;
		case '*':
			result = intI1 * intI2;
			break;
		case '/':
			result = intI1 / intI2;
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			break;
		}
		
		System.out.println(result);		
	}

	private static void secondQuiz() {
		int score = getScore();
		String grade = getGrade(score);
		String temp = String.format("당신의 점수는 %d점 학점은 %s 입니다.", score, grade);
		System.out.println(temp);
	}

	private static String getGrade(int score) {
		String grade;
//		if (score>=90) {
//			grade = "A";
//		}
//		else if(score>=80) {
//			grade = "B";
//		}
//		else if(score>=70) {
//			grade = "C";
//		}
//		else if(score>=60) {
//			grade = "D";
//		}
//		else {
//			grade = "F";
//		}
		
//		switch(score/10) {
//			case 10:
//			case 9:
//				grade = "A";
//				break;
//			case 8:
//				grade = "B";
//				break;
//			case 7:
//				grade = "C";
//				break;
//			case 6:
//				grade = "D";
//				break;
//			default:
//				grade = "F";
//				break;
//		}
		
		grade = (score >= 90) ? "A" : (score >= 80) ? "B" : 
				(score >= 70) ? "C" : (score >= 60) ? "D" : "F" ;
		
		return grade;
	}

	private static int getScore() {
		int score;
		Scanner sc = new Scanner(System.in);
		score = sc.nextInt();
		sc.close();
		return score;
	}

	private static void switchState() {
		f(5); f(6); f(7); f(8);
	}

	private static void f(int i) {
		switch( i % 5 ) { 
		case 0: 
		case 1:
			System.out.println( "5의 배수 혹은 + 1" );
			break;
		case 2:
			System.out.println( "5의 배수 + 2" );
		default:
			System.out.println( "default" );
		}
	}

	private static void printTest() {
		System.out.println( 12 ); // 12
		System.out.println( 012 ); // 10
		System.out.println( 0xA3 ); // 163 0x는 16진수
		System.out.println( 0x80000000 ); // -2147483648
		System.out.println( 5 % 3 ); // 2
		System.out.println( -5 % 3 ); // -2
		System.out.println( 0x80000001 << 2 ); // 4 = 0x00000004
		System.out.println( 0xFFFFFFFF ); // -1
		System.out.println( 0xFFFFFFFF >> 30 ); // -1 = 0xFFFFFFFF
		System.out.println( 0xFFFFFFFF >>> 30 ); // 3
		char c = 'a';
		System.out.println( c ); // a
		System.out.println( (int) c ); // 97 ASCII 코드
		System.out.println( '\141' ); // a 
		System.out.println( '\u0061' ); // a
		System.out.println( ++c ); // b
		int i = 0;
		System.out.println( 3 / i ); // ArithmeticException 발생
	}

	private static void booleanTest() {
		int i = 0;
		System.out.println( (i != 0) && ( 100/i > 10) ); // false
		System.out.println( (i == 0) || ( 100/i <= 10) ); // true
		System.out.println( ( i == 0) ? 100 : 100/i );  // 100
		System.out.println( true ^ (i == 2) ); // ^ = XOR, (1 == 1)이 항상 true이기 때문에 변경 
		System.out.println( (i != 0) & ( 100/i > 2) );  // throw ArithmeticException (divide by zero)
		System.out.println( (i == 0) | ( 100/i <= 10) ); // throw ArithmeticException (divide by zero)
	}

}
