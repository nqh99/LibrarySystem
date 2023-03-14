package main.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import main.configures.ApplicationCfg;
import main.domain.AuditType;
import main.domain.Renter;
import main.infra.IRenterQueryRepository;
import main.infra.impl.RenterQueryRepository;
import main.model.RenterModel;
import main.services.IRenterService;

public class RenterService implements IRenterService
{
    private final Map<AuditType, AbstractTableModel> objectMap = ApplicationCfg.getInstance().getObjectMap();

    @Override
    public RenterModel findRenterById(Connection con, Integer id)
    {
        RenterModel renterModel = (RenterModel) objectMap.get(AuditType.RENTER);
        IRenterQueryRepository renterQueryRepository = new RenterQueryRepository();

        try
        {
            Renter renter = renterQueryRepository.findRenterById(con, id);
            renterModel.setRenterList(Arrays.asList(renter));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return renterModel;
    }

    @Override
    public boolean removeRenterById(Connection con, Integer id)
    {
        boolean result = false;
        IRenterQueryRepository renterQueryRepository = new RenterQueryRepository();

        try
        {
            result = renterQueryRepository.removeRenterById(con, id);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public RenterModel findAllRenters(Connection con)
    {
        RenterModel renterModel = (RenterModel) objectMap.get(AuditType.RENTER);
        List<Renter> list = new ArrayList<>();
        IRenterQueryRepository renterQueryRepository = new RenterQueryRepository();

        try
        {
            list.addAll(renterQueryRepository.findAllRenters(con));
            renterModel.setRenterList(list);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return renterModel;
    }

    @Override
    public boolean createRenter(Connection con, String name, String email, String phoneNumber)
    {
        boolean result = false;
        IRenterQueryRepository renterQueryRepository = new RenterQueryRepository();

        try
        {
            result = renterQueryRepository.createRenter(con, name, email, phoneNumber);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean updateRenterById(Connection con, Integer id, String name, String email, String phoneNumber)
    {
        boolean result = false;
        IRenterQueryRepository renterQueryRepository = new RenterQueryRepository();

        try
        {
            result = renterQueryRepository.updateRenterById(con, id, name, email, phoneNumber);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
