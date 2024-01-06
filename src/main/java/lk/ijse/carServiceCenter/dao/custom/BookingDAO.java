package lk.ijse.carServiceCenter.dao.custom;

import lk.ijse.carServiceCenter.dao.CrudDAO;
import lk.ijse.carServiceCenter.db.DbConnection;
import lk.ijse.carServiceCenter.dto.BookingDto;
import lk.ijse.carServiceCenter.entity.Booking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface BookingDAO extends CrudDAO<Booking> {
}
