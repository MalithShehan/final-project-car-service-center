package lk.ijse.carServiceCenter.bo.custom;

import lk.ijse.carServiceCenter.bo.SuperBO;
import lk.ijse.carServiceCenter.dto.BookingDto;
import lk.ijse.carServiceCenter.entity.Booking;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BookingBO extends SuperBO {
    boolean updateBooking(BookingDto dto) throws SQLException, ClassNotFoundException ;

    boolean saveBokking(BookingDto dto) throws SQLException, ClassNotFoundException ;

    ArrayList<BookingDto> getAllBokkings() throws SQLException, ClassNotFoundException ;

    void deleteBooking(String id) throws SQLException, ClassNotFoundException ;

}
