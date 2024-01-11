package lk.ijse.carServiceCenter.bo;

import lk.ijse.carServiceCenter.bo.custom.impl.*;


public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes {
        BOOKING, CUSTOMER, PARTS, PARTS_STOCK, REGISTER, REPAIR, SERVICE_DETAILS
    }

    public SuperBO getBO(BOTypes boTypes) {
        switch (boTypes) {
            case BOOKING:
                return new BookingBOImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            case PARTS:
                return new PartsBOImpl();
            case PARTS_STOCK:
                return new PartsStockBOImpl();
            case REGISTER:
                return new RegisterBOImpl();
            case REPAIR:
                return new RepairBOImpl();
            case SERVICE_DETAILS:
                return new ServiceDetailsBOImpl();
            default:
                return null;
        }
    }
}
