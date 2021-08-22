package cgv;

import javax.print.attribute.standard.JobPriority;
import javax.swing.JOptionPane;

public class CGV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String helloMsg = "★어서오세요 CGV입니다.★\n";
		String menu = "① 예매하기\n" + "②구매하기\n" + "③포인트 조회\n" + "④나가기\n";
		String ageMsg = "[청소년 구매 불가 상품]\n나이를 입력하세요\n";
		String pay = "①팝콘\n②콜라\n③맥주\n④뒤로가기\n";
		String size = "① 대 ② 중 ③ 소";
		int age = 0;
		int choice = 0;
		String films = "①라이온킹(08:00)\n ②스파이더맨(12:00)\n③알라딘(23:00)[청소년 관람 불가]\n④뒤로가기";
		int money = 1000000;
		int point = 0;
		int t_price = 10000;
		int side_price = 0;
		int s_size = 0;
		boolean t_check;
		boolean p_check;
		

		/*
		 * 구매하기 1.팝콘 2.콜라 3.맥주 4.뒤로가기
		 */
		while (true) {
			t_check = true;

			choice = Integer.parseInt(JOptionPane.showInputDialog(helloMsg + menu));
			if (choice == 4) {
				break;
			}
			// 잘못 입력시 continue
			if (!(choice >= 1 && choice <= 3)) {
				continue;
			}
			switch (choice) {

			// 예매하기 영역
			case 1:
				// 변수의 재사용 - choice가 위에꺼 다 끝나서 사용해도 상관x

				// 나중에 언제어디서 오류가 생기는 줄 모르기에
				// 먼저 빼서 음수가 되어야 잔액 부족 처리
				if (money - t_price < 0) {
					JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
					break;
				}
				choice = Integer.parseInt(JOptionPane.showInputDialog(films));
				if (choice == 1) {
					JOptionPane.showMessageDialog(null, "라이온킹 예매완료(8:00)");
				} else if (choice == 2) {
					JOptionPane.showMessageDialog(null, "스파이더맨 예매완료(12:00)");

				}
				// 청불 영화
				else if (choice == 3) {
					age = Integer.parseInt(JOptionPane.showInputDialog(ageMsg));
					if (age > 19) {
						JOptionPane.showMessageDialog(null, "알라딘 예매완료(23:00)");
					} else {
						t_check = false;
						JOptionPane.showMessageDialog(null, "다시 시도해 주세요");
					}

				} else {
					JOptionPane.showMessageDialog(null, "메인 메뉴로 이동합니다.");
					continue;
				}
				if (t_check) {
					// point로 계산했을 시
					if (point > 0) {
						if (point - t_price >= 0) {
							point -= t_price;
						} else { // 자신의 돈-=티켓가격 - 잔여 포인트
							money -= (t_price - point);
							point = 0;
						}
					} else { // 돈으로만 결제했을시
						money -= t_price;
						point += (int) t_price * 0.5;
					}
					JOptionPane.showMessageDialog(null, "현재 잔액: " + money + "원");
				}
				break;

			// 구매하기 영역
			/*
			 * 구매하기 1.팝콘 - 팝콘 대 중 소 - 2.콜라 3.맥주 4.나가기
			 */
			case 2:
				choice = Integer.parseInt(JOptionPane.showInputDialog(pay));

				choice = Integer.parseInt(JOptionPane.showInputDialog(size));
				switch (choice) {

				case 1:
					if (choice == 1) {
						side_price = 12000;
					} else if (choice == 2) {
						side_price = 10000;

					} else {
						side_price = 3000;

					}
					break;
				case 2:
					if (choice == 1) {
						side_price = 3000;
					} else if (choice == 2) {
						side_price = 2000;
					} else {
						side_price = 1000;

					}

					break;
				case 3:
					if (choice == 1) {
						side_price = 3000;
					} else if (choice == 2) {
						side_price = 2400;
					} else if (choice == 3) {
						side_price = 1200;
					}

					break;
				case 4:
					JOptionPane.showMessageDialog(null, "메인화면으로 돌아갑니다.");
					continue;
				}

				if (money - side_price < 0) {
					JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
					break;
				}				
				
					int result = JOptionPane.showConfirmDialog(null, side_price + "원입니다. 결제 하시겠습니까?","Yes_no_title", JOptionPane.YES_NO_OPTION);
					
				
				if( result== JOptionPane.YES_NO_OPTION) {
					if (choice == 1) {
						JOptionPane.showMessageDialog(null, "大자가 주문하였습니다.");
					} else if (choice == 2) {
						JOptionPane.showMessageDialog(null, "中자가 주문하였습니다.");

					} else if (choice == 3) {
						JOptionPane.showMessageDialog(null, "小자가 주문하였습니다.");

					} 
					money -= side_price;
					JOptionPane.showMessageDialog(null, "잔액 : " + money + "원 있습니다.");
				}
				else {
						JOptionPane.showMessageDialog(null, "메뉴로 돌아갑니다.");
						continue;
					
				}
				

				break;
			// 포인트 조회 영역
			case 3:
				JOptionPane.showConfirmDialog(null, "잔여 포인트: " + point + "점");
				break;
			}
		}

	}
}
