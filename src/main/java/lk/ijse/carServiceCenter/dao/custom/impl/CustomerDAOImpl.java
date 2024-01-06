package lk.ijse.carServiceCenter.dao.custom.impl;

import lk.ijse.carServiceCenter.dao.SQLUtil;
import lk.ijse.carServiceCenter.dao.custom.CustomerDAO;
import lk.ijse.carServiceCenter.dto.AddCustomerDto;
import lk.ijse.carServiceCenter.entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?,?)");
//
//        pstm.setString(1, addCustomerDto.getCustomerNIC());
//        pstm.setString(2, addCustomerDto.getCustomerName());
//        pstm.setString(3, addCustomerDto.getAddress());
//        pstm.setString(4, addCustomerDto.getTel());
//        pstm.setString(5, addCustomerDto.getEmail());
//        pstm.setDate(6, addCustomerDto.getDate());
//
//        return pstm.executeUpdate() > 0;
        return SQLUtil.execute("INSERT INTO customer VALUES (?,?,?,?,?,?)",
                entity.getCustomerNIC(),
                entity.getCustomerName(),
                entity.getAddress(),
                entity.getTel(),
                entity.getEmail(),
                entity.getDate()
        );
    }
    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "UPDATE customer SET customerName = ?, address = ?, tel = ?, email = ? WHERE customerNIC = ?";
//
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1, dto.getCustomerName());
//        pstm.setString(2, dto.getAddress());
//        pstm.setString(3, dto.getTel());
//        pstm.setString(4, dto.getEmail());
//        pstm.setString(5, dto.getCustomerNIC());
//
//        return pstm.executeUpdate() > 0;
        return SQLUtil.execute("UPDATE customer SET customerName = ?, address = ?, tel = ?, email = ? WHERE customerNIC = ?",
                entity.getCustomerName(),
                entity.getAddress(),
                entity.getTel(),
                entity.getEmail(),
                entity.getCustomerNIC());
    }
    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> allCustomer =new ArrayList<>();
        ResultSet rst =SQLUtil.execute("SELECT * FROM customer");
        while (rst.next()) {
            allCustomer.add(new Customer(
                    rst.getString("customerNIC"),
                    rst.getString("customerName"),
                    rst.getString("address"),
                    rst.getString("tel"),
                    rst.getString("email"),
                    rst.getDate("date")
                )
            );
        }
        return allCustomer;
    }
    @Override
    public void delete(String nic) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql =  "DELETE FROM customer WHERE customerNIC = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1 , nic);
//
//        return pstm.executeUpdate() > 0;
        SQLUtil.execute("DELETE FROM customer WHERE customerNIC = ?", nic);

    }

    @Override
    public ArrayList<Customer> loadAllId() throws SQLException {
        return null;
    }

    @Override
    public Customer search(String nic) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT * FROM customer WHERE customerNIC = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, nic);
//
//        ResultSet resultSet = pstm.executeQuery();
//
//        AddCustomerDto dto = null;
//
//        if (resultSet.next()) {
//            String cus_name = resultSet.getString(1);
//            String cus_NIC = resultSet.getString(2);
//            String cus_address = resultSet.getString(3);
//            String cus_tel = resultSet.getString(4);
//            String cus_email = resultSet.getString(5);
//            Date date = resultSet.getDate(6);
//
//            dto = new AddCustomerDto(cus_name, cus_NIC, cus_address, cus_tel, cus_email, date);
//        }
//        return dto;
        ResultSet rst = SQLUtil.execute("SELECT * FROM customer WHERE customerNIC = ?", nic);
        rst.next();
        return new Customer(nic + "",
                rst.getString("customerName"),
                rst.getString("address"),
                rst.getString("tel"),
                rst.getString("email"),
                rst.getDate("date")
        );
    }


//    @Override
//    public ArrayList<Customer> loadAll() throws SQLException {
////        Connection connection = DbConnection.getInstance().getConnection();
////
////        String sql = "SELECT * FROM customer";
////        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();
////
////        List<AddCustomerDto> custList = new ArrayList<>();
////
////        while (resultSet.next()) {
////            custList.add(new AddCustomerDto(
////                    resultSet.getString(1),
////                    resultSet.getString(2),
////                    resultSet.getString(3),
////                    resultSet.getString(4),
////                    resultSet.getString(5),
////                    resultSet.getDate(6)
////            ));
////        }
////        return custList;
//
//    }
}
