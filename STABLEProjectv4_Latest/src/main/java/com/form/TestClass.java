package com.form;

import java.math.BigDecimal;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.stable.sdk.model.person.UserAccount;

public class TestClass {

	public static void main(String[] args){
		
		Session session=null;
		Transaction tx=null;
		try
		{
			Properties properties=new Properties();
			properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
			properties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
			properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3309/stabledb");
			properties.setProperty("hibernate.connection.username", "root");
			properties.setProperty("hibernate.connection.password", "admin");
			properties.setProperty("show_sql", "true");
			Configuration configuration=new Configuration().setProperties(properties);
			configuration.addResource("com/me/UserAccount.hbm.xml");
			configuration.addResource("com/me/AbstractDevice.hbm.xml");
			configuration.addResource("com/me/BedLocation.hbm.xml");
			configuration.addResource("com/me/BirthDetails.hbm.xml");
			configuration.addResource("com/me/CareTeam.hbm.xml");
			configuration.addResource("com/me/Clinic.hbm.xml");
			configuration.addResource("com/me/Employee.hbm.xml");
			configuration.addResource("com/me/IDevice.hbm.xml");
			configuration.addResource("com/me/Measurement.hbm.xml");
			configuration.addResource("com/me/MeasurementSubClasses.hbm.xml");
			configuration.addResource("com/me/Patient.hbm.xml");
			configuration.addResource("com/me/PatientBedLocation.hbm.xml");
			configuration.addResource("com/me/Person.hbm.xml");
			SessionFactory sessionFactory=configuration.buildSessionFactory();
			session=sessionFactory.openSession();
		
			tx=session.beginTransaction();
			Query accountQuery=session.createQuery("from UserAccount WHERE userAccountID=?");
			accountQuery.setBigDecimal(0, new BigDecimal(1));
			Object queryResult=accountQuery.uniqueResult();
			
			if(queryResult==null)
			{
				//throw new InvalidLoginException("Invalid Login Name/Password Entered");
			}
			else
			{
				UserAccount userAccount=(UserAccount)queryResult;
				System.out.println(""+userAccount.getUserAccountID());
			}


		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(!tx.wasRolledBack())
			{
				tx.commit();
			}
			session.close();
		}
	}
}
