package Casestudy_Module_2.caseStudy.repositories;

import Casestudy_Module_2.caseStudy.models.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static Casestudy_Module_2.caseStudy.repositories.AdminRepositories.URL_DATA;

public class ProductSpecialRepo {

    public static List<Product> getAllProducts() {
        List<Product> products = new ArrayList<Product>();
        File file = new File(URL_DATA);

        try(FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader))
        {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tem = line.split(",");
                if (tem.length == 7) {
                    products.add(new Casestudy_Module_2.caseStudy.models.ProductSpecial(Integer.parseInt(tem[0]),tem[1],tem[2],tem[3],Integer.parseInt(tem[4]),tem[5],tem[6]));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thất File");
        } catch (IOException e) {
            System.out.println("Lỗi đọc dữ liệu File");
        }
        return products;
    }
}
