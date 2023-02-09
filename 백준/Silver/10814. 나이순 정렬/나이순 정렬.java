import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] members = new String[N];
		for (int i = 0; i < N; i++) {
			members[i] = br.readLine();
		}
		StringBuilder sb = new StringBuilder();
		Arrays.stream(members).sorted((o1, o2) -> {
			return Integer.parseInt(o1.split(" ")[0]) - Integer.parseInt(o2.split(" ")[0]);
		}).forEach(s -> {
			sb.append(s);
			sb.append("\n");
		});
		System.out.println(sb.toString());
	}
}

/**
  * 10814. 나이순 정렬
**/