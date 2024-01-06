package lk.ijse.carServiceCenter.dao.custom;

import lk.ijse.carServiceCenter.dao.CrudDAO;
import lk.ijse.carServiceCenter.db.DbConnection;
import lk.ijse.carServiceCenter.dto.RegisterDto;
import lk.ijse.carServiceCenter.entity.Register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface RegisterDAO extends CrudDAO<Register> {
}
