package Casestudy_Module_2.caseStudy.services;

import Casestudy_Module_2.caseStudy.models.AdminProduct;
import Casestudy_Module_2.caseStudy.models.Product;

import java.util.List;

public interface AdminMethod extends Method {

    List <Product> getAdmins(); // quản lý tổng hàng trong kho
    List <Product> getAdminOder(); // quản lý đơn đặt hàng trước
    void editProduct(int index, Product adminProduct); // sửa thông tin sản phẩm
    double totalRevenue();// doanh thu của của hàng
    Product findRemoveAdmin(String admin);
    int findIndexEdit (Product adminProduct);
}
