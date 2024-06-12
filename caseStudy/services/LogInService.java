package caseStudy.services;

public interface LogInService {

    boolean checkLogInUserNameAdmin(String userName) throws Exception; ;
    boolean logInPassWordAdmin(String pass) throws Exception;;
    boolean checkLogInUserNameCustomer(String userName) throws Exception;;
    boolean logInPassWordCustomer(String pass) throws Exception;;
}
