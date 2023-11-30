package lk.ijse.carServiceCenter.model;

import lk.ijse.carServiceCenter.db.DbConnection;
import lk.ijse.carServiceCenter.dto.AddPartsDto;
import lk.ijse.carServiceCenter.dto.AddPartsStockDto;
import lk.ijse.carServiceCenter.dto.tm.AddPartsTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.carServiceCenter.db.DbConnection;
import lk.ijse.carServiceCenter.dto.AddPartsDto;
import lk.ijse.carServiceCenter.dto.AddPartsStockDto;
import lk.ijse.carServiceCenter.dto.tm.AddPartsTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddPartsStockModel {
    public static boolean saveParts(AddPartsStockDto addPartsStockDtoDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO itemstock VALUES(?, ?, ?, ?)";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, addPartsStockDtoDto.getItemId());
        pstm.setString(2, addPartsStockDtoDto.getPartName());
        pstm.setString(3, addPartsStockDtoDto.getPartPrice());
        pstm.setInt(4, addPartsStockDtoDto.getQtyOnHand());


        return pstm.executeUpdate() > 0;
    }



    public static boolean deleteItem(String itemId) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM itemstock WHERE itemId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, itemId);

        return pstm.executeUpdate() > 0;

    }

    public static List<AddPartsStockDto> loadAllPartsId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM itemstock";
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

        List<AddPartsStockDto> partList = new ArrayList<>();

        while (resultSet.next()) {
            partList.add(new AddPartsStockDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)
            ));

        }
        return partList;
    }

    public boolean updateParts(AddPartsStockDto addPartsStockDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE itemstock SET partName = ?, partPrice = ?, qtyOnHand = ? WHERE itemId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, addPartsStockDto.getPartName());
        pstm.setString(2, addPartsStockDto.getPartPrice());
        pstm.setInt(3, addPartsStockDto.getQtyOnHand());
        pstm.setString(4, addPartsStockDto.getItemId());

        return pstm.executeUpdate() > 0;
    }

    public List<AddPartsStockDto> loadAllParts() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM itemStock";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<AddPartsStockDto> dtoList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();

        while (resultSet.next()) {
            String itemId  = resultSet.getString(1);
            String partName = resultSet.getString(2);
            String partPrice = resultSet.getString(3);
            int qtyOnHand = resultSet.getInt(4);

            var dto = new AddPartsStockDto(itemId, partName, partPrice, qtyOnHand);
            dtoList.add(dto);
        }
        return dtoList;
    }

    public boolean updateParts(List<AddPartsTm> tmList) throws SQLException {
        for (AddPartsTm partsTm : tmList) {
            if (!updateQty(partsTm)) {
                return false;
            }
        }
        return true;
    }

    private boolean updateQty(AddPartsTm partsTm) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE itemstock SET qtyOnHand = qtyOnHand - ? WHERE itemId = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, partsTm.getQuantity());
        pstm.setString(2, partsTm.getItemId());

        return pstm.executeUpdate() > 0;
    }
    public static void delete(String Id,String Nqty) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql ="SELECT qtyOnHand FROM itemstock WHERE itemId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,Id);

        ResultSet resultSet = preparedStatement.executeQuery();
        int qty=0;
        while (resultSet.next()){
            qty = resultSet.getInt(1);
        }

        int newQty = qty-Integer.parseInt(Nqty);

        update(Id,newQty);

    }

    private static void update(String id, int newQty) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql ="UPDATE itemstock set qtyOnHand = ? WHERE itemId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,newQty);
        preparedStatement.setString(2,id);

        preparedStatement.executeUpdate();

    }
}
