package Casestudy_Module_2.caseStudy.services.iml;

import Casestudy_Module_2.caseStudy.models.Product;
import Casestudy_Module_2.caseStudy.repositories.ChatRepo;
import Casestudy_Module_2.caseStudy.repositories.ProductNormalRepo;
import Casestudy_Module_2.caseStudy.repositories.ProductSpecialRepo;
import Casestudy_Module_2.caseStudy.services.CustomerMethod;

import java.util.List;

public class CustomerService implements CustomerMethod {

    AdminService adminService = new AdminService();
    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public void removeProduct(Product product) {
    }

    @Override
    public List getProducts() {
        return ProductNormalRepo.getAllProducts();
    }

    @Override
    public List getSpecialOffers() {
        return ProductSpecialRepo.getAllProducts();
    }

    @Override
    public List seachByName(String name) {
        return adminService.seachByName(name);
    }

    @Override
    public List sortByPrice(String price) {
        return List.of();
    }


    public void chat(String message) {
        ChatRepo.writeFile(message, true);
    }

    @Override
    public void readChat() {
        ChatRepo.readFileChat();
    }

    public void writeChat(String message) {
        ChatRepo.writeFileChat(message,true);
    }


    @Override
    public Product seachByCode(String code) {
        List<Product> products = adminService.getAdmins();
        for (Product product : products) {
            if (product.getCodeProduct().equals(code)) {
                return product;
            }
        }
        return null;
    }
}
