package dao;

import db.MySQLConnection;
import entity.Category;
import entity.Transport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransportDaoImpl implements TransportDao {

    private static final String SELECT = "SELECT t.*, c.name AS category_name FROM transport t LEFT JOIN categories c ON t.category_id = c.id ";
    private static final String SELECT_BY_CATEGORY = "SELECT * FROM transport WHERE category_id = ? order by price_km, speed desc";


    @Override
    public List<Transport> getTransportByCategory(Category category) {
        List<Transport> transports = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_CATEGORY);
            statement.setInt(1, category.getId());
            transports = resultSetToList(statement.executeQuery(), false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transports;
    }


    @Override
    public List<Transport> get() {
        List<Transport> transports = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection()) {
            Statement statement = connection.createStatement();
            transports = resultSetToList(statement.executeQuery(SELECT));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transports;
    }

    private List<Transport> resultSetToList(ResultSet result) {

        return resultSetToList(result, true);
    }

    private List<Transport> resultSetToList(ResultSet result, boolean includeCategories) {
        List<Transport> transports = new ArrayList<>();
        try {
            while (result.next()) {
                Transport transport = new Transport();
                transport.setId(result.getInt("id"));
                transport.setName(result.getString("name"));
                transport.setPrice(result.getInt("price_km"));
                transport.setCapacityPeople(result.getInt("capacity_people"));
                transport.setCapacityCargo(result.getInt("capacity_cargo"));

                if (includeCategories) {
                    Category category = new Category(
                            result.getInt("category_id"),
                            result.getString("category_name"));
                    transport.setCategory(category);
                }
                transports.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transports;
    }

}