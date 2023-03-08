package main.infra;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import main.domain.Renter;

public interface IRenterQueryRepository
{

    public Renter findRenterById(Connection con, Integer id) throws SQLException;

    public List<Renter> findRenterByName(Connection con, String name) throws SQLException;

    public Renter findRenterByEmail(Connection con, String email) throws SQLException;

    public Renter findRenterByPhoneNumber(Connection con, String phone) throws SQLException;

    public Renter findRenterByNameAndEmail(Connection con, String name, String email) throws SQLException;

    public Renter findRenterByNameAndPhoneNumber(Connection con, String name, String phone) throws SQLException;

    public Renter findRenterByEmailAndPhoneNumber(Connection con, String email, String phone) throws SQLException;

    public Renter findRenterByNameAndEmailAndPhoneNumber(Connection con, String name, String email, String phone) throws SQLException;

    public Renter findRenterByIdAndNameAndEmailAndPhoneNumber(Connection con, Integer id, String name, String email, String phone) throws SQLException;
}
