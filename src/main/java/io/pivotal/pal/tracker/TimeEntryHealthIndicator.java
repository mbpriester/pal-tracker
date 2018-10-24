package io.pivotal.pal.tracker;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class TimeEntryHealthIndicator implements HealthIndicator {

    TimeEntryRepository timeEntriesRepo;

    public TimeEntryHealthIndicator(TimeEntryRepository timeEntriesRepo){
        this.timeEntriesRepo = timeEntriesRepo;
    }

    @Override
    public Health health() {
        int count = timeEntriesRepo.list().size();

        return count < 5 ? Health.up().build() : Health.down().build();
    }
}
