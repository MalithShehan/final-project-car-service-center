package lk.ijse.carServiceCenter.dao.custom.impl;

import lk.ijse.carServiceCenter.dao.SQLUtil;
import lk.ijse.carServiceCenter.dao.custom.RegisterDAO;
import lk.ijse.carServiceCenter.db.DbConnection;
import lk.ijse.carServiceCenter.dto.RegisterDto;
import lk.ijse.carServiceCenter.entity.Register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterDAOImpl implements RegisterDAO {
    public static boolean search(String userName, String password) throws SQLException {
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
    @Override
    public boolean save(Register entity) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO login VALUES (?,?,?,?)");
//
//        pstm.setString(1, registerDto.getFirstName());
//        pstm.setString(2, registerDto.getLastName());
//        pstm.setString(3, registerDto.getUserName());
//        pstm.setString(4, registerDto.getPassword());
//
//        return pstm.executeUpdate() > 0;
        return SQLUtil.execute("INSERT INTO login VALUES (?,?,?,?)",
                entity.getFirstName(),
                entity.getFirstName(),
                entity.getUserName(),
                entity.getPassword()
        );
    }

    @Override
    public void delete(String Id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public ArrayList<Register> loadAllId() throws SQLException {
        return null;
    }

    @Override
    public boolean update(Register dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Register search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Register> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
