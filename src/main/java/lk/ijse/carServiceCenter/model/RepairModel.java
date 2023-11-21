package lk.ijse.carServiceCenter.model;

import lk.ijse.carServiceCenter.db.DbConnection;
import lk.ijse.carServiceCenter.dto.RepairDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepairModel {
    public boolean saveRepair(RepairDto repairDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO repaircar VALUES (?,?,?,?)");

        pstm.setString(1, repairDto.getRepairId());
        pstm.setString(2, repairDto.getRepairType());
        pstm.setDouble(3, repairDto.getRepairPrice());
        pstm.setString(4, repairDto.getCustomerNIC());

        return pstm.executeUpdate() > 0;
    }

    public List<RepairDto> getAllRepairs() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM repaircar";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<RepairDto> dtoList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();

        while (resultSet.next()) {
            String repairId = resultSet.getString(1);
            String repairType = resultSet.getString(2);
            double repairPrice = resultSet.getDouble(3);
            String customerNIC = resultSet.getString(4);


            var dto = new RepairDto(repairId, repairType, repairPrice, customerNIC);
            dtoList.add(dto);
        }
        return dtoList;
    }

    public boolean deletePart(String repairId) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql =  "DELETE FROM repaircar WHERE repairId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1 , repairId);

        return pstm.executeUpdate() > 0;
    }

    public boolean updateRepair(RepairDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE repaircar SET repairType = ?, repairPrice = ? , customerNIC = ? WHERE repairId = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getRepairType());
        pstm.setDouble(2, dto.getRepairPrice());
        pstm.setString(3, dto.getCustomerNIC());
        pstm.setString(4, dto.getRepairId());

        return pstm.executeUpdate() > 0;
    }
}
