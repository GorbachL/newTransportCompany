package dao;


import entity.Category;

import java.util.List;

public interface CategoriesDao {

    List<Category> get();
    Category findByName (String name);
}
