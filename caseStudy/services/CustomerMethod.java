package Casestudy_Module_2.caseStudy.services;

import Casestudy_Module_2.caseStudy.models.AdminProduct;
import Casestudy_Module_2.caseStudy.models.Product;

import java.util.List;

public interface CustomerMethod extends Method{

    Product seachByCode(String code);
}
