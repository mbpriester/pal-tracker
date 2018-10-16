package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    
    TimeEntry create(TimeEntry timeEntry);

    List<TimeEntry> list();

    TimeEntry find(long id);

    TimeEntry update(long id, TimeEntry toBeUpdated);

    void delete(long id);
}
