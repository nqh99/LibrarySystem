package main.services.impl;

import java.sql.Connection;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import main.configures.ApplicationCfg;
import main.domain.ObjectType;
import main.infra.BookQueryRepository;
import main.infra.IBookQueryRepository;
import main.model.RenterModel;
import main.services.IRenterService;

public class RenterService implements IRenterService
{
    private final IBookQueryRepository                bookQueryRepository = BookQueryRepository.getInstance();

    private final Map<ObjectType, AbstractTableModel> objectMap           = ApplicationCfg.getInstance().getObjectMap();

    private static volatile RenterService             obj                 = null;

    private RenterService()
    {

    }

    public static RenterService getInstance()
    {
        if (obj == null)
        {
            synchronized (RenterService.class)
            {
                if (obj == null)
                {
                    obj = new RenterService();
                }
            }
        }
        return obj;
    }

    @Override
    public RenterModel findRenterById(Connection con, Integer id)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RenterModel findRenterByName(Connection con, String name)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RenterModel findRenterByEmail(Connection con, String email)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RenterModel findRenterByPhoneNumber(Connection con, String phone)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RenterModel findRenterByNameAndEmail(Connection con, String name, String email)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RenterModel findRenterByNameAndPhoneNumber(Connection con, String name, String phone)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RenterModel findRenterByEmailAndPhoneNumber(Connection con, String email, String phone)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RenterModel findRenterByNameAndEmailAndPhoneNumber(Connection con, String name, String email, String phone)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RenterModel findRenterByIdAndNameAndEmailAndPhoneNumber(Connection con, Integer id, String name, String email, String phone)
    {
        // TODO Auto-generated method stub
        return null;
    }
}
