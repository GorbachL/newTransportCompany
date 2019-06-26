package dao;

import entity.City;

import java.util.List;

public interface CityDao {

    City getCityByName(String name);
    List<City> getAllNames();
}
