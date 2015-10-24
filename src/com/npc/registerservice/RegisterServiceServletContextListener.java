package com.npc.registerservice;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class RegisterServiceServletContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContextListener destroyed");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContextListener started");
		this.deregisterDrivers();
	}
	
	private void deregisterDrivers() {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		for (; drivers.hasMoreElements(); ) {
			Driver driver = drivers.nextElement();
			if (driver.getClass().getClassLoader() == cl) {
				try {
					DriverManager.deregisterDriver(driver);
				} catch (SQLException ex) {}
			}
		}
	}
}

