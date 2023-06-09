package com.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class TodayQuest {

	public void printHello() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello " + i + "번째");
		}
	}

	public void arrayTest() {
		int[] a; // int의 배열에 대한 참조값을 갖는 변수
		int a2[]; // a와 동일
		a = new int[3]; // 3개 짜리 int를 갖는 배열
		a2 = new int[] {1, 2}; // 이름이 없는 배열
		String[] as = { "array", "of", "string", };
		String[] as2 = { "another", "array", }; // String 객체의 참조값의 배열 생성
		System.out.println( as.length ); // 3
		for(int i = 0; i < as.length; ++i)
			System.out.println( as[i] ); // array  / of / string
		as = as2;
		System.out.println( as.length ); // 2
		for(int i = 0; i < as.length; ++i)
			System.out.println( as[i] ); // another
		// array
		as2 = null;
	}

	public void arrayTest2() {
		// ArrayList ar = new ArrayList(); // E = element 내부 요소를 나타냄
		// ArrayList<String> ar = new ArrayList<String>();
		// 첨삭(끼워넣기, 삭제)이 많은 경우 사용(=Pandas reset_index와 비슷)
		LinkedList<String> ar = new LinkedList<String>(); 
		// ar.add(5); // Integer
		ar.add("5");
		ar.add("Hello"); // String
		// ar.add(3.14); // Double
		ar.add("3.14");
		// ar.add('C'); // Character
		ar.add("C");
		// ar.add(false); // Boolean
		ar.add("false");
		System.out.println(ar.size());
		System.out.println(ar.get(1));
		System.out.println();
		// 3.14, G 삭제
		System.out.println("처음 리스트-----");
		System.out.println(ar);
		System.out.println();
		ar.remove(2);
		ar.remove(2);
		System.out.println("삭제 후 리스트-----");
		System.out.println(ar);
		System.out.println();
		System.out.println("Boolean 변경 후 -----");
		ar.set(2, "true");
		System.out.println(ar);
	}

	public void setTest() {
		// Object를 이용하는 경우 object 별로 원래 가지고 있던 type을 가지고 있기 때문에
		// 아래와 같은 코드를 통해 원래 형태로 형변환을 해 변수를 반환할 수 있다.
		/*
			  for (Object obj : list) {
	            if (obj instanceof Integer) {
		            int intValue = (int) obj; // Unboxing
		            System.out.println("Integer: " + intValue);
		        } else if (obj instanceof Character) {
		            char charValue = (char) obj; // Unboxing
		            System.out.println("Character: " + charValue);
		        } else if (obj instanceof String) {
		            String strValue = (String) obj;
		            System.out.println("String: " + strValue);
		        } else {
		            System.out.println("Unknown type: " + obj);
		        }
	    	 }
		 */
		ArrayList<Object> ar = new ArrayList<>(); 
		ar.add(5);
		ar.add(5);
		ar.add("string");
		ar.add("string");
		ar.add('C');
		ar.add('C');
		ar.add(false);
		ar.add(false);
		ar.add(3.14);
		ar.add(3.14);
		System.out.println("중복이 있는 리스트=====");
		System.out.println(ar.size());
		System.out.println(ar);
		System.out.println();
		HashSet st = new HashSet<>(ar);
		System.out.println("HashSet을 통해 중복을 제거한 Set");
		System.out.println(st.size());
		System.out.println(st);
	}

	public void mapTest() {
		HashMap<String, String> mp = new HashMap<>();	
		mp.put("1", "First");
		mp.put("2", "Second");
		mp.put("3", "Third");
		mp.put("4", "Fourth");
		mp.put("5", "Fifth");
		System.out.println(mp);
		System.out.println();
		mp.replace("2", "Second", "sc"); // (key, old value, new value)
		System.out.println(mp);
	}
}
