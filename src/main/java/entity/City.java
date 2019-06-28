package entity;

public class City {

    private int id;
    private String name;
    private double lat;
    private double lon;
    private boolean airport;
    private boolean seaport;

    public City(int id, String name, double lat, double lon, boolean airport, boolean seaport) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.airport = airport;
        this.seaport = seaport;
    }

    public City() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public boolean isAirport() {
        return airport;
    }

    public void setAirport(boolean airport) {
        this.airport = airport;
    }

    public boolean isSeaport() {
        return seaport;
    }

    public void setSeaport(boolean seaport) {
        this.seaport = seaport;
    }

    @Override
    public String toString() {
        return "City{" +
                (id == 0 ? "" : "id=" + id) +
                (name == null ? "" : ", name= " + name + '\'') +
                (lat == 0 ? "" : ", lat = " + lat + '\'') +
                (lon == 0 ? "" : ", lon = " + lon + '\'') +
                (airport == false  ? "" : ", airoport=" + airport) +
                (seaport == false ? "" : ", seaport=" + seaport) +
                '}';
    }
}
