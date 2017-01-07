package com.huang.test;


import java.util.Properties;

import javax.jdo.JDOHelper;  
import javax.jdo.PersistenceManager;  
import javax.jdo.PersistenceManagerFactory;  
import javax.jdo.Transaction; 
  
import org.junit.Before;  
import org.junit.Test;

import com.huang.entity.User;
  
/** 
 * Unit test for JDO. 
 */  
  
public class JDOTest {  
    private static PersistenceManagerFactory pmf = null;  
      
    @Before  
    public void before()  {  
       /* Properties properties = new Properties(); 
        properties.setProperty("javax.jdo.option.ConnectionDriverName","com.mysql.jdbc.Driver"); 
        properties.setProperty("javax.jdo.option.ConnectionURL","jdbc:mysql://127.0.0.1:3306/moana_db"); 
        properties.setProperty("javax.jdo.option.ConnectionUserName","root"); 
        properties.setProperty("javax.jdo.option.ConnectionPassword","root"); 
        properties.setProperty("javax.jdo.option.Optimistic","true"); 
        properties.setProperty("datanucleus.autoCreateSchema","true");  
       // JDOHelper.getpgetPersistenceManagerFactory有很多重载的方法，具体请参看API  
		
    	pmf = JDOHelper.getPersistenceManagerFactory(properties);*/
        pmf = JDOHelper.getPersistenceManagerFactory("ron");  
    }  
      
    @Test  
    public void testPersistenceManageFactory() {  
        System.out.println(pmf);  
    }  
      
    @Test  
    public void testSave() {  
        PersistenceManager pm = pmf.getPersistenceManager();  
        Transaction tx = pm.currentTransaction();  
        try {  
            tx.begin();  
            User user = new User();  
           
            User p = pm.makePersistent(user);  
            tx.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
            if (tx.isActive()) {  
                tx.rollback();  
            }  
        } finally {  
            pm.close();  
            pmf.close();  
        }  
    }  
      
}  
