package lk.ijse.carServiceCenter.bo.custom.impl;

import lk.ijse.carServiceCenter.bo.custom.PartsStockBO;
import lk.ijse.carServiceCenter.dao.DAOFactory;
import lk.ijse.carServiceCenter.dao.custom.PartsStockDAO;
import lk.ijse.carServiceCenter.dto.AddPartsStockDto;
import lk.ijse.carServiceCenter.entity.PartsStock;

import java.sql.SQLException;
import java.util.ArrayList;

public class PartsStockBOImpl implements PartsStockBO {

    PartsStockDAO partsStockDAO = (PartsStockDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PARTS_STOCK);
    @Override
    public boolean savePartsStock(AddPartsStockDto dto) throws SQLException, ClassNotFoundException {
        return partsStockDAO.save(new PartsStock(
                dto.getItemId(),
                dto.getPartName(),
                dto.getPartPrice(),
                dto.getQtyOnHand()
        ));
    }

    @Override
    public void deletePartsStock(String id) throws SQLException, ClassNotFoundException {
        partsStockDAO.delete(id);
    }

    @Override
    public ArrayList<AddPartsStockDto> getAllPartsStock() throws SQLException, ClassNotFoundException {
        ArrayList<PartsStock> partsStocks = partsStockDAO.getAll();
        ArrayList<AddPartsStockDto> partsStockDtos = new ArrayList<>();

        for (PartsStock partsStock : partsStocks) {
            partsStockDtos.add(new AddPartsStockDto(
                    partsStock.getItemId(),
                    partsStock.getPartName(),
                    partsStock.getPartPrice(),
                    partsStock.getQtyOnHand()
            ));
        }
        return partsStockDtos;
    }

    @Override
    public boolean updatePartsStock(AddPartsStockDto dto) throws SQLException, ClassNotFoundException {
        return partsStockDAO.update(new PartsStock(
                dto.getItemId(),
                dto.getPartName(),
                dto.getPartPrice(),
                dto.getQtyOnHand()
        ));
    }
}
