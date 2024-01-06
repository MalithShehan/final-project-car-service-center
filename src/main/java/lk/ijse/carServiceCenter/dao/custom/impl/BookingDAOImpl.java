package lk.ijse.carServiceCenter.dao.custom.impl;

import lk.ijse.carServiceCenter.dao.SQLUtil;
import lk.ijse.carServiceCenter.dao.custom.BookingDAO;
import lk.ijse.carServiceCenter.entity.Booking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAOImpl implements BookingDAO {
    @Override
    public boolean update(Booking entity) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "UPDATE booking SET bookType = ?, customerNIC = ? ,date = ? WHERE bookId = ?";
//
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        pstm.setString(1, bookingDto.getBookType());
//        pstm.setString(2, bookingDto.getCustomerNIC());
//        pstm.setDate(3, bookingDto.getDate());
//        pstm.setString(4, bookingDto.getBookId());
//
//        return pstm.executeUpdate() > 0;
        return SQLUtil.execute("UPDATE booking SET bookType = ?, customerNIC = ? ,date = ? WHERE bookId = ?",
               entity.getBookType(),
               entity.getCustomerNIC(),
               entity.getDate(),
               entity.getBookId()
        );
    }

    @Override
    public Booking search(String id) throws SQLException {
        return null;
    }
    @Override
    public boolean save(Booking entity) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO booking VALUES (?,?,?,?)");
//
//        pstm.setString(1, bookingDto.getBookId());
//        pstm.setString(2, bookingDto.getBookType());
//        pstm.setString(3, bookingDto.getCustomerNIC());
//        pstm.setDate(4, bookingDto.getDate());
//
//        return pstm.executeUpdate() > 0;
        return SQLUtil.execute("INSERT INTO booking VALUES (?,?,?,?)",
                entity.getBookId(),
                entity.getBookType(),
                entity.getCustomerNIC(),
                entity.getDate()
        );
    }
    @Override
    public ArrayList<Booking> getAll() throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT * FROM booking";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//
//        List<BookingDto> dtoList = new ArrayList<>();
//
//        ResultSet resultSet = pstm.executeQuery();
//
//        while (resultSet.next()) {
//            String bookId = resultSet.getString(1);
//            String bookType = resultSet.getString(2);
//            String customerNIC = resultSet.getString(3);
//            Date date = resultSet.getDate(4);
//
//            var dto = new BookingDto(bookId, bookType, customerNIC, date);
//            dtoList.add(dto);
//        }
//        return dtoList;
        ResultSet rst = SQLUtil.execute("SELECT * FROM booking");
        ArrayList<Booking> allBooking = new ArrayList<>();

        while (rst.next()) {
            Booking booking = new Booking(
                    rst.getString("BookId"),
                    rst.getString("bookType"),
                    rst.getString("customerNIC"),
                    rst.getDate("date")
            );
        }
        return allBooking;
    }
    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql =  "DELETE FROM booking WHERE bookId = ?";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1 , bookId);
//
//        return pstm.executeUpdate() > 0;
        ResultSet rst = SQLUtil.execute("DELETE FROM booking WHERE bookId = ?", id);
    }

    @Override
    public ArrayList<Booking> loadAllId() throws SQLException {
        return null;
    }
}
