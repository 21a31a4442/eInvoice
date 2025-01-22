package pvs;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pvs.admin.status.StatusEntity;
import pvs.admin.status.StatusServiceImpl;

@SpringBootApplication
public class EinvoiceDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(EinvoiceDemoApplication.class, args);
//		StatusServiceImpl status = context.getBean(StatusServiceImpl.class);
//		List<Status> list = status.getAllcolumns();
//		list.forEach(System.out::println);
//		
		
	}

}
