package com.huang.login;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.huang.entity.User;

import redis.clients.jedis.Jedis;

public class LoginServlet {

	public static String getString(){
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		String ret = jedis.get("age");
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("ron");
		PersistenceManager pm = pmf.getPersistenceManager();  
        Transaction tx = pm.currentTransaction();  
        try {  
            tx.begin(); 
            User user=new User();
            String name = "814808734";
            String passwd = "123456";
    		String sql="SELECT * FROM user WHERE qq = '"+name+"' and passwd = '"+passwd+"' "
    				+"or weibo = '"+name+"' and passwd= '"+passwd+"'";
    		Query q = pm.newQuery("javax.jdo.query.SQL", sql); 
    		q.setClass(User.class);
    		q.execute();
            user=(User)(q.execute());
           
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
		return ret;
	}
}
