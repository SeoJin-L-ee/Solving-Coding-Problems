package org.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1016 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int answer = 0;
		
		int cnt1 = 0, cnt2 = 0, cnt3 = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] == 1) cnt1++;
			if (arr[i] == 2) cnt2++;
			if (arr[i] == 3) cnt3++;			
		}
		
		int cnt12 = 0, cnt13 = 0, cnt21 = 0, cnt23 = 0, cnt31 = 0, cnt32 = 0;
		for (int i = 0; i < N; i++) {
			if (i < cnt1) {
				// 1 자리에 위치한 2와 3
				if (arr[i] == 2) cnt12++;
				if (arr[i] == 3) cnt13++;
			} else if (i < cnt1+cnt2) {
				// 2 자리에 위치한 1과 3
				if (arr[i] == 1) cnt21++;
				if (arr[i] == 3) cnt23++;
			} else {
				// 3 자리에 위치한 1과 2
				if (arr[i] == 1) cnt31++;
				if (arr[i] == 2) cnt32++;
			}
		}
		
		// 두 수가 서로의 자리에 위치해서, 한 번만 교환해도 되는 경우
		int temp;
		// 1이랑 2
		temp = Math.min(cnt12, cnt21);
		answer += temp;
		cnt12 -= temp;
		cnt21 -= temp;
		// 2랑 3
		temp = Math.min(cnt23, cnt32);
		answer += temp;
		cnt23 -= temp;
		cnt32 -= temp;	
		// 3이랑 1
		temp = Math.min(cnt13, cnt31);
		answer += temp;
		cnt13 -= temp;
		cnt31 -= temp;	
		
		// 세 수가 서로서로의 자리에 위치해서 한 번의 교환만으로는 안 되는 경우 (각 두 번씩 필요)
		// 1, 2, 3 각각의 자리에 남은 수가 동일할 것. 대략 1 자리의 수로 합쳐서 계산
		answer += (cnt12+cnt13)*2;
		
		System.out.println(answer);
	}
}
