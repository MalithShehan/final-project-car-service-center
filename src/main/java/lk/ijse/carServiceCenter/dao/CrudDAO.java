package lk.ijse.carServiceCenter.dao;

import lk.ijse.carServiceCenter.dto.AddCustomerDto;
import lk.ijse.carServiceCenter.entity.Booking;
import lk.ijse.carServiceCenter.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDAO<T> extends SuperDAO {
    boolean save(T dto) throws SQLException, ClassNotFoundException;

    void delete(String Id) throws SQLException, ClassNotFoundException;

    ArrayList<T> loadAllId() throws SQLException ;

    boolean update(T dto) throws SQLException, ClassNotFoundException;

    T search(String id) throws SQLException, ClassNotFoundException;

    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

}
