package lk.ijse.carServiceCenter.bo.custom;

import lk.ijse.carServiceCenter.bo.SuperBO;
import lk.ijse.carServiceCenter.dao.SQLUtil;
import lk.ijse.carServiceCenter.dto.RegisterDto;
import lk.ijse.carServiceCenter.entity.Register;

import java.sql.SQLException;

public interface RegisterBO extends SuperBO {
    boolean saveRegister(RegisterDto dto) throws SQLException, ClassNotFoundException ;
}
