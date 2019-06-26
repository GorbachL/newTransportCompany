package dao;

import entity.Category;
import entity.Transport;

import java.util.List;

public interface TransportDao {

    List<Transport> getTransportByCategory(Category category);
    List<Transport> get();

}
