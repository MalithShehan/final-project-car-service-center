package lk.ijse.carServiceCenter.model;

import lk.ijse.carServiceCenter.db.DbConnection;
import lk.ijse.carServiceCenter.dto.DetailsDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDetails {
    public List<DetailsDto> getAllDetails() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = 	"SELECT c.customerName, c.customerNIC, r.repairType, r.repairPrice, i.partName FROM customer c JOIN repairCar r ON c.customerNIC = r.customerNIC JOIN repairItem ri ON r.repairId = ri.repairId  JOIN itemStock i ON ri.itemId = i.itemId";
        PreparedStatement pstm = connection.prepareStatement(sql);
        List<DetailsDto> dtoList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();

        while (resultSet.next()) {
            var dto = new DetailsDto(
           resultSet.getString(1),
             resultSet.getString(2),
            resultSet.getString(3),
             resultSet.getDouble(4),
             resultSet.getString(5),
             resultSet.getDouble(6)
        );
            dtoList.add(dto);
        }
        return dtoList;
    }
}
