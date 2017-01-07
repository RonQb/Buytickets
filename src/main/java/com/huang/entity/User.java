package com.huang.entity;


import javax.jdo.annotations.Column;  
import javax.jdo.annotations.PersistenceCapable;  
import javax.jdo.annotations.PrimaryKey; 

@PersistenceCapable(table="USER")  
public class User {
	@PrimaryKey  
    @Column(name="ID")  
    //如果ID要自增长请加上@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)  
    private Integer id;
	
	@Column(name="QQ")  
    private String qq; 
	
	@Column(name="PASSWD")  
    private String passwd; 
	
	@Column(name="WEIBO")  
    private String weibo; 
	
	
	 @Override  
    public String toString() {  
        return "User [id=" + id + ", weibo=" + weibo + ", qq=" + qq   ;  
    }


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getQq() {
		return qq;
	}


	public void setQq(String qq) {
		this.qq = qq;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getWeibo() {
		return weibo;
	}


	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}  
	
}
