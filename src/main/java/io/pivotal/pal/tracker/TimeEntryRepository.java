package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    
    TimeEntry create(TimeEntry timeEntry);

    List<TimeEntry> list();

    TimeEntry find(Long id);

    TimeEntry update(Long id, TimeEntry toBeUpdated);

    void delete(Long id);
}
