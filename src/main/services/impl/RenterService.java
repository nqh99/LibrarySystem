package main.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import main.configures.ApplicationCfg;
import main.domain.ObjectType;
import main.domain.RealObject;
import main.domain.Renter;
import main.infra.IRenterQueryRepository;
import main.infra.impl.RenterQueryRepository;
import main.model.RenterModel;
import main.services.IRenterService;

public class RenterService implements IRenterService
{
    private final IRenterQueryRepository              renterQueryRepository = RenterQueryRepository.getInstance();

    private final Map<ObjectType, AbstractTableModel> objectMap             = ApplicationCfg.getInstance().getObjectMap();

    private static volatile RenterService             obj                   = null;

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
        RenterModel renterModel = (RenterModel) objectMap.get(ObjectType.RENTER);
        try
        {
            Renter renter = renterQueryRepository.findRenterById(con, id);
            renterModel.setRenterList(Arrays.asList(renter));
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return renterModel;
    }

    @Override
    public RenterModel findRenterByName(Connection con, String name)
    {
        RenterModel renterModel = (RenterModel) objectMap.get(ObjectType.RENTER);
        List<RealObject> list = new ArrayList<>();
        try
        {
            list.addAll(renterQueryRepository.findRenterByName(con, name));
            renterModel.setRenterList(list);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return renterModel;
    }

    @Override
    public RenterModel findRenterByEmail(Connection con, String email)
    {
        RenterModel renterModel = (RenterModel) objectMap.get(ObjectType.RENTER);
        try
        {
            Renter renter = renterQueryRepository.findRenterByEmail(con, email);
            renterModel.setRenterList(Arrays.asList(renter));
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return renterModel;
    }

    @Override
    public RenterModel findRenterByPhoneNumber(Connection con, String phone)
    {
        RenterModel renterModel = (RenterModel) objectMap.get(ObjectType.RENTER);
        try
        {
            Renter renter = renterQueryRepository.findRenterByPhoneNumber(con, phone);
            renterModel.setRenterList(Arrays.asList(renter));
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return renterModel;
    }

    @Override
    public RenterModel findRenterByNameAndEmail(Connection con, String name, String email)
    {
        RenterModel renterModel = (RenterModel) objectMap.get(ObjectType.RENTER);
        try
        {
            Renter renter = renterQueryRepository.findRenterByNameAndEmail(con, name, email);
            renterModel.setRenterList(Arrays.asList(renter));
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return renterModel;
    }

    @Override
    public RenterModel findRenterByNameAndPhoneNumber(Connection con, String name, String phone)
    {
        RenterModel renterModel = (RenterModel) objectMap.get(ObjectType.RENTER);
        try
        {
            Renter renter = renterQueryRepository.findRenterByNameAndPhoneNumber(con, name, phone);
            renterModel.setRenterList(Arrays.asList(renter));
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return renterModel;
    }

    @Override
    public RenterModel findRenterByEmailAndPhoneNumber(Connection con, String email, String phone)
    {
        RenterModel renterModel = (RenterModel) objectMap.get(ObjectType.RENTER);
        try
        {
            Renter renter = renterQueryRepository.findRenterByEmailAndPhoneNumber(con, email, phone);
            renterModel.setRenterList(Arrays.asList(renter));
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return renterModel;
    }

    @Override
    public RenterModel findRenterByNameAndEmailAndPhoneNumber(Connection con, String name, String email, String phone)
    {
        RenterModel renterModel = (RenterModel) objectMap.get(ObjectType.RENTER);
        try
        {
            Renter renter = renterQueryRepository.findRenterByNameAndEmailAndPhoneNumber(con, name, email, phone);
            renterModel.setRenterList(Arrays.asList(renter));
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return renterModel;
    }

    @Override
    public RenterModel findRenterByIdAndNameAndEmailAndPhoneNumber(Connection con, Integer id, String name, String email, String phone)
    {
        RenterModel renterModel = (RenterModel) objectMap.get(ObjectType.RENTER);
        try
        {
            Renter renter = renterQueryRepository.findRenterByIdAndNameAndEmailAndPhoneNumber(con, id, name, email, phone);
            renterModel.setRenterList(Arrays.asList(renter));
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return renterModel;
    }

    @Override
    public int removeRenterById(Connection con, Integer id)
    {
        return 0;
    }
}
