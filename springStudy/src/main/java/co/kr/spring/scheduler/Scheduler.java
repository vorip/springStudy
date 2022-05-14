package co.kr.spring.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import co.kr.spring.mng.service.inf.GlobalScheduler;

@Component
public class Scheduler {
	
	@Autowired
	GlobalScheduler scheduler;
	
	//초(0-59) 분(0-59)　시간(0-23)　일(1-31)　월(1-12)　요일(0-7) 
	@Scheduled(cron = "0 41 16 * * *")
	public void everydaySchedule() {
		scheduler.lawMaking();
	}
}
