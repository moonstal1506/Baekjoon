import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine()); // X번째 입력 ex) X가 5일 떄 2/2
		int line = 0; // line 변수 line = 3번째 라인의
		int line_seq = 0; // 해당 line의 몇번째 순번인지의 대한 변수 line_seq = 2번째 위치
		int cnt = 0; // cnt 변수
		while (cnt < X) { // cnt가 X보다 작을때까지만 반복
			line++; // line + 1 (1, 2, 3, 4, 5 ...)
			line_seq = 0; // line이 바뀌면(+1되면) 해당 라인의 순번은 초기화
			for (int i = 0; i < line; i++) { // line번 반복
				cnt++; // cnt가 X가 될 때까지 증가
				line_seq++; // cnt가 늘수록 순번도 증가
				if (cnt == X) { // cnt==X일 때,
					break; // break;
				}
			}
		}
		// 출력은 분수 형태이므로 first/last식으로 출력할 예정
		int first = 0;
		int last = 0;
		for (int i = 0; i < line_seq; i++) { //
			if (line % 2 == 0) { // 짝수 line일 때
				first = i + 1; // frist가 1부터 오름차순
				last = line - i; // last는 line부터 내림차순
			} else { // 홀수 line일 때
				first = line - i; // first가 line부터 내림차수
				last = i + 1; // last는 1부터 오름차순
			}
		}
		System.out.println(first + "/" + last); // 출력

	}
}