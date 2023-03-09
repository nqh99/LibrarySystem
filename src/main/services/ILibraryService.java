package main.services;

import java.sql.Connection;

import main.model.LibraryModel;

public interface ILibraryService
{
    public LibraryModel findLibraryById(Connection con, Integer id);

    public LibraryModel findLibraryByName(Connection con, String name);

    public LibraryModel findLibraryByLocation(Connection con, String location);

    public LibraryModel findLibraryByNameAndLocation(Connection con, String name, String location);

    public LibraryModel findLibraryByIdAndNameAndLocation(Connection con, Integer id, String name, String location);
}
