package cn.net.mine.common.util;

public class SessionBean {
	
	private long time;
	
	private Integer countNMB;
	
	private String name;
	
	private String sex;

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public Integer getCountNMB() {
		return countNMB;
	}

	public void setCountNMB(Integer countNMB) {
		this.countNMB = countNMB;
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

	@Override
	public String toString() {
		return "SessionBean [time=" + time + ", countNMB=" + countNMB + ", sex=" + sex + "]";
	}
	
	
	
}
