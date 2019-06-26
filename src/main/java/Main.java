import controllers.CategoryController;
import controllers.CitiesController;
import controllers.TransportController;
import dao.CategoriesDao;
import dao.CategoriesDaoImpl;
import dao.CityDao;
import dao.CityDaoImpl;
import entity.City;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

//        CategoryController categoryController = new CategoryController();
//        System.out.println(categoryController.getCategoriesWithTransport());

        System.out.println("Select where you want to go");
        CityDao cityDao = new CityDaoImpl();
        System.out.println(cityDao.getAllNames());


        System.out.println("Enter FROM City");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fromCity = reader.readLine();

        System.out.println("Enter TO City");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String toCity = reader.readLine();

        System.out.println(fromCity);
        System.out.println(toCity);

        System.out.println("Enter number of People");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String peopleAmount = reader.readLine();

        System.out.println("Enter Cargo Amount");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String cargoAmount = reader.readLine();

        CitiesController citiesController2 = new CitiesController();

        City cityFrom = citiesController2.getCityByName(fromCity);
        City cityTo = citiesController2.getCityByName(toCity);

        TransportController transportController = new TransportController();
        transportController.checkMatch(cityFrom, cityTo, peopleAmount, cargoAmount);



    }
}


