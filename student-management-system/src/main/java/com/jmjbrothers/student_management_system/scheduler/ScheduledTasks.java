package com.jmjbrothers.student_management_system.scheduler;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//	@Scheduled(fixedRate = 5, timeUnit = TimeUnit.MINUTES)
//	public void repostCurrentTime() {
//
//		try {
//			Thread.sleep(Duration.ofMinutes(1));
//		} catch (InterruptedException e) {
//			// TODO: handle exception
//		}
//
//		log.info("fixedRate -> The time is now {}", dateFormat.format(new Date()));
//	}

//	@Scheduled(fixedDelay = 5, timeUnit = TimeUnit.SECONDS)
//	public void repostCurrentTimeFixedDelay() {
//
//		try {
//			Thread.sleep(Duration.ofSeconds(1));
//		} catch (InterruptedException e) {
//			// TODO: handle exception
//		}
//
//		log.info("fixedDelay -> The time is now {}", dateFormat.format(new Date()));
//	}

//	@Scheduled(cron = "0 */5 * ? * * ")
//	public void reportCurrentTimeCron() {
//		try {
//			Thread.sleep(Duration.ofMinutes(1));
//		} catch (InterruptedException e) {
//			// TODO: handle exception
//		}
//		log.info("cron -> The time is now {}", dateFormat.format(new Date()));
//	}

}
