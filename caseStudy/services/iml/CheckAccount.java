package Casestudy_Module_2.caseStudy.services.iml;

import Casestudy_Module_2.caseStudy.services.LogInService;

public class CheckAccount implements LogInService {

    @Override
    public boolean checkLogInUserNameAdmin(String userName) {
        if (userName.trim().equals("admin")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean logInPassWordAdmin(String pass) {
        if (pass.trim().equals("codegym")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkLogInUserNameCustomer(String userName) {
        if (userName.trim().equals("customer")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean logInPassWordCustomer(String pass) {
        if (pass.trim().equals("customer")) {
            return true;
        }
        return false;
    }
}
