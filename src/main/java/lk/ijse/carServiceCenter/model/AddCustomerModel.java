package lk.ijse.carServiceCenter.model;

import jdk.internal.org.objectweb.asm.tree.InsnList;
import lk.ijse.carServiceCenter.db.DbConnection;
import lk.ijse.carServiceCenter.dto.AddCustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddCustomerModel {
    public boolean saveTask(AddCustomerDto addCustomerDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?)");

        pstm.setString(1, addCustomerDto.getCustomerNIC());
        pstm.setString(2, addCustomerDto.getCustomerName());
        pstm.setString(3, addCustomerDto.getAddress());
        pstm.setString(4, addCustomerDto.getTel());
        pstm.setString(5, addCustomerDto.getEmail());

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

            var dto = new AddCustomerDto(cus_NIC, cus_name, cus_address, cus_tell, cus_email);
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

            dto = new AddCustomerDto(cus_name, cus_NIC, cus_address, cus_tel, cus_email);
        }
        return dto;
    }
}
