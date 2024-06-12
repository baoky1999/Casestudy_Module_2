package caseStudy.views;

import caseStudy.services.iml.CommonCheck;

import java.util.Scanner;

public class LogIn {

    public int selectAccount() {
        System.out.println("===========================================================");
        System.out.println("====== CHÀO MỪNG BẠN ĐẾN VỚI HỆ THỐNG BÁN HÀNG SSHOP ======");
        System.out.println("|                                                         |");
        System.out.println("| > Xin mời bạn chọn người dùng đăng nhập:                |");
        System.out.println("| > Bấm phím 1 để đăng nhập với tư cách Quản trị viên     |");
        System.out.println("| > Bấm phím 2 để đăng nhập với tư cách khách hàng        |");
        System.out.println("===========================================================");
        System.out.println("Nhập phím tương ứng để chọn người dùng:");
        int choice = CommonCheck.checkParseInteger();
        return choice;
    }

    public String logInUserNameAdmin () {
        Scanner input = new Scanner(System.in);
        System.out.println("===========================================================");
        System.out.println("|                   Đăng nhập quản trị viên               |");
        System.out.println("===========================================================");
        System.out.print("Nhập tên đăng nhập: ");
        String userName = input.nextLine();
        return userName;
    }

    public String logInUserNameCustomer () {
        Scanner input = new Scanner(System.in);
        System.out.println("===========================================================");
        System.out.println("|                   Đăng nhập khách hàng                  |");
        System.out.println("===========================================================");
        System.out.print("Nhập tên đăng nhập: ");
        String userName = input.nextLine();
        return userName;
    }

    public String logInPassWord () {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập Password: ");
        String userPassword = input.nextLine();
        return userPassword;
    }

}
