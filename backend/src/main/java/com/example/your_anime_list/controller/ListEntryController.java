package com.example.your_anime_list.controller;

import com.example.your_anime_list.entity.ListEntry;
import com.example.your_anime_list.entity.WatchStatus;
import com.example.your_anime_list.service.ListEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController()
@RequestMapping("/api/list-entry")
public class ListEntryController {

    @Autowired
    ListEntryService listEntryService;

    @PostMapping()
    public ListEntry add(@RequestBody ListEntry listEntry) {

        // Data cleaning
        listEntry.setId(0); // Ensure that ID is auto-generated
        if (listEntry.getStatus() == null)
            listEntry.setStatus(WatchStatus.PLAN_TO_WATCH);
        if (listEntry.getScore() < 0)
            listEntry.setScore(0);
        if (listEntry.getScore() > 100)
            listEntry.setScore(100);
        if (listEntry.getGenres() == null)
            listEntry.setGenres(new String[]{});
        if (listEntry.getEpisodesWatched() > listEntry.getTotalEpisodes())
            listEntry.setEpisodesWatched(listEntry.getTotalEpisodes());
        if (listEntry.getEpisodesWatched() < 0)
            listEntry.setEpisodesWatched(0);

        return listEntryService.add(listEntry);
    }

    @GetMapping()
    public ArrayList<ListEntry> findAll() {
        return (ArrayList<ListEntry>) listEntryService.findAll();
    }

    @GetMapping("/id/{id}")
    public ListEntry findById(@PathVariable long id) {
        return listEntryService.findById(id);
    }

    @GetMapping("/userid/{id}")
    public ArrayList<ListEntry> findByUserId(@PathVariable long id) {
        return (ArrayList<ListEntry>) listEntryService.findByUserId(id);
    }

    @GetMapping("/malid/{id}")
    public ArrayList<ListEntry> findByMalId(@PathVariable long id) {
        return (ArrayList<ListEntry>) listEntryService.findByMalId(id);
    }

    @PutMapping()
    public ListEntry update(@RequestBody ListEntry listEntry) {
        // Data cleaning
        if (listEntry.getStatus() == null)
            listEntry.setStatus(WatchStatus.PLAN_TO_WATCH);
        if (listEntry.getScore() < 0)
            listEntry.setScore(0);
        if (listEntry.getScore() > 100)
            listEntry.setScore(100);
        if (listEntry.getEpisodesWatched() > listEntry.getTotalEpisodes())
            listEntry.setEpisodesWatched(listEntry.getTotalEpisodes());
        if (listEntry.getEpisodesWatched() < 0)
            listEntry.setEpisodesWatched(0);

        return listEntryService.update(listEntry);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity deleteById(@PathVariable long id) {
        listEntryService.deleteById(id);
        return ResponseEntity.status(204).body(null);
    }

}
