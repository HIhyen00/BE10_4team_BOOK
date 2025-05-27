package ebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import ebook.controller.MenuController;
import ebook.model.UserDTO; // �α��� ����� User ��ü�� �޴´ٰ� ����

public class EbookSystem {
	public static void main(String[] args) throws IOException {
		MenuController ui = new MenuController();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("******Ebook-Store********");
			System.out.println("1. �α���");
			System.out.println("2. ȸ������");
			System.out.println("3. FAQ ����");
			System.out.println("0. ����");
			System.out.print("���ϴ� �۾��� �����ϼ���: ");
			int choice = Integer.parseInt(br.readLine());
			switch (choice) {
			case 1:
				UserDTO loginUser = ui.loginMenu(); // �α��� ���� �� User ��ü ��ȯ
				if (loginUser != null) {
					if (loginUser.isAdmin()) {
						startAdminMenu(loginUser);
					} else {
						startUserMenu(loginUser);
					}
				} else {
					System.out.println("�α��� ����! ���̵�/��й�ȣ�� Ȯ���ϼ���.");
				}
				break;
			case 2:
				boolean regSuccess = ui.insertMenu();
				if (regSuccess) {
					System.out.println("ȸ������ ����! ���� �α����� �����ϼ���.");
				} else {
					System.out.println("ȸ������ ����! �ٽ� �õ��ϼ���.");
				}
				break;
			case 3:
				ui.faqMenu();
				break;
			case 0:
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			default:
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �����ϼ���.");
			}
		}
	}

	// �Ϲ� ȸ�� �޴�
	public static void startUserMenu(UserDTO user) throws IOException {
		MenuController ui = new MenuController();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("======Ebook-Store(�Ϲ�ȸ��)======");
			System.out.println(user.getName() + "�� ȯ���մϴ�!");
			System.out.println("1. ���� ��� ����");
			System.out.println("2. ���� �� ����");
			System.out.println("3. ���� ����");
			System.out.println("4. ���� ���� Ȯ�� ");
			System.out.println("5. ���� �ۼ�");
			System.out.println("6. FAQ");
			System.out.println("7. �α׾ƿ�");
			System.out.println("0. ���α׷� ����");
			System.out.print("�޴� ����: ");
			/*
			 * 1. ���� ��� ���� 2. ���� �� ���� 3. ���� ���� 4. ���� ���� Ȯ�� 5. ���� �ۼ� 6. FAQ ���� 7. �α׾ƿ� 0.
			 * ���α׷� ����
			 * 
			 */
			int choice = Integer.parseInt(br.readLine());
			switch (choice) {
			    case 1: // ���� ��� ����
			        ui.bookListMenu();
			        break;
			    case 2: // ���� �� ����
			        ui.bookDetailMenu();
			        break;
			    case 3: // ���� ����
			        ui.purchaseBookMenu(user);
			        break;
			    case 4: // ���� ���� Ȯ��
			        ui.orderHistoryMenu(user);
			        break;
			    case 5: // ���� �ۼ�
			        ui.writeReviewMenu(user);
			        break;
			    case 6: // FAQ ����
			        ui.faqMenu();
			        break;
			    case 7: // �α׾ƿ�
			        System.out.println("�α׾ƿ��մϴ�.");
			        return;
			    case 0: // ���α׷� ����
			        System.out.println("���α׷��� �����մϴ�.");
			        System.exit(0);
			    default:
			        System.out.println("�߸��� �Է��Դϴ�.");
			}

		}
	}

	// ������ �޴�
	public static void startAdminMenu(UserDTO user) throws IOException {
	    MenuController ui = new MenuController();
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    while (true) {
	        System.out.println("======Ebook-Store(������)======");
	        System.out.println("������ " + user.getName() + "�� ȯ���մϴ�!");
	        System.out.println("1. ���� ���");
	        System.out.println("2. ���� ����");
	        System.out.println("3. ���� ��� ����");
	        System.out.println("4. ȸ�� ��� ��ȸ");
	        System.out.println("5. FAQ ���");
	        System.out.println("6. FAQ ����/����");
	        System.out.println("7. �α׾ƿ�");
	        System.out.println("0. ���α׷� ����");
	        System.out.print("�޴� ����: ");

	        int choice = Integer.parseInt(br.readLine());
	        switch (choice) {
	            case 1: // ���� ���
	                ui.registerBookMenu();
	                break;
	            case 2: // ���� ����
	                ui.deleteBookMenu();
	                break;
	            case 3: // ���� ��� ����
	                ui.bookListMenu();
	                break;
	            case 4: // ȸ�� ��� ��ȸ
	                ui.userListMenu();
	                break;
	            case 5: // FAQ ���
	                ui.registerFaqMenu();
	                break;
	            case 6: // FAQ ����/����
	                ui.updateFaqMenu();
	                break;
	            case 7: // �α׾ƿ�
	                System.out.println("�α׾ƿ��մϴ�.\n");
	                return;
	            case 0: // ���α׷� ����
	                System.out.println("���α׷��� �����մϴ�.");
	                System.exit(0);
	            default:
	                System.out.println("�߸��� �Է��Դϴ�.\n");
	        }
	    }
	}

}
