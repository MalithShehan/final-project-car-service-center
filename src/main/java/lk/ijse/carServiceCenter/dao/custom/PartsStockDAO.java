package lk.ijse.carServiceCenter.dao.custom;

import lk.ijse.carServiceCenter.dao.CrudDAO;
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

public interface PartsStockDAO extends CrudDAO<PartsStock> {

}
