package main.infra;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ibm.db2.jcc.am.SqlException;

import main.domain.Renter;

public interface IRenterQueryRepository
{

    public Renter findRenterById(Connection con, Integer id) throws SQLException;

    public List<Renter> findAllRenters(Connection con) throws SqlException, SQLException;

    public boolean createRenter(Connection con, String name, String email, String phoneNumber) throws SQLException;

    public boolean removeRenterById(Connection con, Integer id) throws SQLException;

    public boolean updateRenterById(Connection con, Integer id, String name, String email, String phoneNumber) throws SQLException;

}
