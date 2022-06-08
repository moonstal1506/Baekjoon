import java.util.ArrayList;
import java.util.Collections;

class Solution {
	static class Point {
		int x;
		double y;

		public Point(int x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		int[] stage = new int[N + 2];
		int[] total = new int[N + 1];
		ArrayList<Point> p = new ArrayList<>();

		for (int i = 0; i < stages.length; i++) {
			stage[stages[i]]++;
		}
		
		total[N] = stage[N] + stage[N + 1]; 
        for (int i = N-1; i >= 1; i--) {
        	total[i] = stage[i] + total[i + 1];
        }


		for (int i = 1; i <= N; i++) {
			if (total[i] == 0) {
				p.add(new Point(i, 0));
				continue;
			} 
			p.add(new Point(i,(double)stage[i] /  total[i]));
			
		}

		Collections.sort(p, ((a, b) -> Double.compare(b.y, a.y)));
		for (int i = 0; i < answer.length; i++) {
			answer[i] = p.get(i).x;
		}

		return answer;
	}
}