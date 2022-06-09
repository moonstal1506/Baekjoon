class Solution {
	
    public String solution(int[] numbers, String hand) {
        
        // 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락
        //오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락
        //가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락
        //거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손
    	
    	StringBuilder sb = new StringBuilder();
        int right= 12;
        int left= 10;
    	
        
        for(int number:numbers) {
        	if(number==1||number==4||number==7) {
        		sb.append('L');
        		left=number;
        	}else if(number==3||number==6||number==9) {
        		sb.append('R');
        		right=number;
        	}else {
        		if(number==0) {
        			number=11;
        		}
        		int LD= Math.abs((left - number) / 3 - (number - left) % 3);
        		int RD= Math.abs((right - number) / 3 - (number - right) % 3);
        		if(LD<RD) {
        			sb.append('L');
            		left= number;
        		}else if(LD>RD) {
        			sb.append('R');
            		right=number;
        		}else {
        			if(hand.equals("left")){
        				sb.append('L');
                		left= number;
                    }else{
                    	sb.append('R');
                		right=number;
                    }
        		}
        	}
        }
        return sb.toString();
    }
}