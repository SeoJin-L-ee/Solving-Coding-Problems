package org.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2247 {
	
	static class Time implements Comparable<Time> {
		int start, end;
		
		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Time t) {
			if (this.start != t.start) {
				return this.start - t.start;
			}
			return this.end - t.end;
		}
	}

	public static void main(String[] args) throws Exception {
		Time[] times;
		int currPeriodStart = 0, currPeriodEnd = 0; // 현재 이어지고 있는 연속구간의 처음과 끝
		int maxExist = 0; // 가장 길게 머무른 시간
		int maxEmpty = 0; // 가장 길게 비어있었던 시간
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		times = new Time[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			times[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		// 입장 순서대로 정렬
		Arrays.sort(times);
		
		for (int i = 0; i < N; i++) {
			int personStart = times[i].start;
			int personEnd = times[i].end;
			
			// 현재 streak?랑 겹치는 범위이면 currPeriodEnd값 비교 및 갱신
			if (personStart <= currPeriodEnd) {
				currPeriodEnd = Math.max(personEnd, currPeriodEnd);
			} else { // 도서관이 비었던 시간이 존재하면 
				// 현재 종료된 연속구간과, 최장연속구간 비교 및 갱신
				maxExist = Math.max(maxExist, currPeriodEnd - currPeriodStart);
				// 공백 시간도 비교 및 갱신
				maxEmpty = Math.max(maxEmpty, personStart- currPeriodEnd);
				// 새 연속구간 시작
				currPeriodStart = personStart;
				currPeriodEnd = personEnd ;
			}
		}
		maxExist = Math.max(maxExist, currPeriodEnd - currPeriodStart);
		
		System.out.println(maxExist + " " + maxEmpty);
	}
}
