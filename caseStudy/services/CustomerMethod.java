package caseStudy.services;

import caseStudy.models.AdminProduct;
import caseStudy.models.Product;

import java.util.List;

public interface CustomerMethod extends Method{

    Product seachByCode(String code);
}
