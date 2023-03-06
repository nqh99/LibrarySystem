package test;

import main.services.BookService;
import main.services.IBookService;

public class TestDatabase
{

    public static void main(String[] args)
    {
        IBookService iservice = BookService.getInstance();
        iservice.findBookById(1);
        System.out.println(iservice.findBookById(1).getName());
    }

}
