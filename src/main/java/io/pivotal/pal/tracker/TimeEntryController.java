package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository){
        this.timeEntryRepository = timeEntryRepository;
    }

    public ResponseEntity create(TimeEntry timeEntryToCreate) {
        ResponseEntity<TimeEntry> response;

        TimeEntry created = timeEntryRepository.create(timeEntryToCreate);
        if (created != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(created);

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<TimeEntry> read(long id) {
        TimeEntry found = timeEntryRepository.find(id);
        if(found != null)
            return ResponseEntity.ok(found);

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> listOfTimeEntries = null;
        listOfTimeEntries = timeEntryRepository.list();

        return ResponseEntity.ok(listOfTimeEntries);
    }

    public ResponseEntity<TimeEntry> update(long id, TimeEntry expected) {
        TimeEntry updated = timeEntryRepository.update(id, expected);

        if(updated != null && updated.getId() == id)
            return ResponseEntity.ok(updated);

        return ResponseEntity.notFound().build();

    }

    public ResponseEntity<TimeEntry> delete(long id) {
        timeEntryRepository.delete(id);

        return ResponseEntity.noContent().build();

    }
}
