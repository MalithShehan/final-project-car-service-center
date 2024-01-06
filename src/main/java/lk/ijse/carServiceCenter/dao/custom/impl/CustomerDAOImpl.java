package lk.ijse.carServiceCenter.dao;

import lk.ijse.carServiceCenter.db.DbConnection;
import lk.ijse.carServiceCenter.dto.AddCustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDAOImpl implements CrudDAO{
    public static boolean saveCustomer(AddCustomerDto addCustomerDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?,?)");

        pstm.setString(1, addCustomerDto.getCustomerNIC());
        pstm.setString(2, addCustomerDto.getCustomerName());
        pstm.setString(3, addCustomerDto.getAddress());
        pstm.setString(4, addCustomerDto.getTel());
        pstm.setString(5, addCustomerDto.getEmail());
        pstm.setDate(6, addCustomerDto.getDate());

        return pstm.executeUpdate() > 0;
    }
}
