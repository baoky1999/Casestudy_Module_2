package caseStudy.views;

import caseStudy.models.AdminProduct;
import caseStudy.models.Product;
import caseStudy.models.ProductSpecial;
import caseStudy.repositories.AdminRepositories;
import caseStudy.services.iml.CommonCheck;

import java.util.List;
import java.util.Scanner;

public class ViewWareHouse {
    AdminRepositories adminRepositories = new AdminRepositories();
    List<Product> waseHouse = adminRepositories.getAllAdmin();
    int count = waseHouse.size() + 1;
    AdminProduct adminProduct1 = new AdminProduct();

    public int viewWareHouse() {
        System.out.println("==========================================================");
        System.out.println("|                   Kho hàng Samsung                     |");
        System.out.println("==========================================================");
        System.out.println("| > 1: Danh sách các sản phẩm trong kho                  |");
        System.out.println("| > 2: Xóa sản phẩm trong kho                            |");
        System.out.println("| > 3: Thêm sản phẩm mới vào kho                         |");
        System.out.println("| > 4: Sửa thông tin sản phẩm                            |");
        System.out.println("| > 5: Trở lại Menu chính                                |");
        System.out.println("==========================================================");
        System.out.println("Choice:");
        int choice = CommonCheck.checkParseInteger();
        return choice;
    }

    public Product viewAdd() {
        Scanner input = new Scanner(System.in);
        System.out.println("             Thêm sản phẩm mới vào kho                    ");
        int stt = count++;
        System.out.print("Nhập mã sản phẩm:");
        String code = CommonCheck.checkRegexPoint();
        System.out.print("Nhập tên sản phẩm:");
        String name = input.nextLine();
        System.out.print("Nhập tên nhà sản xuất:");
        String nameProducer = input.nextLine();
        System.out.print("Nhập giá tiền sản phẩm:");
        int price = CommonCheck.checkParseInteger();
        System.out.print("Nhập thông tin sản phẩm:");
        String information = input.nextLine();
        System.out.println("Có áp dụnh khuyến mãi với sản phẩm này không? Nếu có bấm YES, không thì bấm NO");
        String check = input.nextLine();
        if (check.equals("NO")) {
            AdminProduct adminProduct = new AdminProduct(stt,code,name,nameProducer,price,information);
            return adminProduct;
        } else {
            System.out.println("Nhập % khuyến mãi sản phẩm: ");
            String special = input.nextLine();
            ProductSpecial productSpecial = new ProductSpecial(stt,code,name,nameProducer,price,information,special);
            return productSpecial;
        }
    }

    public void viewTotal(List<Product> adminProducts) {
        int count = 0;
        System.out.println("                  Danh sách sản phẩm trong kho                 ");
        for (Product adminProduct : adminProducts) {
            count++;
            System.out.println(count + "," + adminProduct.toString());
        }
    }

    public void viewAddMessage(boolean check) {
        if (check) {
            System.out.println("Thêm mới sản phẩm thành công");
        } else {
            System.err.println("Thêm mới sản phẩm thất bại!");
        }
    }

    public String removeProduct() {
        System.out.println("Nhập mã sản phẩm cần xóa:");
        String remove = CommonCheck.checkRegexPoint();
        return remove;
    }

    public void viewRemove(boolean check) {
        if (check) {
            System.out.println("Xóa sản phẩm thành công");
        } else {
            System.err.println("Xóa sản phẩm thất bại");
        }
    }

    public boolean isRemove(Product adminProduct) {
        System.out.println("Bạn có chắc chắn muốn xóa sản phẩm : " + adminProduct.getNameProduct() + " này không? Nếu xác nhận xóa bấm YES còn muốn hủy bấm NO.");
        Scanner input = new Scanner(System.in);
        String remove = input.nextLine();
        if (remove.equals("YES")) {
            return true;
        }
        return false;
    }

    public String editProduct() {
        System.out.println("Nhập mã sản phẩm cần sửa:");
        String edit = CommonCheck.checkRegexPoint();
        return edit;
    }

    public void viewEdit(boolean check) {
        if (check) {
            System.out.println("Sửa thông tin sản phẩm thành công");
        } else {
            System.err.println("Sửa thông tin sản phẩm thất bại");
        }
    }

    public Product EidtProduct(Product adminProduct) {
        Scanner input = new Scanner(System.in);
        adminProduct1.setStt(adminProduct.getStt());
        System.out.print("Mã sản phẩm hiện tại: " + adminProduct.getCodeProduct() + " : Nhập mã mới(có thể copy lại mã cũ):");
        String code = CommonCheck.checkRegexPoint();
        adminProduct1.setCodeProduct(code);
        System.out.println("Tên sản phẩm hiện tại là: " + adminProduct.getNameProduct() + " : Nhập tên mới(có thể copy lại tên cũ):");
        String name = input.nextLine();
        adminProduct1.setNameProduct(name);
        System.out.println("Nhà sản xuất hiện tại là: " + adminProduct.getProducer() + " : Nhập tên mới(có thể copy lại tên cũ):");
        String producer = input.nextLine();
        adminProduct1.setProducer(producer);
        System.out.println("Giá tiền sản phẩm hiện tại là: " + adminProduct.getPriceProduct() + " : Nhập giá tiền mới(có thể copy lại giá tiền cũ):");
        int price = CommonCheck.checkParseInteger();
        adminProduct1.setPriceProduct(price);
        System.out.println("Thông tin chi tiết sản phẩm hiện tại là: " + adminProduct.getInformationProduct() + " : Nhập thông tin mới(có thể copy lại thông tin cũ):");
        String information = input.nextLine();
        adminProduct1.setInformationProduct(information);
        return adminProduct1;
    }

    public String searchProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm cần tìm: ");
        String search = input.nextLine();
        return search;
    }

    public void revenue() {
        System.out.println("=========================================================");
        System.out.println("|                     Doanh thu quý III                 |");
        System.out.println("=========================================================");
    }

    public void chatAdmin() {
        System.out.println("==========================================================");
        System.out.println("|             Danh sách tư vấn khách hàng                |");
        System.out.println("==========================================================");
        System.out.println("Danh sách hàng cần tư vấn");
    }

    public String chat() {
        Scanner input = new Scanner(System.in);
        System.out.println("==========================================================");
        System.out.println("|                  Tư vấn khách hàng                     |");
        System.out.println("==========================================================");
        System.out.println("Nhập tin nhắn: ");
        String message = input.nextLine();
        return message;
    }

    public int selectionChat() {
        Scanner input = new Scanner(System.in);
        System.out.println("==========================================================");
        System.out.println("|                  Tư vấn khách hàng                     |");
        System.out.println("|                                                        |");
        System.out.println("|   1> Xem danh sách khách hàng cần tư vấn               |");
        System.out.println("|   2> Trò chuyện với khách hàng                         |");
        System.out.println("==========================================================");
        int choice = CommonCheck.checkParseInteger();
        return choice;
    }

    public void notification(String message) {
        if (message.equals("")) {
            System.out.println("Tin nhắn chưa được gửi đi!");
        } else {
            System.out.println("Tin nhắn đã được gửi đi thành công");
        }
    }

}
