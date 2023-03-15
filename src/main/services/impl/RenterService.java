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
import main.infra.IAuditRepository;
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
        IAuditRepository renterQueryRepository = new RenterQueryRepository();

        try
        {
            Renter renter = renterQueryRepository.findById(con, id);
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
        IAuditRepository renterQueryRepository = new RenterQueryRepository();

        try
        {
            result = renterQueryRepository.removeById(con, id);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public RenterModel findAllRenters(Connection con)
    {
        RenterModel renterModel = (RenterModel) objectMap.get(AuditType.RENTER);
        List<Renter> list = new ArrayList<>();
        IAuditRepository renterQueryRepository = new RenterQueryRepository();

        try
        {
            list.addAll((List<Renter>) renterQueryRepository.findAll(con));
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
        IAuditRepository renterQueryRepository = new RenterQueryRepository();

        try
        {
            result = renterQueryRepository.create(con, name, email, phoneNumber);
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
        IAuditRepository renterQueryRepository = new RenterQueryRepository();

        try
        {
            result = renterQueryRepository.updateById(con, id, name, email, phoneNumber);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
