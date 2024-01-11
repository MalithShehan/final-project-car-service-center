package lk.ijse.carServiceCenter.dao.custom.impl;

import lk.ijse.carServiceCenter.dao.SQLUtil;
import lk.ijse.carServiceCenter.dao.custom.PartsDAO;
import lk.ijse.carServiceCenter.entity.Parts;
import lk.ijse.carServiceCenter.entity.PartsStock;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PartsDAOImpl implements PartsDAO {

    @Override
    public boolean save(Parts entity) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "INSERT INTO item VALUES(?, ?, ?, ?)";
//
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1, addPartsDto.getItemId());
//        pstm.setString(2, addPartsDto.getItemName());
//        pstm.setDouble(3, addPartsDto.getItemPrice());
//        pstm.setInt(4, addPartsDto.getQuantity());
//
//        return pstm.executeUpdate() > 0;
        return SQLUtil.execute("INSERT INTO item VALUES(?, ?, ?, ?)",
                entity.getItemId(),
                entity.getItemName(),
                entity.getItemPrice(),
                entity.getQuantity()
        );
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "DELETE FROM item WHERE itemId = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, itemId);
//
//        return pstm.executeUpdate() > 0;
        SQLUtil.execute("DELETE FROM item WHERE itemId = ?", id);
    }

    @Override
    public ArrayList<Parts> loadAllId() throws SQLException {
        return null;
    }

    @Override
    public boolean update(Parts entity) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "UPDATE item SET itemName = ?, itemPrice = ?, quantity = ? WHERE itemId = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1, addPartsDto.getItemName());
//        pstm.setDouble(2, addPartsDto.getItemPrice());
//        pstm.setInt(3, addPartsDto.getQuantity());
//        pstm.setString(4, addPartsDto.getItemId());
//
//        return pstm.executeUpdate() > 0;
        return SQLUtil.execute("UPDATE item SET itemName = ?, itemPrice = ?, quantity = ? WHERE itemId = ?",
                entity.getItemName(),
                entity.getItemPrice(),
                entity.getQuantity(),
                entity.getItemId()
        );
    }

    @Override
    public Parts search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Parts> getAll() throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT * FROM item";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        List<AddPartsDto> dtoList = new ArrayList<>();
//
//        ResultSet resultSet = pstm.executeQuery();
//
//        while (resultSet.next()) {
//            String itemId = resultSet.getString(1);
//            String itemName = resultSet.getString(2);
//            double itemPrice = resultSet.getDouble(3);
//            int quantity = resultSet.getInt(4);
//
//            var dto = new AddPartsDto(itemId, itemName, itemPrice, quantity);
//            dtoList.add(dto);
//        }
//        return dtoList;
        ResultSet rst = SQLUtil.execute("SELECT * FROM item");
        ArrayList<Parts> allParts = new ArrayList<>();

        while (rst.next()) {
            Parts parts = new Parts(
                    rst.getString("itemId"),
                    rst.getString("itemName"),
                    rst.getDouble("itemPrice"),
                    rst.getInt("quantity")
            );
            allParts.add(parts);
        }
        return allParts;
    }

//    @Override
//    public PartsStock search(String id) throws SQLException, ClassNotFoundException {
////        Connection connection = DbConnection.getInstance().getConnection();
////
////        String sql = "SELECT * FROM itemstock WHERE itemId = ?";
////        PreparedStatement pstm = connection.prepareStatement(sql);
////        pstm.setString(1, partId);
////
////        ResultSet resultSet = pstm.executeQuery();
////
////        AddPartsStockDto dto = null;
////
////        if (resultSet.next()) {
////            String itemId = resultSet.getString(1);
////            String partName = resultSet.getString(2);
////            String partPrice = resultSet.getString(3);
////            int qtyOnHand = resultSet.getInt(4);
////
////            dto = new AddPartsStockDto(itemId, partName, partPrice, qtyOnHand);
////        }
////        return dto;
//        ResultSet rst = SQLUtil.execute("SELECT * FROM itemstock WHERE itemId = ?", id);
//        rst.next();
//        return new PartsStock(id+ "",
//                rst.getString("partName"),
//                rst.getString("partPrice"),
//                rst.getInt("qtyOnHand")
//        );
//    }
}
