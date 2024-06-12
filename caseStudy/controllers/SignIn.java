package Casestudy_Module_2.caseStudy.controllers;

import Casestudy_Module_2.caseStudy.services.iml.CheckAccount;
import Casestudy_Module_2.caseStudy.views.LogIn;
import Casestudy_Module_2.caseStudy.views.ViewMenu;

public class SignIn {

    LogIn logIn = new LogIn();
    CheckAccount check = new CheckAccount();
    ControllerAdmin controllerAdmin = new ControllerAdmin();
    ControllerCustomer controllerCustomer = new ControllerCustomer();

    boolean checkName;
    boolean checkPass;
    int count = 0;
    String result;
    String userName;
    String pass;
    int choice = logIn.selectAccount();

    public void signIn() {
        if (choice == 1) {
            signInAdmin();
        }
        if (choice == 2) {
            signInCustomer();
        }
    }
    public void signInAdmin() {
        do {
            result = logIn.logInUserNameAdmin();
            userName = checkUserName(result);
            checkName = check.checkLogInUserNameAdmin(userName);
            if (!checkName) {
                System.out.println("Tên đăng nhập không tồn tại!");
            }
        } while (!checkName);

        do {
            count++;
            pass = logIn.logInPassWord();
            checkPass = check.logInPassWordAdmin(pass);
            if (!checkPass) {
                System.out.println("Mật khẩu chưa chính xác!, sai lần: " + count + " (giới hạn 3 lần)");
            }
            if (count == 3) {
                try {
                    throw new Exception("Nhập quá số lần quy định (giới hạn 3 lần)");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } while (!checkPass);
        controllerAdmin.controllerMenu();

    }

    public void signInCustomer() {
        do {
            result = logIn.logInUserNameCustomer();
            userName = checkUserName(result);
            checkName = check.checkLogInUserNameCustomer(userName);
            if (!checkName) {
                System.out.println("Tên đăng nhập không tồn tại!");
            }
        } while (!checkName);

        do {
            count++;
            pass = logIn.logInPassWord();
            checkPass = check.logInPassWordCustomer(pass);
            if (!checkPass) {
                System.out.println("Mật khẩu chưa chính xác!, sai lần: " + count + " (giới hạn 3 lần)");
            }
            if (count == 4) {
                try {
                    throw new Exception("Nhập quá số lần quy định (giới hạn 3 lần)");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } while (!checkPass);
        controllerCustomer.controllerMenu();
    }
    public String checkUserName(String result) {
        String userName = "";
        if (result == null) {
            System.out.println("Không tồn tại tài khoản này!");
        } else {
            userName = result;
        }
        return userName;
    }


}
