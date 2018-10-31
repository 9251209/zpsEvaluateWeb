package cn.net.mine.common.util;

import java.util.HashMap;
import java.util.Map;

public class Jurisdiction {
	
	private Map<String,SessionBean> jurisdictionMap = new HashMap<String, SessionBean>();
	
	private static Jurisdiction jurisdiction; 
	
	private String name;
	
	private String sex;
	
	private Integer age;
	
    //私有化构造函数
    private Jurisdiction(){
        
    }
    
    public static Jurisdiction getInstance() {
		   if(jurisdiction == null){
		     synchronized (Jurisdiction.class) {
		         if(jurisdiction == null){
		        	 jurisdiction = new Jurisdiction() ;
		         }
		      }
		  }
          return jurisdiction ;  
    }

	public Map<String, SessionBean> getJurisdictionMap() {
		return jurisdictionMap;
	}

	public static Jurisdiction getJurisdiction() {
		return jurisdiction;
	}

	public static void setJurisdiction(Jurisdiction jurisdiction) {
		Jurisdiction.jurisdiction = jurisdiction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
    
    

}