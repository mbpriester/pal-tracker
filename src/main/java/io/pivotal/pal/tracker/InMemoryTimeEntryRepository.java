package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    private long id = 0;
    Map<Long, TimeEntry> timeEntryMap =new HashMap<Long, TimeEntry>();

    public TimeEntry create(TimeEntry newTimeEntry){
        id +=1;
        newTimeEntry.setId(id);
        timeEntryMap.put(id, newTimeEntry);
        return newTimeEntry;
    }

    public TimeEntry find(long id){
        return timeEntryMap.get(id);
    }

    public List<TimeEntry> list(){
        List<TimeEntry> list = new ArrayList<>();

        for(TimeEntry n : timeEntryMap.values()){
            list.add(n);
        }
        return list;
    }

    public TimeEntry update(long id, TimeEntry updatedEntry){
        TimeEntry toBeUpdated = find(id);
        toBeUpdated.setDate(updatedEntry.getDate());
        toBeUpdated.setHours(updatedEntry.getHours());
        toBeUpdated.setProjectId(updatedEntry.getProjectId());
        toBeUpdated.setUserId(updatedEntry.getUserId());

        return toBeUpdated;
    }

    public void delete(long id){
        if(timeEntryMap.containsKey(id))
            timeEntryMap.remove(id);
    }
}
