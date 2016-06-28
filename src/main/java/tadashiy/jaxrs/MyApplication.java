package tadashiy.jaxrs;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.MvcFeature;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

public class MyApplication extends ResourceConfig {
  public MyApplication() {
    this.packages(MyApplication.class.getPackage().getName());
    this.register(JspMvcFeature.class);
  }
}