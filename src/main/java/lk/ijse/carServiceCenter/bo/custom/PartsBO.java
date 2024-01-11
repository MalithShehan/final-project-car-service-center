package lk.ijse.carServiceCenter.bo.custom;

import lk.ijse.carServiceCenter.bo.SuperBO;
import lk.ijse.carServiceCenter.dto.AddPartsDto;
import lk.ijse.carServiceCenter.entity.Parts;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PartsBO extends SuperBO {
    boolean savePart(AddPartsDto dto) throws SQLException, ClassNotFoundException ;

    void deletePart(String id) throws SQLException, ClassNotFoundException ;

    boolean updatePart(AddPartsDto dto) throws SQLException, ClassNotFoundException ;

    ArrayList<AddPartsDto> getAllPart() throws SQLException, ClassNotFoundException ;
}
