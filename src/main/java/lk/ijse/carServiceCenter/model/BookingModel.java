package lk.ijse.carServiceCenter.model;

import lk.ijse.carServiceCenter.db.DbConnection;
import lk.ijse.carServiceCenter.dto.BookingDto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingModel {

    public static boolean updateBooking(BookingDto bookingDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE booking SET bookType = ?, customerNIC = ? ,date = ? WHERE bookId = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, bookingDto.getBookType());
        pstm.setString(2, bookingDto.getCustomerNIC());
        pstm.setDate(3, bookingDto.getDate());
        pstm.setString(4, bookingDto.getBookId());

        return pstm.executeUpdate() > 0;
    }

    public boolean saveBooking(BookingDto bookingDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO booking VALUES (?,?,?,?)");

        pstm.setString(1, bookingDto.getBookId());
        pstm.setString(2, bookingDto.getBookType());
        pstm.setString(3, bookingDto.getCustomerNIC());
        pstm.setDate(4, bookingDto.getDate());

        return pstm.executeUpdate() > 0;
    }
}
