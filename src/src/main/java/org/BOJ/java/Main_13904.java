package org.BOJ.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13904 {

    static class Task {
        int due, score;
        Task(int due, int score) {
            this.due = due;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int day = 0; // 현재까지 선택한 과제들을 수행하는데 드는 날
        int maxScore = 0;
        int N = Integer.parseInt(br.readLine());

        // 마감기한(due) 기준 오름차순으로 정렬 유지
        PriorityQueue<Task> taskPQ = new PriorityQueue<>((o1, o2) -> o1.due - o2.due);
        // 하기로 선택한 과제의 점수를 저장
        PriorityQueue<Integer> scorePQ = new PriorityQueue<>();

        // 과제 정보(마감기한, 점수)를 Task 객체로 만들어서 PriorityQueue에 추가
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            taskPQ.add(new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        while (!taskPQ.isEmpty()) {
            Task task = taskPQ.poll();
            if (task.due > day) {
                // 현재까지 선택한 과제들을 수행하고도 수행할 수 있는 과제면, 선택
                maxScore += task.score;
                scorePQ.add(task.score);
                day++;
            } else if (task.due == day) {
                // 선택한 과제들을 수행한 후에는 마감기한이 끝났을 과제이지만, 점수가 더 낮은 과제를 포기하면 수행할 수 있을 때
                if (scorePQ.peek() < task.score) {
                    // 현재 과제가, 선택된 과제 중에서 가장 점수가 작은 과제보다 큰 점수를 준다면
                    // 선택됐던 작은점수의 과제는 포기(점수 차감)
                    maxScore -= scorePQ.poll();

                    // 현재 과제를 하기로 선택
                    maxScore += task.score;
                    scorePQ.add(task.score);
                }
            }
        }
        System.out.println(maxScore);
    }
}