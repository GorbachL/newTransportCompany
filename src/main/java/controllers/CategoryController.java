package controllers;

import dao.CategoriesDao;
import dao.CategoriesDaoImpl;
import dao.TransportDao;
import dao.TransportDaoImpl;
import entity.Category;
import entity.Transport;

import java.util.List;

public class CategoryController {

    CategoriesDao categoriesDao = new CategoriesDaoImpl();
    TransportDao transportDao = new TransportDaoImpl();

    public List<Category> getCategoriesWithTransport(){
        List<Category> categories = categoriesDao.get();
        for (Category category : categories){
            List<Transport> categoryTransports = transportDao.getTransportByCategory(category);
            category.setTransports(categoryTransports);
        }
        return categories;
    }

}


