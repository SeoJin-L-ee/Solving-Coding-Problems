package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11286 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
        	int aa = Math.abs(a);
        	int bb = Math.abs(b);
			// 절댓값이 동일하면 원래 값으로 비교
        	if (aa == bb) return Integer.compare(a, b);
        	return Integer.compare(aa, bb);
        });
        
        for (int t = 0; t < N; t++) {
			int temp = Integer.parseInt(br.readLine());
			if (temp != 0) {
				pq.offer(temp);
			} else {
				Integer temp2 = pq.poll();
				// 큐가 비어 있었으면 null 대신 0 출력
				sb.append(temp2==null ? 0 : temp2).append("\n");
			}
		}
        System.out.println(sb);
    }
}