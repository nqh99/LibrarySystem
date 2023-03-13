package main.services;

import java.sql.Connection;

import main.model.RenterModel;

public interface IRenterService {
	public RenterModel findRenterById(Connection con, Integer id);

	public RenterModel findRenterByName(Connection con, String name);

	public RenterModel findRenterByEmail(Connection con, String email);

	public RenterModel findRenterByPhoneNumber(Connection con, String phone);

	public RenterModel findRenterByNameAndEmail(Connection con, String name, String email);

	public RenterModel findRenterByNameAndPhoneNumber(Connection con, String name, String phone);

	public RenterModel findRenterByEmailAndPhoneNumber(Connection con, String email, String phone);

	public RenterModel findRenterByNameAndEmailAndPhoneNumber(Connection con, String name, String email, String phone);

	public RenterModel findRenterByIdAndNameAndEmailAndPhoneNumber(Connection con, Integer id, String name,
			String email, String phone);

	public RenterModel findAllRenters(Connection con);
	
	public int removeRenterById(Connection con, Integer id);
}
