package lk.ijse.carServiceCenter.bo.custom;

import lk.ijse.carServiceCenter.dto.AddCustomerDto;
import lk.ijse.carServiceCenter.bo.SuperBO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO{
    boolean saveCustomer(AddCustomerDto dto) throws SQLException, ClassNotFoundException ;

    boolean updateCustomer(AddCustomerDto dto) throws SQLException, ClassNotFoundException ;

    ArrayList<AddCustomerDto> getAllCustomer() throws SQLException, ClassNotFoundException ;

    void deleteCustomer(String nic) throws SQLException, ClassNotFoundException ;

    AddCustomerDto searchCustomer(String nic) throws SQLException, ClassNotFoundException ;
}
