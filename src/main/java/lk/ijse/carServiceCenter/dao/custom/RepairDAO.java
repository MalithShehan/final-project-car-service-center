package lk.ijse.carServiceCenter.dao.custom;

import lk.ijse.carServiceCenter.dao.CrudDAO;
import lk.ijse.carServiceCenter.db.DbConnection;
import lk.ijse.carServiceCenter.dto.RepairDto;
import lk.ijse.carServiceCenter.entity.Repair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RepairDAO extends CrudDAO<Repair> {

}
