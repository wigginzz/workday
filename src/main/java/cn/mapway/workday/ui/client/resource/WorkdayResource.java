package cn.mapway.workday.ui.client.resource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface WorkdayResource extends ClientBundle {
     static WorkdayResource INSTANCE= GWT.create(WorkdayResource.class);

     static WorkdayResource get()
    {
        return INSTANCE;
    }

    @Source("image/p.png")
     ImageResource attribute();

    @Source("image/m.png")
    ImageResource method();

    @Source("image/e.png")
    ImageResource event();

    @Source("image/d.png")
    ImageResource device();
    @Source("image/pa.png")
    ImageResource parameter();
}
