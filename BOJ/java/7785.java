import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 7785 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String name, status;
		// treeSet 생성 시 사전 순의 역순으로 정렬되게끔 조건 추가
		TreeSet<String> ts = new TreeSet<>(Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			name = st.nextToken();
			status = st.nextToken();

			if (status.equals("enter")) {
				// status가 enter면 treeset에 이름 추가
				ts.add(name);
			} else {
				// status가 leave면 treeSet에서 이름 제거
				ts.remove(name);
			}
		}
		StringBuilder sb = new StringBuilder(n * 6);
		for (String currName : ts) {
			sb.append(currName).append("\n");
		}
		System.out.println(sb);
	}
}
