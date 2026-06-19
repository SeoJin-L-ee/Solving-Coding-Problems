package org.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_8014 {
    static int N, T;
    static int[][] trees;
    static int[] rows, cols;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sto;

        N = Integer.parseInt(br.readLine().trim());
        T = Integer.parseInt(br.readLine().trim());
        trees = new int[T][2];
        for (int i = 0; i < T; i++) {
            sto = new StringTokenizer(br.readLine());
            trees[i][0] = Integer.parseInt(sto.nextToken());
            trees[i][1] = Integer.parseInt(sto.nextToken());
        }
        rows = new int[T + 1];
        cols = new int[T + 1];
        rows[0] = 1;
        cols[0] = 1;
        for (int i = 0; i < T; i++) {
            rows[i+1] = trees[i][0] + 1;
            cols[i+1] = trees[i][1] + 1;
        }
        int st = 0, ed = N;
        while (st <= ed) {
            int mid = (st + ed)/2;
            if (isPossible(mid)) st = mid+1;
            else ed = mid-1;
        }
        System.out.println(ed);
    }

    static boolean isPossible(int a) {
        for (int r : rows) {
            for (int c : cols) {
                if (r+a-1 > N || c+a-1 > N) continue;
                // 이 정사각형 안에 나무가 있는지 체크
                if (noTree(r, c, a)) return true;
            }
        }
        return false;
    }

    static boolean noTree(int r, int c, int a) {
        for (int[] tree : trees) {
            int tr = tree[0], tc = tree[1];
            if (tr >= r && tr <= r + a - 1 && tc >= c && tc <= c + a - 1) {
                return false;
            }
        }
        return true;
    }
}