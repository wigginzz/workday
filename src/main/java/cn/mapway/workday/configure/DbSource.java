package cn.mapway.workday.configure;

/**
 * 数据源
 * 
 * @author zhangjianshe@gmail.com
 * @creation 2017-11-28 16:30:45
 */
public class DbSource {
	public String driver;
	public String url;
	public String user;
	public String pwd;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}