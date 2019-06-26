package controllers;

import dao.CityDao;
import dao.CityDaoImpl;
import entity.City;


public class CitiesController {

    CityDao cityDao = new CityDaoImpl();

    public City getCityByName(String cityName){

        return cityDao.getCityByName(cityName);
    }

}

