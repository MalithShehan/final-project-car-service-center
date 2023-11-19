package lk.ijse.carServiceCenter.model;

import lk.ijse.carServiceCenter.db.DbConnection;
import lk.ijse.carServiceCenter.dto.RegisterDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterModel {

    public static boolean searchUser(String userName, String password) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM login WHERE userName=? AND password=?");

        pstm.setString(1, userName);
        pstm.setString(2, password);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            return true;
        }
        return false;
    }

    public boolean saveUser(RegisterDto registerDto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO login VALUES (?,?,?,?)");

        pstm.setString(1, registerDto.getFirstName());
        pstm.setString(2, registerDto.getLastName());
        pstm.setString(3, registerDto.getUserName());
        pstm.setString(4, registerDto.getPassword());

        return pstm.executeUpdate() > 0;
    }
}
