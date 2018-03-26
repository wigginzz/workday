package cn.mapway.workday.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "db")
public class DbConfigure {
	public DbSource dbSource;

    public DbSource getDbSource() {
        return dbSource;
    }

    public void setDbSource(DbSource dbSource) {
        this.dbSource = dbSource;
    }
}
