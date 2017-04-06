package com.udea.edu.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.udea.edu.iw.dao.ClienteDAO;
import com.udea.edu.iw.dao.DataSource;
import com.udea.edu.iw.dto.Cliente;
import com.udea.edu.iw.exception.ExceptionHandler;

public class ClienteDAOImpl implements ClienteDAO {
	@Override
	public List<Cliente> getALL() throws ExceptionHandler {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Session session = null;
		Criteria criteria = null;
		try {
			session = DataSource.getInstance().getSession();
			criteria = session.createCriteria(Cliente.class);
			criteria.addOrder(Order.asc("fechaCreacion"));
			clientes = criteria.list();
		} catch (ExceptionHandler e) {
			throw new ExceptionHandler("Error consultando la lista de clientes", e);
		}
		
		return clientes;
	}

	@Override
	public boolean createClient(Cliente cliente) throws ExceptionHandler {
		boolean goodInsert = false;
		Session session = null;
		Transaction tx = null;
		try {
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			session.save(cliente);
			tx.commit();
			goodInsert = true;
		} catch (ExceptionHandler e) {
			throw new ExceptionHandler("Error insertando un cliente", e);
		}
		return goodInsert;
	}
}
