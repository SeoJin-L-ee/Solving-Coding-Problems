import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 1759 {
	static int L, C;
	static char[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		// 미리 정렬된 상태로 시작
		Arrays.sort(arr);

		combi(0, 0, "", 0, 0);
		System.out.println(sb);
	}

	static void combi(int depth, int start, String currPW, int vowelCnt, int consonantCnt) {
		if (depth == L) {
			// 모음이 1개 이상, 자음이 2개 이상인 경우에만 가능성 있는 비번으로서 출력
			if (vowelCnt >= 1 && consonantCnt >= 2) {
				sb.append(currPW);
				sb.append("\n");
			}
			return;
		}
		for (int i = start; i < C; i++) {
			// 추가할 알파벳이 모음인지 자음인지 구분하여 진행
			if (arr[i]=='a' || arr[i]=='e' || arr[i]=='i' || arr[i]=='o' || arr[i]=='u') {
				combi(depth+1, i+1, currPW + arr[i], vowelCnt+1, consonantCnt);
			} else {
				combi(depth+1, i+1, currPW + arr[i], vowelCnt, consonantCnt+1);
			}
		}
	}
}
