package tk.dingjining.studyspring.conf;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CommandRunner implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("2--------------------------");
	}

}
