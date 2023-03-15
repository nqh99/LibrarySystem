package main.infra;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IAuditRepository
{
    public <T> T findById(Connection con, Integer id) throws SQLException;

    public List<?> findAll(Connection con) throws SQLException;

    public boolean create(Connection con, String... args) throws SQLException;

    public boolean updateById(Connection con, Integer id, String... args) throws SQLException;

    public boolean removeById(Connection con, Integer id) throws SQLException;
}
