import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 1247 {

	// 좌표 저장 객체
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, minDist;
	static Point[] customers;
	static Point company, home;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			customers = new Point[11];
			minDist = Integer.MAX_VALUE;

			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			for (int j = 0; j < N; j++) {
				customers[j] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			permutation(0, 0, company);
			sb.append("#" + (i+1) + " " + minDist);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void permutation(int depth, int currDist, Point prev) {
		// 현재까지의 최단경로보다 오래 걸리면, 끝까지 안 구했더라도 return
		if (currDist >= minDist ) return;
		// 끝까지 탐색했으면, 해당 경로에서 걸린 시간과 현재까지의 최단경로에서 걸린 시간을 비교 후 minDist값 변경
		if (depth == N) {
			int totalDist = currDist + getDist(prev, home);
			minDist = Math.min(totalDist, minDist);
			return;
		}
		for (int i = depth; i < N; i++) {
			swap(i, depth);
			permutation(depth + 1, currDist + getDist(prev, customers[depth]), customers[depth]);
			swap(i, depth);
		}
	}

	static void swap(int a, int b) {
		Point temp = customers[a];
		customers[a] = customers[b];
		customers[b] = temp;
	}

	static int getDist(Point a, Point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
}
