package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;




public class WebApp implements WebApplicationInitializer{

    @SuppressWarnings("null")
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        
        //create root context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootContextConfig.class);

        //context loaded with contextloaderlistener will become root context, i.e. in servlet context
        servletContext.addListener(new ContextLoaderListener(rootContext));

        //create context for dispatcher servlet
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(DispatcherServletConfig.class);

        //create dispatcher servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);

        //register servlet in servlet context
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");

    }
    
}





/*
public class WebApp extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        
        return new Class[]{RootContextConfig.class} ;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        
        return new Class[]{DispatcherServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/" };
    }
    
}


*/
