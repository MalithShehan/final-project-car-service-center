package lk.ijse.carServiceCenter.bo.custom;

import lk.ijse.carServiceCenter.bo.SuperBO;
import lk.ijse.carServiceCenter.dao.SQLUtil;
import lk.ijse.carServiceCenter.dto.RepairDto;
import lk.ijse.carServiceCenter.entity.Repair;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface RepairBO extends SuperBO {
    boolean saveRepair(RepairDto dto) throws SQLException, ClassNotFoundException ;

    ArrayList<RepairDto> getAllRepair() throws SQLException, ClassNotFoundException ;

    void deleteRepair(String id) throws SQLException, ClassNotFoundException ;

    boolean updateRepair(RepairDto dto) throws SQLException, ClassNotFoundException ;

}
