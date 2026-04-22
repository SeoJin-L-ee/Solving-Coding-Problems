package org.BOJ.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_1158 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		
		for (int i=1; i<=N; i++) {
			dq.add(i);
		}
		
		StringBuilder sb = new StringBuilder(N*3);
        sb.append("<");
        
        while (!dq.isEmpty()) {
        	// K-1번동안 맨 앞사람을 뒤로 보냄
        	for (int i=0; i<K-1; i++) {
        		int selected = dq.removeFirst();
        		dq.addLast(selected);
        	}
        	// K번째 사람을 제거한 후, 결과에 추가
        	sb.append(dq.removeFirst());
        	
        	// 큐에 다음 사람이 있다면 "," 추가
        	if (!dq.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
	}
}
