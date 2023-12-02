package lk.ijse.carServiceCenter.model;

import com.jfoenix.controls.JFXButton;
import lk.ijse.carServiceCenter.db.DbConnection;
import lk.ijse.carServiceCenter.dto.DetailsDto;
import lk.ijse.carServiceCenter.dto.tm.DetailsTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDetailsModel {
    public List<DetailsTm> getAllDetails() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = 	"SELECT c.customerName, c.customerNIC, r.repairType, r.repairPrice, i.partName, i.partPrice " +
                "FROM customer c " +
                "JOIN repaircar r ON c.customerNIC = r.customerNIC " +
                "JOIN repairitem ri ON r.repairId = ri.repairId " +
                "JOIN itemstock i ON ri.itemId = i.itemId";

        PreparedStatement pstm = connection.prepareStatement(sql);
        List<DetailsTm> dtoList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();

        while (resultSet.next()) {

           String customerName = resultSet.getString(1);
           String customerNIC = resultSet.getString(2);
            String repairType =  resultSet.getString(3);
            double repairPrice =  resultSet.getDouble(4);
            String partName =  resultSet.getString(5);
            double partPrice =  resultSet.getDouble(6);

            var dto = new DetailsTm(customerName, customerNIC, repairType, repairPrice, partName, partPrice,(partPrice + repairPrice),new JFXButton());
            dtoList.add(dto);
        }
        return dtoList;
    }

//    public List<DetailsTm> getAllDetails1() throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = 	"SELECT c.customerName, c.customerNIC, r.repairType, r.repairPrice, i.partName, i.partPrice " +
//                "FROM customer c " +
//                "JOIN repaircar r ON c.customerNIC = r.customerNIC " +
//                "JOIN repairitem ri ON r.repairId = ri.repairId " +
//                "JOIN itemstock i ON ri.itemId = i.itemId";
//
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        List<DetailsTm> dtoList = new ArrayList<>();
//
//        ResultSet resultSet = pstm.executeQuery();
//
//        while (resultSet.next()) {
//
//            String customerName = resultSet.getString(1);
//            String customerNIC = resultSet.getString(2);
//            String repairType =  resultSet.getString(3);
//            double repairPrice =  resultSet.getDouble(4);
//            String partName =  resultSet.getString(5);
//            double partPrice =  resultSet.getDouble(6);
//
//            var dto = new DetailsTm(customerName, customerNIC, repairType, repairPrice, partName, partPrice);
//            dtoList.add(dto);
//        }
//        return dtoList;
//    }
}
