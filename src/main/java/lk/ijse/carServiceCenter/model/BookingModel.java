package lk.ijse.carServiceCenter.model;

import lk.ijse.carServiceCenter.db.DbConnection;
import lk.ijse.carServiceCenter.dto.BookingDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<BookingDto> getAllBookings() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM booking";
        PreparedStatement pstm = connection.prepareStatement(sql);

        List<BookingDto> dtoList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();

        while (resultSet.next()) {
            String bookId = resultSet.getString(1);
            String bookType = resultSet.getString(2);
            String customerNIC = resultSet.getString(3);
            Date date = resultSet.getDate(4);

            var dto = new BookingDto(bookId, bookType, customerNIC, date);
            dtoList.add(dto);
        }
        return dtoList;
    }

    public boolean deleteBooking(String bookId) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql =  "DELETE FROM booking WHERE bookId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1 , bookId);

        return pstm.executeUpdate() > 0;
    }
}
