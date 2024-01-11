package lk.ijse.carServiceCenter.bo.custom.impl;

import com.lowagie.text.pdf.AcroFields;
import lk.ijse.carServiceCenter.bo.custom.PartsBO;
import lk.ijse.carServiceCenter.dao.DAOFactory;
import lk.ijse.carServiceCenter.dao.custom.PartsDAO;
import lk.ijse.carServiceCenter.dto.AddPartsDto;
import lk.ijse.carServiceCenter.entity.Parts;

import java.sql.SQLException;
import java.util.ArrayList;

public class PartsBOImpl implements PartsBO {

    PartsDAO partsDAO = (PartsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PARTS);
    @Override
    public boolean savePart(AddPartsDto dto) throws SQLException, ClassNotFoundException {
        return partsDAO.save(new Parts(
                dto.getItemId(),
                dto.getItemName(),
                dto.getItemPrice(),
                dto.getQuantity()
        ));
    }

    @Override
    public void deletePart(String id) throws SQLException, ClassNotFoundException {
        partsDAO.delete(id);
    }

    @Override
    public boolean updatePart(AddPartsDto dto) throws SQLException, ClassNotFoundException {
        return partsDAO.update(new Parts(
                dto.getItemId(),
                dto.getItemName(),
                dto.getItemPrice(),
                dto.getQuantity()
        ));
    }

    @Override
    public ArrayList<AddPartsDto> getAllPart() throws SQLException, ClassNotFoundException {
        ArrayList<Parts> part = partsDAO.getAll();
        ArrayList<AddPartsDto> addPartsDtos = new ArrayList<>();

        for (Parts parts : part) {
            addPartsDtos.add(new AddPartsDto(
                    parts.getItemId(),
                    parts.getItemName(),
                    parts.getItemPrice(),
                    parts.getQuantity()
            ));
        }
        return addPartsDtos;
    }
}
