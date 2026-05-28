package org.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1244 {
	static String cardNum;
	static int[] cardNums;
    static int chgCnt;
    static int maxNum;
    static boolean isFinished; // 
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        	
        	st = new StringTokenizer(br.readLine());
        	cardNum = st.nextToken();
        	cardNums = new int[cardNum.length()];
        	chgCnt = Integer.parseInt(st.nextToken());
        	maxNum = 0;
        	isFinished = false;
        	// cardNum을 관리하기 편하게 int[]로 저장
        	for (int i = 0; i < cardNum.length(); i++) {
				cardNums[i] = cardNum.charAt(i)-'0';
			}
        	// 두 수 조합을 바꾸는 경우들에 대해 dfs
        	dfs(cardNums, 0);
        	
        	sb.append("#" + t + " " + maxNum).append("\n");
        }
        System.out.println(sb);
    }
    
    static void dfs(int[] curNums, int curChgCnt) {
    	// 이미 최댓값 결정됐다면 return
    	if (isFinished) return;
    	
    	// 현재 curNums이 내림차순 정렬된 상태이면
    	if (isDescSorted(curNums)) {
    		int extraChg = chgCnt - curChgCnt;
    		
    		if (extraChg%2 == 0 || hasDuplicate(curNums)) {
    			// 남은 교환 횟수가 짝수이면
    			maxNum = chgToInt(curNums);
    		} else if (extraChg%2 == 1) {
    			// 홀수이면
    			swap(curNums, curNums.length-1, curNums.length-2);
    			maxNum = chgToInt(curNums);
    		}
    		isFinished = true;
    		return;
    	}
    	
    	// 교환 횟수만큼 다 교환했으면 max 값 갱신
    	if (curChgCnt == chgCnt) {
    		int curNum = chgToInt(curNums);
    		maxNum = Math.max(maxNum, curNum);
    		return;
    	}
    	
    	// 위 조건들 전부 해당 안 될 경우(계속 교환해 봐야 하는 경우)
    	for (int i = 0; i < cardNums.length; i++) {
			for (int j = i+1; j < cardNums.length; j++) {
				swap(curNums, i, j);
				dfs(curNums, curChgCnt+1);
				swap(curNums, i, j);
			}
		}
    }
    
    // 배열이 내림차순 정렬된 상태인지 체크
    static boolean isDescSorted(int[] arr) {
    	for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] < arr[i + 1]) return false;
        }
        return true;
    }
    
    // int[]의 각 자리 수를 합쳐서 하나의 수로 변환
    static int chgToInt(int[] arr) {
    	int temp = 0;
    	for (int i = 0; i < arr.length; i++) {
			temp = temp*10 + arr[i];
		}
    	return temp;
    }
    
    static void swap(int[] arr, int a, int b) {
    	int temp = arr[a];
    	arr[a] = arr[b];
    	arr[b] = temp;
    }
    
    // 배열에 중복된 숫자가 존재하는지 체크
    static boolean hasDuplicate(int[] arr) {
    	boolean[] exist = new boolean[10];
    	for (int temp : arr) {
    		if (exist[temp]) return true;
    		exist[temp] = true;
    	}
    	return false;
    }
}
