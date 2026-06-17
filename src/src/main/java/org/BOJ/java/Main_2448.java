package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2448 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int N = Integer.parseInt(br.readLine());
    	ArrayList<String> semo = new ArrayList<>();
    	semo.add("  *  ");
    	semo.add(" * * ");
    	semo.add("*****");
    	
    	int cnt = 3;
    	while (cnt < N) {
    		ArrayList<String> nextSemo = new ArrayList<>();
    		
    		// 기존에 찍어둔 삼각형 양옆에, 이번 단계에 필요한(새로 늘어날) 칸 수만큼 공백 추가
    		String space = blank(cnt);
    		for (String line : semo) nextSemo.add(space + line + space);
    		
    		// 다음 크기의 삼각형 만들기
    		for (String line : semo) nextSemo.add(line + " " + line);
    		
    		semo = nextSemo;
    		cnt *= 2;
    	}
    	for (String line : semo) {
    		sb.append(line).append("\n");
    	}
    	System.out.print(sb);
    }
    
    static String blank(int cnt) {
    	String temp = "";
    	for (int i = 0; i < cnt; i++) temp += " ";
    	return temp;
    }
}