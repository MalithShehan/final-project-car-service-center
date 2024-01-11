package lk.ijse.carServiceCenter.dao.custom.impl;

import com.jfoenix.controls.JFXButton;
import lk.ijse.carServiceCenter.dao.SQLUtil;
import lk.ijse.carServiceCenter.dao.custom.ServiceDetailsDAO;
import lk.ijse.carServiceCenter.db.DbConnection;
import lk.ijse.carServiceCenter.dto.tm.DetailsTm;
import lk.ijse.carServiceCenter.entity.ServiceDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDetailsDAOImpl implements ServiceDetailsDAO {
    @Override
    public boolean save(ServiceDetails dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void delete(String Id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public ArrayList<ServiceDetails> loadAllId() throws SQLException {
        return null;
    }

    @Override
    public boolean update(ServiceDetails dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ServiceDetails search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    public ArrayList<ServiceDetails> getAll() throws SQLException, ClassNotFoundException {
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
//            var dto = new DetailsTm(customerName, customerNIC, repairType, repairPrice, partName, partPrice,(partPrice + repairPrice),new JFXButton());
//            dtoList.add(dto);
//        }
//        return dtoList;
        ResultSet rst = SQLUtil.execute("SELECT c.customerName, c.customerNIC, r.repairType, r.repairPrice, i.partName, i.partPrice " +
                "FROM customer c " +
                "JOIN repaircar r ON c.customerNIC = r.customerNIC " +
                "JOIN repairitem ri ON r.repairId = ri.repairId " +
                "JOIN itemstock i ON ri.itemId = i.itemId");
        ArrayList<ServiceDetails> allService = new ArrayList<>();

        while (rst.next()) {
            ServiceDetails serviceDetails = new ServiceDetails(
                    rst.getString("customerName"),
                    rst.getString("customerNIC"),
                    rst.getString("repairType"),
                    rst.getDouble("repairPrice"),
                    rst.getString("partName"),
                    rst.getDouble("partPrice")
            );
            allService.add(serviceDetails);
        }
        return allService;
    }
}
