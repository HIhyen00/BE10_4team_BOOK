package ebook.model;

import java.time.LocalDate;
import java.util.Objects;

public class UserDTO {
    private String id;
    private String password;
    private String name;
    private String email;
    private LocalDate joinDate;
    private int pay;
    private int point;
    private boolean isAdmin;

    // �⺻ ������
    public UserDTO() {}

    // ȸ������ �� ���
    public UserDTO(String id, String password, String name, String email, boolean isAdmin) {
        this(id, password, name, email, LocalDate.now(), 0, 0, isAdmin);
    }

    // ��� �ʵ� �Է� ������ (DB��ȸ/�׽�Ʈ��)
    public UserDTO(String id, String password, String name, String email, LocalDate joinDate,
                   int pay, int point, boolean isAdmin) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.joinDate = joinDate;
        this.pay = pay;
        this.point = point;
        this.isAdmin = isAdmin;
    }

    // getter�� (id, name, joinDate)
    public String getId() { return id; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public LocalDate getJoinDate() { return joinDate; }
    public int getPay() { return pay; }
    public int getPoint() { return point; }
    public boolean isAdmin() { return isAdmin; }

    // setter (���� ������)
    public void setPassword(String password) { this.password = password; }
    public void setEmail(String email) { this.email = email; }
    public void setPay(int pay) { this.pay = pay; }
    public void setPoint(int point) { this.point = point; }

    // toString �������̵� (�����, �α�, �׽�Ʈ�� ����)
    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", joinDate=" + joinDate +
                ", pay=" + pay +
                ", point=" + point +
                ", isAdmin=" + isAdmin +
                '}';
    }

    // equals/hashCode (�÷���, ��, �׽�Ʈ��)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
