/*
 * 
 * 2019 īī�� ������ �ܿ� ���Ͻ� ũ���� �����̱� ���� 
 * https://programmers.co.kr/learn/courses/30/lessons/64061
 * 
 */

package kakao;

import java.util.Stack;

public class ClawCraneGame {

	public static int solution(int[][] board, int[] moves) {

		int answer = 0;
		int pick = 0; // ���� ���� ��ȣ
		int col = 0;

		Stack<Integer> basket = new Stack<Integer>();

		for (int i = 0; i < moves.length; i++) {
			col = moves[i] - 1;

			for (int row = 0; row < board.length; row++) {
				if (board[row][col] != 0) {
					pick = board[row][col];
					
					
					if(basket.isEmpty()) basket.push(pick);
					else {
						if(basket.peek()==pick) {
							basket.pop();
							answer += 2;
						}
						else basket.push(pick);
					}
					board[row][col] = 0;
					break;
				}
				
			}

		}

		return answer;
	}

	public static void main(String[] args) {

		// ����� ����
		int[][] board = { 
				{ 0, 0, 0, 0, 0 }, 
				{ 0, 0, 1, 0, 3 }, 
				{ 0, 2, 5, 0, 1 }, 
				{ 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };

		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		
		System.out.println(ClawCraneGame.solution(board, moves));

	}

}