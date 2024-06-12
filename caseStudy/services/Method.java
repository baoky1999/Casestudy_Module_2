package caseStudy.services;

import caseStudy.models.Product;

import java.util.List;


public interface Method {

    boolean addProduct(Product product); //thêm mới sản phẩm
    void removeProduct(Product product); // xóa sản phẩm
    List<Product> getProducts(); // danh sách sản phẩm
    List<Product> getSpecialOffers(); // danh sách khuyến mãi
    List<Product> seachByName(String name); // tìm kiếm sản phẩm theo tên
    List<Product> sortByPrice(String price); // xem danh sách theo giá tiền
    void chat(String message); // chat với người khác
    void readChat();

}
