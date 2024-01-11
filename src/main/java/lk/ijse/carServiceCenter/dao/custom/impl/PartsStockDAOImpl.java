package lk.ijse.carServiceCenter.dao.custom.impl;

import lk.ijse.carServiceCenter.dao.SQLUtil;
import lk.ijse.carServiceCenter.dao.custom.PartsStockDAO;
import lk.ijse.carServiceCenter.db.DbConnection;
import lk.ijse.carServiceCenter.dto.AddPartsStockDto;
import lk.ijse.carServiceCenter.dto.tm.AddPartsTm;
import lk.ijse.carServiceCenter.entity.PartsStock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartsStockDAOImpl implements PartsStockDAO {
    @Override
    public boolean save(PartsStock entity) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        String sql = "INSERT INTO itemstock VALUES(?, ?, ?, ?)";
//
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1, addPartsStockDtoDto.getItemId());
//        pstm.setString(2, addPartsStockDtoDto.getPartName());
//        pstm.setString(3, addPartsStockDtoDto.getPartPrice());
//        pstm.setInt(4, addPartsStockDtoDto.getQtyOnHand());
//
//
//        return pstm.executeUpdate() > 0;
        return SQLUtil.execute("INSERT INTO itemstock VALUES(?, ?, ?, ?)",
                entity.getItemId(),
                entity.getPartName(),
                entity.getPartPrice(),
                entity.getQtyOnHand()
                );
    }
    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "DELETE FROM itemstock WHERE itemId = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, itemId);
//
//        return pstm.executeUpdate() > 0;
        SQLUtil.execute("DELETE FROM itemstock WHERE itemId = ?", id);

    }

    @Override
    public ArrayList<PartsStock> loadAllId() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<PartsStock> getAll() throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT * FROM itemstock";
//        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();
//
//        List<AddPartsStockDto> partList = new ArrayList<>();
//
//        while (resultSet.next()) {
//            partList.add(new AddPartsStockDto(
//                    resultSet.getString(1),
//                    resultSet.getString(2),
//                    resultSet.getString(3),
//                    resultSet.getInt(4)
//            ));
//
//        }
//        return partList;
            ResultSet rst = SQLUtil.execute("SELECT * FROM itemstock");
            ArrayList<PartsStock> allParts = new ArrayList<>();
            while (rst.next()) {
                PartsStock partsStock = new PartsStock(
                        rst.getString("itemId"),
                        rst.getString("partName"),
                        rst.getString("partPrice"),
                        rst.getInt("qtyOnHand")
                );
                allParts.add(partsStock);
            }
            return allParts;
    }

    @Override
    public boolean update(PartsStock entity) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "UPDATE itemstock SET partName = ?, partPrice = ?, qtyOnHand = ? WHERE itemId = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1, addPartsStockDto.getPartName());
//        pstm.setString(2, addPartsStockDto.getPartPrice());
//        pstm.setInt(3, addPartsStockDto.getQtyOnHand());
//        pstm.setString(4, addPartsStockDto.getItemId());
//
//        return pstm.executeUpdate() > 0;
        return SQLUtil.execute("UPDATE itemstock SET partName = ?, partPrice = ?, qtyOnHand = ? WHERE itemId = ?",
                entity.getPartName(),
                entity.getPartPrice(),
                entity.getQtyOnHand(),
                entity.getItemId()
        );
    }

    @Override
    public PartsStock search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

//    @Override
//    public ArrayList<PartsStock> getAll() throws SQLException, ClassNotFoundException {
////        Connection connection = DbConnection.getInstance().getConnection();
////
////        String sql = "SELECT * FROM itemStock";
////        PreparedStatement pstm = connection.prepareStatement(sql);
////
////        List<AddPartsStockDto> dtoList = new ArrayList<>();
////
////        ResultSet resultSet = pstm.executeQuery();
////
////        while (resultSet.next()) {
////            String itemId  = resultSet.getString(1);
////            String partName = resultSet.getString(2);
////            String partPrice = resultSet.getString(3);
////            int qtyOnHand = resultSet.getInt(4);
////
////            var dto = new AddPartsStockDto(itemId, partName, partPrice, qtyOnHand);
////            dtoList.add(dto);
////        }
////        return dtoList;
//        ResultSet rst = SQLUtil.execute("SELECT * FROM itemStock");
//        ArrayList<PartsStock> allP
//    }

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
