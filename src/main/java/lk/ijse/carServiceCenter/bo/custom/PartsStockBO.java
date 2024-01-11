package lk.ijse.carServiceCenter.bo.custom;

import lk.ijse.carServiceCenter.bo.SuperBO;
import lk.ijse.carServiceCenter.dto.AddPartsStockDto;
import lk.ijse.carServiceCenter.entity.PartsStock;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PartsStockBO extends SuperBO {

    boolean savePartsStock(AddPartsStockDto dto) throws SQLException, ClassNotFoundException ;

    void deletePartsStock(String id) throws SQLException, ClassNotFoundException;

    ArrayList<AddPartsStockDto> getAllPartsStock() throws SQLException, ClassNotFoundException ;

    boolean updatePartsStock(AddPartsStockDto dto) throws SQLException, ClassNotFoundException ;
}
