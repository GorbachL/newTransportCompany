package controllers;

import dao.CategoriesDao;
import dao.CategoriesDaoImpl;
import dao.TransportDao;
import dao.TransportDaoImpl;
import entity.Category;
import entity.City;
import entity.Transport;

import java.util.List;


public class TransportController {

    private TransportDao transportDao = new TransportDaoImpl();
    private CategoriesDao categoriesDao = new CategoriesDaoImpl();

    public void checkMatch(City from, City to, String peopleAmount, String cargoAmount) {
        double distance = distance(from.getLat(), from.getLon(), to.getLat(), to.getLon());
        System.out.println(from);
        System.out.println(to);
        System.out.println("Distance between cities: " + distance);


        Category category = null;
        if (from.isSeaport() && to.isSeaport()) {
            category = categoriesDao.findByName("marine");

        } else if (from.isAirport() && to.isAirport()) {
            category = categoriesDao.findByName("air");
        } else {
            category = categoriesDao.findByName("ground");
        }

        List<Transport> transports = transportDao.getTransportByCategory(category);
        Transport cheapestAndFastest = transports.get(0);

      //  System.out.println(cheapestAndFastest);

        if (cheapestAndFastest.getCapacityCargo() >= Integer.valueOf(cargoAmount)
                && cheapestAndFastest.getCapacityPeople() >= Integer.valueOf(peopleAmount)) {
            System.out.println("Available transport is: " + cheapestAndFastest.getName()
                    + " cost = " + (cheapestAndFastest.getPrice() * distance));
        }

    }


    private static double distance(double lat1, double lon1, double lat2, double lon2) {

        final int R = 6371; //Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        distance = Math.pow(distance, 2) / 1000;

       // return Math.sqrt(distance);
        return distance;

    }

}

