class Solution {
    public int solution(String dartResult) {
        //정수저장, 점수저장배열, 인덱스
        String num="";
        int[] score=new int[3];
        int idx=0;
        int answer = 0;

        //다트길이만큼 돌려 문자경우나누기
        for(int i=0;i<dartResult.length();i++) {
        	//* 해당 점수와 바로 전에 얻은 점수를 각 2배
            //#  해당 점수는 마이너스
            //S,D,T, 정수
        	switch (dartResult.charAt(i)) {
        	
			case '*':
				score[idx-1]*=2;
				if(idx>1) score[idx-2]*=2;
				break;
				
			case '#':
				score[idx-1]*=-1;
				break;
				
			case 'S':
				score[idx]=Integer.parseInt(num);
				idx++;
				num="";
				break;
				
			case 'D':
				score[idx]=(int) Math.pow(Integer.parseInt(num), 2);
				idx++;
				num="";
				break;
				
			case 'T':
				score[idx]=(int) Math.pow(Integer.parseInt(num), 3);
				idx++;
				num="";
				break;
				
			default:
				num+=dartResult.charAt(i);
				break;
			}
        }
        
        for(int i=0;i<score.length;i++) {
        	answer+=score[i];
        }
        return answer;
    }
}