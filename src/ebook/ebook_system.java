package ebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import ebook.controller.MenuController;

public class ebook_system {
	public static void main(String[] args) throws IOException {
		// ùȭ�� - �α��ν� �Ϲ�ȸ�� �ܼ�,������ȸ�� �ܼ��� ����� ����ϵ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("******Ebook-Store********");
		System.out.println("1. �α���");
		System.out.println("2. ȸ������");
		System.out.println("3. ����");
		System.out.print("���ϴ� �۾��� �����ϼ���:");
		int choice = Integer.parseInt(br.readLine());
		show(choice);
	}

	public static void show(int choice) throws IOException {
		MenuController ui = new MenuController();
		switch (choice) {
		case 1:
			if (ui.loginMenu()) {// �α���
				startAdminMenu();
			} else {
				startUserMenu();
			}
			break;
		case 2:
			if (ui.insertMenu()) {// ȸ������
				startAdminMenu();
			} else {
				startUserMenu();
			}

			break;
		case 3:
			return;
		default:
			System.out.println("�߸��� ȸ�������Դϴ�. ���� �޴��� ���ư��ϴ�.");
			break;
		}
	}

	public static void startUserMenu() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("******Ebook-Store********");
			System.out.println("ȯ���մϴ� �Ϲ� ȸ������");
			System.out.println("1. ȸ������ ����");
			System.out.println("2. ȸ��Ż��");
			System.out.println("3. ����");
			System.out.print("���ϴ� �۾��� �����ϼ���:");
			int choice = Integer.parseInt(br.readLine());
			table(choice);
		}
	}

	public static void startAdminMenu() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("******Ebook-Store********");
			System.out.println("ȯ���մϴ� ������ ȸ������");
			System.out.println("1. ȸ������ ����");
			System.out.println("2. ȸ��Ż��");
			System.out.println("3. ����");
			System.out.print("���ϴ� �۾��� �����ϼ���:");
			int choice = Integer.parseInt(br.readLine());
			table(choice);
		}

	}

	private static void table(int choice) throws NumberFormatException, IOException {
		MenuController ui = new MenuController();
		switch (choice) {
		case 1:
			if (ui.loginMenu()) {// �α���
				startAdminMenu();
			} else {
				startUserMenu();
			}
			break;
		case 2:
			if (ui.insertMenu()) {// ȸ������
				startAdminMenu();
			} else {
				startUserMenu();
			}

			break;
		case 3:
			return;
		default:
			System.out.println("�߸��� �����Դϴ�.");
			break;
		}
	}

}
/*
ebook_system/
������ Main.java                   // main ������
������ controller/
��   ������ MenuController.java     // ȸ������/�α��� ���
������ model/
��   ������ User.java               // ���� ���� Ŭ����
��   ������ Book.java               // å ���� Ŭ����
������ service/
��   ������ UserService.java        // ȸ�� CRUD ���
��   ������ BookService.java        // ��ǰ CRUD ���
������ repository/
��   ������ InMemoryDB.java         // ������ List�� ����/å ����
*/