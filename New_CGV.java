package cgv;

import javax.swing.JOptionPane;

public class New_CGV {
	//�������� 
	//���������� �ڵ��ʱ�ȭ ����
	String ageMsg = "[û�ҳ� ���� �Ұ� ��ǰ]\n���̸� �Է��ϼ���\n";
	int age;
	boolean t_check; //�Ź� 
	int money = 1000000;
	int side_price=0;
	boolean p_check;
	
	

	boolean bookTicket(){
		boolean cCheck = false;
		String films = "����̿�ŷ(08:00)\n �轺���̴���(12:00)\n��˶��(23:00)[û�ҳ� ���� �Ұ�]\n��ڷΰ���";
		int choice = Integer.parseInt(JOptionPane.showInputDialog(films));
		if (choice == 1) {
			JOptionPane.showMessageDialog(null, "���̿�ŷ ���ſϷ�(8:00)");
		} else if (choice == 2) {
			JOptionPane.showMessageDialog(null, "�����̴��� ���ſϷ�(12:00)");

		}
		// û�� ��ȭ
		else if (choice == 3) {
			age = Integer.parseInt(JOptionPane.showInputDialog(ageMsg));
			if (age > 19) {
				JOptionPane.showMessageDialog(null, "�˶�� ���ſϷ�(23:00)");
			} else {
				t_check = false;
				JOptionPane.showMessageDialog(null, "�ٽ� �õ��� �ּ���");
			}

		} else {
			JOptionPane.showMessageDialog(null, "���� �޴��� �̵��մϴ�.");
			cCheck=true;
		}
		return cCheck;
	}
	
	boolean payment(){
		boolean p_check =false;
		int choice = 0;	
		int result = JOptionPane.showConfirmDialog(null, side_price + "���Դϴ�. ���� �Ͻðڽ��ϱ�?","Yes_no_title", JOptionPane.YES_NO_OPTION);
		if( result== JOptionPane.YES_NO_OPTION) {
			if (choice == 1) {
				JOptionPane.showMessageDialog(null, "���ڰ� �ֹ��Ͽ����ϴ�.");
			} else if (choice == 2) {
				JOptionPane.showMessageDialog(null, "���ڰ� �ֹ��Ͽ����ϴ�.");

			} else if (choice == 3) {
				JOptionPane.showMessageDialog(null, "��ڰ� �ֹ��Ͽ����ϴ�.");

			} 
			money -= side_price;
			JOptionPane.showMessageDialog(null, "�ܾ� : " + money + "�� �ֽ��ϴ�.");
		}
		else {
				JOptionPane.showMessageDialog(null, "���� �޴��� ���ư��ϴ�.");
				p_check =true;
		
		}
		return p_check;
		

	}
	
	
public static void main(String[] args) {
		// TODO Auto-generated method stub
		String helloMsg = "�ھ������ CGV�Դϴ�.��\n";
		String menu = "�� �����ϱ�\n" + "�豸���ϱ�\n" + "������Ʈ ��ȸ\n" + "�곪����\n";
		int choice = 0;
		int point = 0;
		int t_price = 10000;
		int s_size=0;
		//
		
		//main�޼���� static�̱⿡ ���������� �÷��� ��
		//New_CGV �� �� �ʰ� �ö󰡱⶧����
		New_CGV c = new New_CGV();
			
		while (true) {
			c.t_check = true;

			choice = Integer.parseInt(JOptionPane.showInputDialog(helloMsg + menu));
			if (choice == 4) {
				break;
			}
			// �߸� �Է½� continue
			if (!(choice >= 1 && choice <= 3)) {
				continue;
			}
			switch (choice) {

			// �����ϱ� ����
			case 1:
				// ������ ���� - choice�� ������ �� ������ ����ص� ���x

				// ���߿� ������� ������ ����� �� �𸣱⿡
				// ���� ���� ������ �Ǿ�� �ܾ� ���� ó��
				if (c.money - t_price < 0) {
					JOptionPane.showMessageDialog(null, "�ܾ��� �����մϴ�.");
					break;
				}
				if(c.bookTicket()) {
					continue;
				}
				if (c.t_check) {
					// point�� ������� ��
					if (point > 0) {
						if (point - t_price >= 0) {
							point -= t_price;
						} else { // �ڽ��� ��-=Ƽ�ϰ��� - �ܿ� ����Ʈ
							c.money -= (t_price - point);
							point = 0;
						}
					} else { // �����θ� ����������
						c.money -= t_price;
						point += (int) t_price * 0.5;
					}
					JOptionPane.showConfirmDialog(null, "���� �ܾ�: " + c.money + "��");
				}
				break;
				
				
			case 2:
				String pay = "������\n���ݶ�\n�����\n��ڷΰ���\n";
				String size = "�� �� �� �� �� ��";
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
					JOptionPane.showMessageDialog(null, "����ȭ������ ���ư��ϴ�.");
					continue;
				}
				
				if (c.payment()) continue;
				if(c.money - c.side_price<0) {
					JOptionPane.showMessageDialog(null, "�ܾ��� �����մϴ�.");
					break;
				}
				
		
		
				
			break;
			// ����Ʈ ��ȸ ����
			case 3:
				JOptionPane.showConfirmDialog(null, "�ܿ� ����Ʈ: " + point + "��");
				break;
			}
		}

	}



}
