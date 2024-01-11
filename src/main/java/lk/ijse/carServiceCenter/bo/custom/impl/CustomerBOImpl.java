package lk.ijse.carServiceCenter.bo.custom.impl;

import lk.ijse.carServiceCenter.bo.custom.CustomerBO;
import lk.ijse.carServiceCenter.dao.DAOFactory;
import lk.ijse.carServiceCenter.dao.custom.CustomerDAO;
import lk.ijse.carServiceCenter.dto.AddCustomerDto;
import lk.ijse.carServiceCenter.entity.Customer;


import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public boolean saveCustomer(AddCustomerDto dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer(dto.getCustomerNIC(),
                dto.getCustomerName(),
                dto.getAddress(),
                dto.getTel(),
                dto.getEmail(),
                dto.getDate())
        );
    }

    @Override
    public boolean updateCustomer(AddCustomerDto dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(dto.getCustomerNIC(),
                dto.getCustomerName(),
                dto.getAddress(),
                dto.getTel(),
                dto.getEmail(),
                dto.getDate())
            );
    }

    @Override
    public ArrayList<AddCustomerDto> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> customers = customerDAO.getAll();
        ArrayList<AddCustomerDto> customerDtos = new ArrayList<>();

        for (Customer customer : customers) {
            customerDtos.add(new AddCustomerDto(customer.getCustomerNIC(),
                    customer.getCustomerName(),
                    customer.getAddress(),
                    customer.getTel(),
                    customer.getEmail(),
                    customer.getDate())
            );
        }
        return customerDtos;
    }

    @Override
    public void deleteCustomer(String nic) throws SQLException, ClassNotFoundException {
        customerDAO.delete(nic);
    }

    @Override
    public AddCustomerDto searchCustomer(String nic) throws SQLException, ClassNotFoundException {
        Customer customer = customerDAO.search(nic);
        AddCustomerDto addCustomerDto = new AddCustomerDto(customer.getCustomerNIC(),
                customer.getCustomerName(),
                customer.getAddress(),
                customer.getTel(),
                customer.getEmail(),
                customer.getDate()
        );
        return addCustomerDto;
    }
}
