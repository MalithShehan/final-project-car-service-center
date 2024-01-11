package lk.ijse.carServiceCenter.bo.custom;

import lk.ijse.carServiceCenter.bo.SuperBO;
import lk.ijse.carServiceCenter.dao.SQLUtil;
import lk.ijse.carServiceCenter.dto.DetailsDto;
import lk.ijse.carServiceCenter.entity.ServiceDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ServiceDetailsBO extends SuperBO {
    public ArrayList<DetailsDto> getAllServiceDetails() throws SQLException, ClassNotFoundException ;
}
