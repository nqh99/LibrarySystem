package main.services;

import java.sql.Connection;

import main.model.BookModel;
import main.model.LibraryModel;
import main.model.RenterModel;

public interface ISearchService
{
    public BookModel findBookById(Connection con, Integer id);

    public BookModel findBookByName(Connection con, String name, String author);

    public BookModel findBookByAuthor(Connection con, String author);

    public BookModel findBookByNameAndAuthor(Connection con, String name, String author);

    public BookModel findBookByIdAndNameAndAuthor(Connection con, Integer id, String name, String author);

    public LibraryModel findLibraryById(Connection con, Integer id);

    public LibraryModel findLibraryByName(Connection con, String name);

    public LibraryModel findLibraryByLocation(Connection con, String location);

    public LibraryModel findLibraryByNameAndLocation(Connection con, String name, String location);
    
    public LibraryModel findLibraryByIdAndNameAndLocation(Connection con,Integer id, String name, String location);

    public RenterModel findRenterById(Connection con, Integer id);

    public RenterModel findRenterByName(Connection con, String name);

    public RenterModel findRenterByEmail(Connection con, String email);

    public RenterModel findRenterByPhoneNumber(Connection con, String phone);

    public RenterModel findRenterByNameAndEmail(Connection con, String name, String email);

    public RenterModel findRenterByNameAndPhoneNumber(Connection con, String name, String phone);
    
    public RenterModel findRenterByEmailAndPhoneNumber(Connection con, String email, String phone);

    public RenterModel findRenterByNameAndEmailAndPhoneNumber(Connection con, String name, String email, String phone);
    
    public RenterModel findRenterByIdAndNameAndEmailAndPhoneNumber(Connection con, Integer id, String name, String email, String phone);
}
