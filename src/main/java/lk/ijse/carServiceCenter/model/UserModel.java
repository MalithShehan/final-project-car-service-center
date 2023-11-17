package lk.ijse.carServiceCenter.model;

import lk.ijse.carServiceCenter.db.DbConnection;
import lk.ijse.carServiceCenter.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
    public static boolean saveUser(UserDto userDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO login VALUES (?,?,?,?) ");

        pstm.setString(1,userDto.getFirstName());
        pstm.setString(2,userDto.getLastName());
        pstm.setString(3,userDto.getUserName());
        pstm.setString(4,userDto.getPassword());

        return pstm.executeUpdate() > 0;
    }
}
