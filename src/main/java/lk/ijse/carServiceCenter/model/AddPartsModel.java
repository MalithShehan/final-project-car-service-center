package lk.ijse.carServiceCenter.model;

import lk.ijse.carServiceCenter.db.DbConnection;
import lk.ijse.carServiceCenter.dto.AddCustomerDto;
import lk.ijse.carServiceCenter.dto.AddPartsDto;
import lk.ijse.carServiceCenter.dto.RepairDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddPartsModel {
    public static boolean saveParts(AddPartsDto addPartsDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO item VALUES(?, ?, ?, ?)";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, addPartsDto.getItemId());
        pstm.setString(2, addPartsDto.getItemName());
        pstm.setDouble(3, addPartsDto.getItemPrice());
        pstm.setInt(4, addPartsDto.getQuantity());

        return pstm.executeUpdate() > 0;
    }

    public static boolean deleteItem(String itemId) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM item WHERE itemId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, itemId);

        return pstm.executeUpdate() > 0;
    }

    public boolean updateItem(AddPartsDto addPartsDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE item SET itemName = ?, itemPrice = ?, quantity = ? WHERE itemId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, addPartsDto.getItemName());
        pstm.setDouble(2, addPartsDto.getItemPrice());
        pstm.setInt(3, addPartsDto.getQuantity());
        pstm.setString(4, addPartsDto.getItemId());

        return pstm.executeUpdate() > 0;
    }

    public List<AddPartsDto> loadAllItems() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM item";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<AddPartsDto> dtoList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();

        while (resultSet.next()) {
            String itemId = resultSet.getString(1);
            String itemName = resultSet.getString(2);
            double itemPrice = resultSet.getDouble(3);
            int quantity = resultSet.getInt(4);

            var dto = new AddPartsDto(itemId, itemName, itemPrice, quantity);
            dtoList.add(dto);
        }
        return dtoList;
    }
}
