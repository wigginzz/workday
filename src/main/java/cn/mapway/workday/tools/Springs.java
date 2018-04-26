package cn.mapway.workday.tools;

import org.nutz.dao.Dao;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Springs implements ApplicationContextAware {

    private static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context =applicationContext;
    }

    public static <T> T get(Class<T> cls)
    {
       return context.getBean(cls);
    }

    public static Dao getDao()
    {
        return context.getBean(Dao.class);
    }
}
