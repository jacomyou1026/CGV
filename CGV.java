package cgv;

import javax.print.attribute.standard.JobPriority;
import javax.swing.JOptionPane;

public class CGV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String helloMsg = "�ھ������ CGV�Դϴ�.��\n";
		String menu = "�� �����ϱ�\n" + "�豸���ϱ�\n" + "������Ʈ ��ȸ\n" + "�곪����\n";
		String ageMsg = "[û�ҳ� ���� �Ұ� ��ǰ]\n���̸� �Է��ϼ���\n";
		String pay = "������\n���ݶ�\n�����\n��ڷΰ���\n";
		String size = "�� �� �� �� �� ��";
		int age = 0;
		int choice = 0;
		String films = "����̿�ŷ(08:00)\n �轺���̴���(12:00)\n��˶��(23:00)[û�ҳ� ���� �Ұ�]\n��ڷΰ���";
		int money = 1000000;
		int point = 0;
		int t_price = 10000;
		int side_price = 0;
		int s_size = 0;
		boolean t_check;
		boolean p_check;
		

		/*
		 * �����ϱ� 1.���� 2.�ݶ� 3.���� 4.�ڷΰ���
		 */
		while (true) {
			t_check = true;

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
				if (money - t_price < 0) {
					JOptionPane.showMessageDialog(null, "�ܾ��� �����մϴ�.");
					break;
				}
				choice = Integer.parseInt(JOptionPane.showInputDialog(films));
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
					continue;
				}
				if (t_check) {
					// point�� ������� ��
					if (point > 0) {
						if (point - t_price >= 0) {
							point -= t_price;
						} else { // �ڽ��� ��-=Ƽ�ϰ��� - �ܿ� ����Ʈ
							money -= (t_price - point);
							point = 0;
						}
					} else { // �����θ� ����������
						money -= t_price;
						point += (int) t_price * 0.5;
					}
					JOptionPane.showMessageDialog(null, "���� �ܾ�: " + money + "��");
				}
				break;

			// �����ϱ� ����
			/*
			 * �����ϱ� 1.���� - ���� �� �� �� - 2.�ݶ� 3.���� 4.������
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
					JOptionPane.showMessageDialog(null, "����ȭ������ ���ư��ϴ�.");
					continue;
				}

				if (money - side_price < 0) {
					JOptionPane.showMessageDialog(null, "�ܾ��� �����մϴ�.");
					break;
				}				
				
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
						JOptionPane.showMessageDialog(null, "�޴��� ���ư��ϴ�.");
						continue;
					
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
