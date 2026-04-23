package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1253 {

	public static void main(String[] args) throws IOException {
		int start, end;
		int goodCnt = 0;
		int[] arr;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		// 수들 입력받은 후 정렬 (정렬을 전제로 구현됨)
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] =Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		// 각 수에 대해, 다른 두 수의 합으로 나타내어질 수 있는 수인지 판단
		for (int i = 0; i < N; i++) {
			start = 0;
			end = N-1;
			while (start < end) {
				int sum = arr[start] + arr[end];
				// 현재 start나 end가 비교대상숫자 위치와 동일하면 비교하지 않고 ++ 또는 --
				// (자기 자신을 제외한 다른 두 수의 합으로 나타내어져야 함.)
				if (start == i) {
					start++;
					continue;
				}
				if (end == i) {
					end--;
					continue;
				}
				// start위치와 end위치 값의 sum과, 비교대상숫자를 비교하여 start 또는 end 인덱스를 조정
				// sum값이 비교대상숫자와 일치할 시 goodCnt 증가시키고 다음 비교대상숫자로 넘어감
				if (sum < arr[i]) start++;
				else if (sum > arr[i]) end--;
				else {
					goodCnt++;
					break;
				}
			}
		}
		System.out.println(goodCnt);
	}
}
