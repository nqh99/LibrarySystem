package main.services;

import java.sql.Connection;

import main.model.RenterModel;

public interface IRenterService
{
    public RenterModel findRenterById(Connection con, Integer id);

    public RenterModel findAllRenters(Connection con);

    public boolean removeRenterById(Connection con, Integer id);

    public boolean updateRenterById(Connection con, Integer id, String name, String email, String phoneNumber);

    public boolean createRenter(Connection con, String name, String email, String phoneNumber);
}
