package Casestudy_Module_2.caseStudy.controllers;

import Casestudy_Module_2.caseStudy.models.InformationCustomer;
import Casestudy_Module_2.caseStudy.models.Product;
import Casestudy_Module_2.caseStudy.repositories.CartRepositories;
import Casestudy_Module_2.caseStudy.services.iml.CustomerService;
import Casestudy_Module_2.caseStudy.views.ViewCustomer;
import Casestudy_Module_2.caseStudy.views.ViewMenu;
import Casestudy_Module_2.caseStudy.views.ViewWareHouse;

import java.util.List;
import java.util.Map;

public class ControllerCustomer {

    public void controllerMenu() {
        ViewMenu viewMenu = new ViewMenu();
        CustomerService customerService = new CustomerService();
        ViewWareHouse viewWareHouse = new ViewWareHouse();
        ViewCustomer viewCustomer = new ViewCustomer();

        CartRepositories cart = new CartRepositories();
        List productList;
        int choice;
        String code;
        Product product;
        int quantily;
        Map<String,Integer> map;
        String searchName;
        List<Product> searchList;
        boolean checkBuy;
        int pay;
        boolean write;
        while (true) {
            choice = viewMenu.customerMenu();
            switch (choice) {
                case 1:
                    code = viewCustomer.customerBuyCode();
                    product = customerService.seachByCode(code);
                    quantily = viewCustomer.customerBuyQuantily();
                    cart.addToCart(product,quantily);
                    break;
                case 2:
                    code = viewCustomer.customerRemoveCode();
                    quantily = viewCustomer.customerBuyQuantily();
                    map = cart.removeFromCart(code,quantily);
                    cart.displayCartRemove(map);
                    break;
                case 3:
                    productList = customerService.getProducts();
                    viewWareHouse.viewTotal(productList);
                    break;
                case 4:
                    searchName = viewWareHouse.searchProduct();
                    searchList = customerService.seachByName(searchName);
                    viewWareHouse.viewTotal(searchList);
                    break;
                case 5:
                    productList = customerService.getSpecialOffers();
                    viewWareHouse.viewTotal(productList);
                    break;
                case 6:
                    cart.readFile();
                    System.out.println("Tổng giá trị đơn hàng là: " + cart.moneyProduct() + " VNĐ");
                    checkBuy = viewCustomer.buyProduct();
                    pay = viewCustomer.payProduct(checkBuy);
                    viewCustomer.completeBuy(pay);
                    write = cart.writeStories();
                    if (write) {
                        CartRepositories.clearFile();
                    }
                    break;
                case 7:
                    choice = viewCustomer.selectionChat();

                    switch (choice) {
                        case 1:
                            InformationCustomer informationCustomer = viewCustomer.chatCustomer();
                            customerService.chat(String.valueOf(informationCustomer));
                            viewCustomer.notification(String.valueOf(informationCustomer));
                            break;
                        case 2:
                            customerService.readChat();
                            String message = viewCustomer.Chat();
                            customerService.writeChat("Khách hàng: " + message);
                            viewCustomer.notification(message);
                            break;
                    }
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Choice again!");
            }
        }
    }

}
