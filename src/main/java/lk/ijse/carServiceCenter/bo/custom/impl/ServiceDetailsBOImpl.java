package lk.ijse.carServiceCenter.bo.custom.impl;

import lk.ijse.carServiceCenter.bo.custom.ServiceDetailsBO;
import lk.ijse.carServiceCenter.dao.DAOFactory;
import lk.ijse.carServiceCenter.dao.custom.ServiceDetailsDAO;
import lk.ijse.carServiceCenter.dto.DetailsDto;
import lk.ijse.carServiceCenter.entity.ServiceDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceDetailsBOImpl implements ServiceDetailsBO {

    ServiceDetailsDAO serviceDetailsDAO = (ServiceDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SERVICE_DETAILS);
    @Override
    public ArrayList<DetailsDto> getAllServiceDetails() throws SQLException, ClassNotFoundException {
        ArrayList<ServiceDetails> serviceDetails = serviceDetailsDAO.getAll();
        ArrayList<DetailsDto> detailsDtos = new ArrayList<>();

        for (ServiceDetails serviceDetails1 : serviceDetails) {
            detailsDtos.add(new DetailsDto(
                    serviceDetails1.getCustomerName(),
                    serviceDetails1.getCustomerNIC(),
                    serviceDetails1.getRepairType(),
                    serviceDetails1.getRepairPrice(),
                    serviceDetails1.getPartName(),
                    serviceDetails1.getPartPrice()
            ));
        }
        return detailsDtos;
    }
}
