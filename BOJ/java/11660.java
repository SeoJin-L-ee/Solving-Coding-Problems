import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간초과 나서 실패함. 더 효율적으로 다시 풀어볼 것
public class 11660 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[][] arr = new long[N+1][N+1];
        
        // N*N 표 값 채우기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }
        
        // M줄에 걸쳐 (x1, y1), (x2, y2) 값 받아오면서, 각 좌표들에 대해 합 구하기 
        // -> 시간초과 발생 가능성 높음! 구간합 적용해서 개선할 것
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            long sum = 0;
            for (int r = x1; r <= x2; r++) {
                for (int c = y1; c <= y2; c++) {
                    sum += arr[r][c];
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
