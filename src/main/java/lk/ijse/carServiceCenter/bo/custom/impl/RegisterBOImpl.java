package lk.ijse.carServiceCenter.bo.custom.impl;

import lk.ijse.carServiceCenter.bo.custom.RegisterBO;
import lk.ijse.carServiceCenter.dao.DAOFactory;
import lk.ijse.carServiceCenter.dao.custom.RegisterDAO;
import lk.ijse.carServiceCenter.dto.RegisterDto;
import lk.ijse.carServiceCenter.entity.Register;

import java.sql.SQLException;

public class RegisterBOImpl implements RegisterBO {

    RegisterDAO registerDAO = (RegisterDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.REGISTER);
    @Override
    public boolean saveRegister(RegisterDto dto) throws SQLException, ClassNotFoundException {
        return registerDAO.save(new Register(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getUserName(),
                dto.getPassword()
        ));
    }
}
