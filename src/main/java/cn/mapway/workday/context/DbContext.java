package cn.mapway.workday.context;

import cn.mapway.workday.configure.DbConfigure;
import com.alibaba.druid.pool.DruidDataSource;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 提供数据访问
 *
 * @author zhangjianshe@gmail.com
 * @creation 2017-11-28 16:38:16
 */
@Configuration
public class DbContext {
    @Autowired
    DbConfigure dbConfigure;

    @Bean
    public DataSource dataSource() {

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(dbConfigure.dbSource.url);
        dataSource.setPassword(dbConfigure.dbSource.pwd);
        dataSource.setUsername(dbConfigure.dbSource.user);
        dataSource.setDriverClassName(dbConfigure.dbSource.driver);
        dataSource.setMaxActive(30);
        dataSource.setMaxWait(5 * 1000);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnReturn(true);

//        StatFilter statFilter = new StatFilter();
//        dataSource.getProxyFilters().add(statFilter);
        return dataSource;
    }
    @Bean
    public Dao dao() {
        return new NutDao(dataSource());
    }

}
