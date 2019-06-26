package dao;

import db.MySQLConnection;
import entity.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDaoImpl implements CategoriesDao {

    private static final String SELECT = "SELECT * FROM categories";
    private static final String FIND_BY_NAME = "select * from categories where name = ? ";

    @Override
    public List<Category> get() {
        List<Category> categories = new ArrayList<>();
        try(Connection connection = MySQLConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(SELECT);
            while (result.next()){
                Category category = new Category();
                category.setId(result.getInt("id"));
                category.setName(result.getString("name"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category findByName(String name) {
        List<Category> categories = new ArrayList<>();
        try(Connection connection = MySQLConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME);
            statement.setString(1, name);
            categories = resultSetToList(statement.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return categories.get(0);
        if (categories.size() == 0){
            return new Category();
        }else {
            return categories.get(0);
        }
    }

    private List<Category> resultSetToList(ResultSet results){
        List<Category> categories = new ArrayList<>();
        try{
            while (results.next()){
                Category category = new Category();
                category.setId(results.getInt("id"));
                category.setName(results.getString("name"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}

