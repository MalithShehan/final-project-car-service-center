package lk.ijse.carServiceCenter.bo.custom.impl;

import lk.ijse.carServiceCenter.bo.custom.RepairBO;
import lk.ijse.carServiceCenter.dao.DAOFactory;
import lk.ijse.carServiceCenter.dao.custom.RepairDAO;
import lk.ijse.carServiceCenter.dto.RepairDto;
import lk.ijse.carServiceCenter.entity.Repair;

import java.sql.SQLException;
import java.util.ArrayList;

public class RepairBOImpl implements RepairBO {

    RepairDAO repairDAO = (RepairDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.REPAIR);
    @Override
    public boolean saveRepair(RepairDto dto) throws SQLException, ClassNotFoundException {
        return repairDAO.save(new Repair(
                dto.getRepairId(),
                dto.getRepairType(),
                dto.getRepairPrice(),
                dto.getCustomerNIC()
        ));
    }

    @Override
    public ArrayList<RepairDto> getAllRepair() throws SQLException, ClassNotFoundException {
        ArrayList<Repair> repairs = repairDAO.getAll();
        ArrayList<RepairDto> repairDtos = new ArrayList<>();

        for (Repair repair : repairs) {
            repairDtos.add(new RepairDto(
                    repair.getRepairId(),
                    repair.getRepairType(),
                    repair.getRepairPrice(),
                    repair.getCustomerNIC()
            ));
        }
        return repairDtos;
    }

    @Override
    public void deleteRepair(String id) throws SQLException, ClassNotFoundException {
        repairDAO.delete(id);
    }

    @Override
    public boolean updateRepair(RepairDto dto) throws SQLException, ClassNotFoundException {
        return repairDAO.update(new Repair(
                dto.getRepairId(),
                dto.getRepairType(),
                dto.getRepairPrice(),
                dto.getCustomerNIC()
        ));
    }
}
