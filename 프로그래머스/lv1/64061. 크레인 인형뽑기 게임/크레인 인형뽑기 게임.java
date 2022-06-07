import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack=new Stack<>();

        //배열위치 돌면서 인형꺼내고 0바꿔 , 스택 비어있지x-위에꺼 같으면 +2,터뜨리기, 아니면 스택에 넣기,멈춰
        for(int move: moves) {
        	for(int i=0;i<board.length;i++) {
        		if(board[i][move-1]!=0) {
        			int tmp=board[i][move-1];
        			board[i][move-1]=0;
        			if(!stack.isEmpty()&&stack.peek()==tmp) {
            			answer+=2;
            			stack.pop();
            		}else {
            			stack.push(tmp);
            		}
        			break;	
        		}
        	}
        }
        return answer;
    }
}