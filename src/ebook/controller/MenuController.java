package ebook.controller;

import ebook.model.UserDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuController {
    private static final Scanner sc = new Scanner(System.in);
    public static UserDTO currentUser; // ���� �α��ε� �����
    // ȸ������
    public boolean insertMenu() {
        System.out.print("���̵� �Է�: ");
        String id = sc.nextLine();
        System.out.print("��й�ȣ �Է�: ");
        String pw = sc.nextLine();
        System.out.print("�̸� �Է�: ");
        String name = sc.nextLine();
        System.out.print("�̸��� �Է�: ");
        String email = sc.nextLine();
        System.out.print("�������Դϱ�? (y/n): ");
        String adminCheck = sc.nextLine();
        boolean isAdmin = adminCheck.equalsIgnoreCase("y");
        //String id, String password, String name, String email, boolean isAdmin
        UserDTO newUser = new UserDTO(id, pw, name, email, isAdmin);
        System.out.println(" ȸ������ �Ϸ�!");
        return isAdmin;
    }

    // �α���
    public boolean loginMenu() {
        System.out.print("���̵� �Է�: ");
        String id = sc.nextLine();

        System.out.print("��й�ȣ �Է�: ");
        String pw = sc.nextLine();

 

        System.out.println(" �α��� ����. �ٽ� �õ��ϼ���.");
        return false; // ���� �� �⺻ �Ϲ� ���� ó��
    }
    public boolean deleteMenu() {
        System.out.print("���̵� �Է�: ");
        String id = sc.nextLine();

        System.out.print("��й�ȣ �Է�: ");
        String pw = sc.nextLine();



        System.out.println(" �α��� ����. �ٽ� �õ��ϼ���.");
        return false; // ���� �� �⺻ �Ϲ� ���� ó��
    }
}
