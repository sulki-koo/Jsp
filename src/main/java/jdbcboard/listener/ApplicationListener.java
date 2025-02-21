package jdbcboard.listener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String databaseProp = sce.getServletContext().getInitParameter("databaseProp");
		String sqlProp = sce.getServletContext().getInitParameter("sqlProp");
		String commandProp = sce.getServletContext().getInitParameter("commandProp");
		
		Properties databaseProperties = new Properties();
		Properties sqlProperties = new Properties();
		Properties commandProperties = new Properties();
		
		try {
			databaseProperties.load(new FileReader(sce.getServletContext().getRealPath(databaseProp)));
			sqlProperties.load(new FileReader(sce.getServletContext().getRealPath(sqlProp)));
			commandProperties.load(new FileReader(sce.getServletContext().getRealPath(commandProp)));
			
			sce.getServletContext().setAttribute("databaseProperties", databaseProperties);
			sce.getServletContext().setAttribute("databaseProperties", databaseProperties);
			sce.getServletContext().setAttribute("commandProperties", commandProperties);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
}
