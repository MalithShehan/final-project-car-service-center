package lk.ijse.carServiceCenter.dao.custom.impl;

import lk.ijse.carServiceCenter.dao.SQLUtil;
import lk.ijse.carServiceCenter.dao.custom.RepairDAO;
import lk.ijse.carServiceCenter.db.DbConnection;
import lk.ijse.carServiceCenter.dto.RepairDto;
import lk.ijse.carServiceCenter.entity.Repair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepairDAOImpl implements RepairDAO {
    @Override
    public boolean save(Repair entity) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
////
////        PreparedStatement pstm = connection.prepareStatement("INSERT INTO repaircar VALUES (?,?,?,?)");
////
////        pstm.setString(1, repairDto.getRepairId());
////        pstm.setString(2, repairDto.getRepairType());
////        pstm.setDouble(3, repairDto.getRepairPrice());
////        pstm.setString(4, repairDto.getCustomerNIC());
////
////        return pstm.executeUpdate() > 0;
        return SQLUtil.execute("INSERT INTO repaircar VALUES (?,?,?,?)",
                entity.getRepairId(),
                entity.getRepairType(),
                entity.getRepairPrice(),
                entity.getCustomerNIC()
        );
    }

    @Override
    public ArrayList<Repair> getAll() throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT * FROM repaircar";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        List<RepairDto> dtoList = new ArrayList<>();
//
//        ResultSet resultSet = pstm.executeQuery();
//
//        while (resultSet.next()) {
//            String repairId = resultSet.getString(1);
//            String repairType = resultSet.getString(2);
//            double repairPrice = resultSet.getDouble(3);
//            String customerNIC = resultSet.getString(4);
//
//
//            var dto = new RepairDto(repairId, repairType, repairPrice, customerNIC);
//            dtoList.add(dto);
//        }
//        return dtoList;
        ResultSet rst = SQLUtil.execute("SELECT * FROM repaircar");
        ArrayList<Repair> allRepair = new ArrayList<>();

        while (rst.next()) {
            Repair repair = new Repair(
                    rst.getString("repairId"),
                    rst.getString("repairType"),
                    rst.getDouble("repairPrice"),
                    rst.getString("customerNIC")
            );
            allRepair.add(repair);
        }
        return allRepair;
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql =  "DELETE FROM repaircar WHERE repairId = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1 , repairId);
//
//        return pstm.executeUpdate() > 0;
        SQLUtil.execute("DELETE FROM repaircar WHERE repairId = ?", id);
    }

    @Override
    public ArrayList<Repair> loadAllId() throws SQLException {
        return null;
    }

    @Override
    public boolean update(Repair entity) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "UPDATE repaircar SET repairType = ?, repairPrice = ? , customerNIC = ? WHERE repairId = ?";
//
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1, dto.getRepairType());
//        pstm.setDouble(2, dto.getRepairPrice());
//        pstm.setString(3, dto.getCustomerNIC());
//        pstm.setString(4, dto.getRepairId());
//
//        return pstm.executeUpdate() > 0;
        return SQLUtil.execute("UPDATE repaircar SET repairType = ?, repairPrice = ? , customerNIC = ? WHERE repairId = ?",
                entity.getRepairType(),
                entity.getRepairPrice(),
                entity.getCustomerNIC(),
                entity.getRepairId()
        );
    }

    @Override
    public Repair search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
