package lk.ijse.carServiceCenter.bo.custom.impl;

import lk.ijse.carServiceCenter.bo.custom.BookingBO;
import lk.ijse.carServiceCenter.dao.DAOFactory;
import lk.ijse.carServiceCenter.dao.custom.BookingDAO;
import lk.ijse.carServiceCenter.dto.BookingDto;
import lk.ijse.carServiceCenter.entity.Booking;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookingBOImpl implements BookingBO {

    BookingDAO bookingDAO = (BookingDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOKING);

    @Override
    public boolean updateBooking(BookingDto dto) throws SQLException, ClassNotFoundException {
        return bookingDAO.update(new Booking(dto.getBookId(),
                dto.getBookType(),
                dto.getCustomerNIC(),
                dto.getDate())
        );
    }

    @Override
    public boolean saveBokking(BookingDto dto) throws SQLException, ClassNotFoundException {
        return bookingDAO.save(new Booking(dto.getBookId(),
                dto.getBookType(),
                dto.getCustomerNIC(),
                dto.getDate())
        );
    }

    @Override
    public ArrayList<BookingDto> getAllBokkings() throws SQLException, ClassNotFoundException {
        ArrayList<Booking> bookings = bookingDAO.getAll();
        ArrayList<BookingDto> bookingDtos = new ArrayList<>();
        for (Booking booking : bookings) {
                bookingDtos.add(new BookingDto(booking.getBookId(),
                        booking.getBookType(),
                        booking.getCustomerNIC(),
                        booking.getDate())
                );
        }
        return bookingDtos;
    }

    @Override
    public void deleteBooking(String id) throws SQLException, ClassNotFoundException {
        bookingDAO.delete(id);
    }
}
