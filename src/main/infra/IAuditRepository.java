package main.infra;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import main.domain.Book;

public interface IAuditRepository
{
    public Book findById(Connection con, Integer id) throws SQLException;

    public List<?> findAll(Connection con) throws SQLException;

    public boolean create(Connection con, String name, String author) throws SQLException;

    public boolean updateById(Connection con, Integer id, String name, String author) throws SQLException;

    public boolean removeById(Connection con, Integer id) throws SQLException;
}
