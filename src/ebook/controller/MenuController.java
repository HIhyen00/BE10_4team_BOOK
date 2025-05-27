package ebook.controller;

import ebook.model.*;

import java.util.Scanner;

public class MenuController {
    private static final Scanner sc = new Scanner(System.in);
    private final UserDTOImpl dao = new UserDTOImpl(); // User ���� DAO (DB ó��)

    /**
     * ȸ������ ó��
     * @return true: ���� / false: ����
     */
    public boolean insertMenu() {
        System.out.println("[ȸ������]");
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

        UserDTO newUser = new UserDTO(id, pw, name, email, isAdmin);
        boolean result = dao.insert(newUser); // DB�� ȸ�� ���� ���� (�ߺ� �˻� �� ����)

        if (result) {
            System.out.println("ȸ������ �Ϸ�!");
            return true;
        } else {
            System.out.println("ȸ������ ����! (�ߺ� ID ��)");
            return false;
        }
    }

    /**
     * �α��� ó�� (�α��� ���� �� UserDTO ��ȯ)
     * @return UserDTO: �α��� ���� �� ����� ���� ��ȯ / ���� �� null
     */
    public UserDTO loginMenu() {
        System.out.println("[�α���]");
        System.out.print("���̵� �Է�: ");
        String id = sc.nextLine();
        System.out.print("��й�ȣ �Է�: ");
        String pw = sc.nextLine();

        UserDTO user = dao.Login(id, pw); // DB���� ���� ��ȸ
        if (user != null) {
            System.out.println(user.getName() + "�� ȯ���մϴ�!");
            return user;
        } else {
            System.out.println("�α��� ����! ���̵�/��й�ȣ�� Ȯ���ϼ���.");
            return null;
        }
    }

    /**
     * ȸ������ ����
     */
    public void updateUserMenu(UserDTO user) {
        // TODO: ���� (����)
        System.out.println("[ȸ������ ����]");
        // �ʿ��� ������ �޴� ������...
        System.out.print("������ �̸��� �Է� (����: " + user.getEmail() + "): ");
        String newEmail = sc.nextLine();
        if (!newEmail.isEmpty()) {
            user.setEmail(newEmail);
        }
        System.out.print("������ ��й�ȣ �Է�(����: ���� ����): ");
        String newPw = sc.nextLine();
        if (!newPw.isEmpty()) {
            user.setPassword(newPw);
        }
        boolean result = dao.update(user);
        if (result) {
            System.out.println("ȸ�������� �����Ǿ����ϴ�.");
        } else {
            System.out.println("ȸ������ ���� ����!");
        }
    }

    /**
     * ȸ��Ż��
     * @return true: Ż�� ����, false: ����
     */
    public boolean deleteUserMenu(UserDTO user) {
        System.out.println("[ȸ��Ż��]");
        System.out.print("���� Ż���Ͻðڽ��ϱ�? (y/n): ");
        String confirm = sc.nextLine();
        if (!confirm.equalsIgnoreCase("y")) {
            System.out.println("Ż�� ��ҵǾ����ϴ�.");
            return false;
        }
        boolean result = dao.delete(user.getId());
        if (result) {
            System.out.println("ȸ��Ż�� �Ϸ�Ǿ����ϴ�.");
            return true;
        } else {
            System.out.println("ȸ��Ż�� ����!");
            return false;
        }
    }

    public void bookListMenu() {
        System.out.println("[���� ���]");
        // ����: bookDao.getAllBooks()�� ��ü ��� �޾ƿ�
        // List<BookDTO> bookList = bookDao.getAllBooks();
        // for (BookDTO book : bookList) {
        //     System.out.println(book.getId() + ". " + book.getTitle() + " - " + book.getAuthor() + " (" + book.getPrice() + "��)");
        // }
        System.out.println("�� ���� ��� ���(�ӽ�). ���� ���� �� DB ���� �ʿ�");
    }

    /**
     * 2. ���� �� ���� - ���� ID�� �� ���� ���
     */
    public void bookDetailMenu() {
        System.out.println("[���� �� ����]");
        System.out.print("�� ��ȸ�� ����ID�� �Է��ϼ���: ");
        String bookId = sc.nextLine();
        // ����: BookDTO book = bookDao.getBookById(bookId);
        // if (book != null) {
        //     System.out.println(book.detailInfo());
        // } else {
        //     System.out.println("�������� �ʴ� �����Դϴ�.");
        // }
        System.out.println("�� ���� ������ ���(�ӽ�). ���� ���� �� DB ���� �ʿ�");
    }

    /**
     * 3. ���� ���� - ����, ����ID, ���� �޾� �ֹ� ó��
     */
    public void purchaseBookMenu(UserDTO user) {
        System.out.println("[���� ����]");
        System.out.print("������ ����ID: ");
        String bookId = sc.nextLine();
        System.out.print("����: ");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.println("���� ����� �����ϼ���. (1: ����, 2: ����Ʈ): ");
        int payType = Integer.parseInt(sc.nextLine());
        // �ֹ� ó�� ���� (�ܾ�/����Ʈ ���� ��)
        // boolean success = orderDao.purchase(user, bookId, quantity, payType);
        // if (success) System.out.println("���� ����!");
        // else System.out.println("���� ����(�ܾ�/��� ���� ��)");
        System.out.println("�� ���� ó��(�ӽ�). ���� ���� �� DB ���� �ʿ�");
    }

