package lk.ijse.carServiceCenter.dao;

import lk.ijse.carServiceCenter.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {

    }
    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ?daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        BOOKING, CUSTOMER, PARTS, PARTS_STOCK, REGISTER, REPAIR, SERVICE_DETAILS
    }

    public SuperDAO getDAO(DAOTypes daoTypes) {
        switch (daoTypes) {
            case BOOKING:
                return new BookingDAOImpl();
            case CUSTOMER:
                return new CustomerDAOImpl();
            case PARTS:
                return new PartsDAOImpl();
            case PARTS_STOCK:
                return new PartsStockDAOImpl();
            case REGISTER:
                return new RegisterDAOImpl();
            case REPAIR:
                return new RepairDAOImpl();
            case SERVICE_DETAILS:
                return new ServiceDetailsDAOImpl();
            default:
                return  null;
        }
    }
}
