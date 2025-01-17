package APC_Extra_Open_Contest;

import java.util.*;

/**
 * 분리배출
 * 문제 링크
 * https://www.acmicpc.net/problem/32980
 */
public class Number32980 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//쓰레기의 수 입력
		int n = input.nextInt();
		input.nextLine();
		
		String[] trash = new String[n];
		// 여기서 요금(charge) 배열의 순서는 플라스틱(0), 캔(1), 비닐(2), 종이(3), 유리(4), 스티로품(5), 일반 쓰레기(6)이다.
		int[] charge = new int[7]; 
		long result = 0;
		
		// 쓰레기(trash) 배열 입력
		for(int i = 0; i < n; i++)
			trash[i] = input.nextLine();
		
		// 요금(charge) 배열 입력
		String[] chargeInput = input.nextLine().split(" ");
		for(int i = 0; i < 6; i++)
			charge[i] = Integer.parseInt(chargeInput[i]);
		
		charge[6] = input.nextInt();
		
		// 쓰레기 비용이 최소가 되기 위해 일반 쓰레기 비용보다 높은 쓰레기 비용 재설정
		for(int i = 0; i < charge.length - 1; i++) {
			if(charge[i] > charge[6])
				charge[i] = charge[6];
		}
		
		// 쓰레기의 요금 계산
		for(int i = 0; i < n; i++) {
			int result2 = 0;
			boolean isDifferent = false;
			
			// 동일한 문자가 있는지 확인
			char firstChar = trash[i].charAt(0);
			for(int j = 1; j < trash[i].length(); j++) {
				if(trash[i].charAt(j) != firstChar) {
					isDifferent = true;
                	break;
                }
			}
			
			if(isDifferent) {
				// 다른 문자가 존재하면 일반 쓰레기 요금으로 계산
				result2 = charge[6]*trash[i].length(); 
			}
			else { // 모든 문자가 동일하면 각 쓰레기의 요금으로 계산
				int singleCharge = 0;
				switch(trash[i].charAt(0)) {
				case 'P':
					singleCharge = charge[0];
					break;
				case 'C':
					singleCharge = charge[1];
					break;
				case 'V':
					singleCharge = charge[2];
					break;
				case 'S':
					singleCharge = charge[3];
					break;
				case 'G':
					singleCharge = charge[4];
					break;
				case 'F':
					singleCharge = charge[5];
					break;
				case 'O':
					singleCharge = charge[6];
					break;
				}
				result2 = singleCharge * trash[i].length();
			}
			result += result2; // 최종 결과
		}
		
		System.out.println(result); // 결과 출력
		input.close();
	}

}