    /**
     * 4. ���� ���� Ȯ�� - �ش� ������ �ֹ� ��� ���
     */
    public void orderHistoryMenu(UserDTO user) {
        System.out.println("[���� ���� Ȯ��]");
        // List<OrderDTO> orders = orderDao.getOrdersByUser(user.getId());
        // for (OrderDTO order : orders) {
        //     System.out.println(order.simpleInfo());
        // }
        System.out.println("�� ���� ����(�ӽ�). ���� ���� �� DB ���� �ʿ�");
    }

    /**
     * 5. ���� �ۼ� - ����ID, ����, ���� �޾� ���� ���
     */
    public void writeReviewMenu(UserDTO user) {
        System.out.println("[���� �ۼ�]");
        System.out.print("���� �ۼ��� ����ID: ");
        String bookId = sc.nextLine();
        System.out.print("����(1~5): ");
        int rating = Integer.parseInt(sc.nextLine());
        System.out.print("���� ����: ");
        String content = sc.nextLine();
        // boolean success = reviewDao.insertReview(new ReviewDTO(user.getId(), bookId, rating, content));
        // if (success) System.out.println("���� ��� �Ϸ�!");
        // else System.out.println("���� ��� ����(���� �̷� ���� ��)");
        System.out.println("�� ���� ���(�ӽ�). ���� ���� �� DB ���� �ʿ�");
    }

    /**
     * 6. FAQ ���� - FAQ ��� ���
     */
    public void faqMenu() {
        System.out.println("[FAQ ����]");
        // List<FaqDTO> faqList = faqDao.getAllFaq();
        // for (FaqDTO faq : faqList) {
        //     System.out.println(faq);
        // }
        System.out.println("�� FAQ ���(�ӽ�). ���� ���� �� DB ���� �ʿ�");
    }

    /**
     * 1. ���� ���(������) - �ű� ���� ���� �Է� �޾� ���
     */
    public void registerBookMenu() {
        System.out.println("[���� ���]");
        System.out.print("���� ����: ");
        String title = sc.nextLine();
        System.out.print("����: ");
        String author = sc.nextLine();
        System.out.print("����: ");
        int price = Integer.parseInt(sc.nextLine());
        System.out.print("ī�װ�: ");
        String category = sc.nextLine();
        // BookDTO newBook = new BookDTO(title, author, price, category);
        // boolean success = bookDao.insert(newBook);
        // if (success) System.out.println("���� ��� ����!");
        // else System.out.println("���� ��� ����!");
        System.out.println("�� ���� ���(�ӽ�). ���� ���� �� DB ���� �ʿ�");
    }

    /**
     * 2. ���� ����(������) - ���� ID�� ����
     */
    public void deleteBookMenu() {
        System.out.println("[���� ����]");
        System.out.print("������ ����ID: ");
        String bookId = sc.nextLine();
        // boolean success = bookDao.delete(bookId);
        // if (success) System.out.println("���� ���� ����!");
        // else System.out.println("���� ���� ����(���� ID)");
        System.out.println("�� ���� ����(�ӽ�). ���� ���� �� DB ���� �ʿ�");
    }

    /**
     * 4. ȸ�� ��� ��ȸ(������) - ��ü ȸ�� ���
     */
    public void userListMenu() {
        System.out.println("[ȸ�� ��� ��ȸ]");
        // List<UserDTO> userList = dao.getAllUsers();
        // for (UserDTO user : userList) {
        //     System.out.println(user);
        // }
        System.out.println("�� ȸ�� ��� ���(�ӽ�). ���� ���� �� DB ���� �ʿ�");
    }

    /**
     * 5. FAQ ���(������)
     */
    public void registerFaqMenu() {
        System.out.println("[FAQ ���]");
        System.out.print("FAQ ����: ");
        String title = sc.nextLine();
        System.out.print("FAQ ����: ");
        String content = sc.nextLine();
        // FaqDTO faq = new FaqDTO(title, content);
        // boolean success = faqDao.insert(faq);
        // if (success) System.out.println("FAQ ��� ����!");
        // else System.out.println("FAQ ��� ����!");
        System.out.println("�� FAQ ���(�ӽ�). ���� ���� �� DB ���� �ʿ�");
    }

    /**
     * 6. FAQ ����/����(������)
     */
    public void updateFaqMenu() {
        System.out.println("[FAQ ����/����]");
        System.out.print("����/������ FAQ ID: ");
        String faqId = sc.nextLine();
        System.out.print("1. ����  2. ���� : ");
        int mode = Integer.parseInt(sc.nextLine());
        if (mode == 1) {
            System.out.print("������ ���� �Է�: ");
            String content = sc.nextLine();
            // boolean success = faqDao.update(faqId, content);
            // if (success) System.out.println("FAQ ���� ����!");
            // else System.out.println("FAQ ���� ����!");
        } else if (mode == 2) {
            // boolean success = faqDao.delete(faqId);
            // if (success) System.out.println("FAQ ���� ����!");
            // else System.out.println("FAQ ���� ����!");
        } else {
            System.out.println("�߸��� �����Դϴ�.");
        }
        System.out.println("�� FAQ ����/����(�ӽ�). ���� ���� �� DB ���� �ʿ�");
    }
}
