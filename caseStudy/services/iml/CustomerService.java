package caseStudy.services.iml;

import caseStudy.models.Product;
import caseStudy.repositories.ChatRepo;
import caseStudy.repositories.ProductNormalRepo;
import caseStudy.repositories.ProductSpecialRepo;
import caseStudy.services.CustomerMethod;

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
