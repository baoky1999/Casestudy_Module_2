package Casestudy_Module_2.caseStudy.models;

public class InformationCustomer {

    private String name;
    private int phone;
    private String email;

    public InformationCustomer( String name,int phone, String email) {
        this.phone = phone;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String toString() {
        return "Tên khách hàng: " + getName() +"\n"
                + "Số điện thoại: " + getPhone() + "\n"
                + "Email: " + getEmail();
    }
}
