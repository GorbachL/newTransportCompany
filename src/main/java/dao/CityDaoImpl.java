package dao;

import db.MySQLConnection;
import entity.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements CityDao {

    private static final String SELECT = "SELECT id, name, latitude, longitude, airport, seaport FROM Cities WHERE name = ?";

    private static final String SELECT_ALL = "SELECT name FROM Cities";

    @Override
    public City getCityByName(String name) {
        List<City> cityList = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setString(1, name);
            cityList = resultSetToList(statement.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //return cityList.size() == 0 ? new City() : cityList.get(0);

        if (cityList.size() == 0 ){
            return new City();
        }else {
            return cityList.get(0);
        }
    }

    @Override
    public List<City> getAllNames() {
        List<City> cityList = new ArrayList<>();
        try(Connection connection = MySQLConnection.getConnection()) {
            Statement statement = connection.createStatement();
            cityList = resultSet(statement.executeQuery(SELECT_ALL));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityList;
    }

    private List<City> resultSetToList(ResultSet result){
        List<City> cityList = new ArrayList<>();
        try {
            while (result.next()){
                City city = new City();
                city.setId(result.getInt("id"));
                city.setName(result.getString("name"));
                city.setLat(result.getDouble("latitude"));
                city.setLon(result.getDouble("longitude"));
                city.setAirport(result.getBoolean("airport"));
                city.setSeaport(result.getBoolean("seaport"));
                cityList.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityList;
    }

    private List<City> resultSet(ResultSet result){
        List<City> cityList = new ArrayList<>();
        try {
            while (result.next()){
                City city = new City();
                city.setName(result.getString("name"));
                cityList.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityList;
    }
}

