package tk.dingjining.studyspring.schedule;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MySchedule {
	@Scheduled(cron = "15 * * * * *")
	public void task1() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("fixed ---->123" + new Date());
	}
}
