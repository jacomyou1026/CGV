package cgv;

import javax.swing.JOptionPane;

public class New_CGV {
	//전역변수 
	//전역변수는 자동초기화 가능
	String ageMsg = "[청소년 구매 불가 상품]\n나이를 입력하세요\n";
	int age;
	boolean t_check; //매번 
	int money = 1000000;
	int side_price=0;
	boolean p_check;
	
	

	boolean bookTicket(){
		boolean cCheck = false;
		String films = "①라이온킹(08:00)\n ②스파이더맨(12:00)\n③알라딘(23:00)[청소년 관람 불가]\n④뒤로가기";
		int choice = Integer.parseInt(JOptionPane.showInputDialog(films));
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
			cCheck=true;
		}
		return cCheck;
	}
	
	boolean payment(){
		boolean p_check =false;
		int choice = 0;	
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
				JOptionPane.showMessageDialog(null, "메인 메뉴로 돌아갑니다.");
				p_check =true;
		
		}
		return p_check;
		

	}
	
	
public static void main(String[] args) {
		// TODO Auto-generated method stub
		String helloMsg = "★어서오세요 CGV입니다.★\n";
		String menu = "① 예매하기\n" + "②구매하기\n" + "③포인트 조회\n" + "④나가기\n";
		int choice = 0;
		int point = 0;
		int t_price = 10000;
		int s_size=0;
		//
		
		//main메서드는 static이기에 전역변수로 올려도 모름
		//New_CGV 이 더 늦게 올라가기때문에
		New_CGV c = new New_CGV();
			
		while (true) {
			c.t_check = true;

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
				if (c.money - t_price < 0) {
					JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
					break;
				}
				if(c.bookTicket()) {
					continue;
				}
				if (c.t_check) {
					// point로 계산했을 시
					if (point > 0) {
						if (point - t_price >= 0) {
							point -= t_price;
						} else { // 자신의 돈-=티켓가격 - 잔여 포인트
							c.money -= (t_price - point);
							point = 0;
						}
					} else { // 돈으로만 결제했을시
						c.money -= t_price;
						point += (int) t_price * 0.5;
					}
					JOptionPane.showConfirmDialog(null, "현재 잔액: " + c.money + "원");
				}
				break;
				
				
			case 2:
				String pay = "①팝콘\n②콜라\n③맥주\n④뒤로가기\n";
				String size = "① 대 ② 중 ③ 소";
				choice = Integer.parseInt(JOptionPane.showInputDialog(pay));
				choice = Integer.parseInt(JOptionPane.showInputDialog(size));
				switch (choice) {
				case 1:
					if(choice ==1) {
						 c.side_price=12000;
					}else if(choice ==2) {
						c.side_price=10000;
						
					}else {
						c.side_price=3000;
						
					}
					break;
				case 2:
					if(choice ==1) {
						c.side_price=3000;
					}else if(choice ==2) {
						c.side_price=2000;
					}else {
						c.side_price=1000;
						
					}

					break;
				case 3:
					if(choice ==1) {
						c.side_price=3000;
					}else if(choice ==2) {
						c.side_price=2400;
					}else if(choice==3){
						c.side_price=1200;
					}
					
					break;
				case 4:
					JOptionPane.showMessageDialog(null, "메인화면으로 돌아갑니다.");
					continue;
				}
				
				if (c.payment()) continue;
				if(c.money - c.side_price<0) {
					JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
					break;
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
