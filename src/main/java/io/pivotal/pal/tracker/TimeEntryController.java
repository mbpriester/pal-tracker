package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository){
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        ResponseEntity<TimeEntry> response;

        TimeEntry created = timeEntryRepository.create(timeEntryToCreate);
        if (created != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(created);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable("id") Long id) {
        TimeEntry found = timeEntryRepository.find(id);
        if(found != null)
            return ResponseEntity.ok(found);

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> listOfTimeEntries = null;
        listOfTimeEntries = timeEntryRepository.list();

        return ResponseEntity.ok(listOfTimeEntries);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable Long id, @RequestBody TimeEntry expected) {
        TimeEntry updated = timeEntryRepository.update(id, expected);

        if(updated != null && updated.getId() == id)
            return ResponseEntity.ok(updated);

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable Long id) {
        timeEntryRepository.delete(id);

        return ResponseEntity.noContent().build();

    }
}
