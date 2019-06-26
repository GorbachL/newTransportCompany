package entity;

public class Transport {

    private int id;
    private String name;
    private int speed;
    private int capacityPeople;
    private int capacityCargo;
    private int price;
    private Category category;

    public Transport(int id, String name, int speed, int capacityPeople, int capacityCargo, int price, Category category) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.capacityPeople = capacityPeople;
        this.capacityCargo = capacityCargo;
        this.price = price;
        this.category = category;
    }

    public Transport(int id) {
        this.id = id;
    }

    public Transport() {
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCapacityPeople() {
        return capacityPeople;
    }

    public void setCapacityPeople(int capacityPeople) {
        this.capacityPeople = capacityPeople;
    }

    public int getCapacityCargo() {
        return capacityCargo;
    }

    public void setCapacityCargo(int capacityCargo) {
        this.capacityCargo = capacityCargo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                ", capacityPeople=" + capacityPeople +
                ", capacityCargo=" + capacityCargo +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
