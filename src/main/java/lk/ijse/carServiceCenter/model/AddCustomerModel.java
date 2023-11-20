package lk.ijse.carServiceCenter.model;


import lk.ijse.carServiceCenter.db.DbConnection;
import lk.ijse.carServiceCenter.dto.AddCustomerDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class AddCustomerModel {
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



    public boolean updateCustomer(AddCustomerDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE customer SET customerName = ?, address = ?, tel = ?, email = ? WHERE customerNIC = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getCustomerName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, dto.getTel());
        pstm.setString(4, dto.getEmail());
        pstm.setString(5, dto.getCustomerNIC());

        return pstm.executeUpdate() > 0;
    }

    public List<AddCustomerDto> getAllCustomers() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM customer";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<AddCustomerDto> dtoList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();

        while (resultSet.next()) {
            String cus_NIC = resultSet.getString(1);
            String cus_name = resultSet.getString(2);
            String cus_address = resultSet.getString(3);
            String cus_tell = resultSet.getString(4);
            String cus_email = resultSet.getString(5);
            Date date = resultSet.getDate(6);

            var dto = new AddCustomerDto(cus_NIC, cus_name, cus_address, cus_tell, cus_email, date );
            dtoList.add(dto);
        }
        return dtoList;
    }

    public static boolean deleteCustomer(String nic) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql =  "DELETE FROM customer WHERE customerNIC = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1 , nic);

        return pstm.executeUpdate() > 0;
    }

    public AddCustomerDto searchCustomer(String nic) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM customer WHERE customerNIC = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, nic);

        ResultSet resultSet = pstm.executeQuery();

        AddCustomerDto dto = null;

        if (resultSet.next()) {
            String cus_name = resultSet.getString(1);
            String cus_NIC = resultSet.getString(2);
            String cus_address = resultSet.getString(3);
            String cus_tel = resultSet.getString(4);
            String cus_email = resultSet.getString(5);
            Date date = resultSet.getDate(6);

            dto = new AddCustomerDto(cus_name, cus_NIC, cus_address, cus_tel, cus_email, date);
        }
        return dto;
    }

    public List<AddCustomerDto> loadAllCustomers() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM customer";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        List<AddCustomerDto> custList = new ArrayList<>();

        while (resultSet.next()) {
            custList.add(new AddCustomerDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getDate(6)
            ));
        }
        return custList;
    }
}
