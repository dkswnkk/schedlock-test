package com.example.shedlock.schedule;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class Scheduling {
    @Scheduled(cron = "*/5 * * * * *")
    @SchedulerLock(name = "scheduled", lockAtMostFor = "PT2S", lockAtLeastFor = "PT2S")
    public void schedule() {
        log.info("Scheduled task executed at {}", LocalDateTime.now());
    }
}
