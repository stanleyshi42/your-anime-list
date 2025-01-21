package com.example.your_anime_list.service;

import com.example.your_anime_list.entity.ListEntry;
import com.example.your_anime_list.repository.ListEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListEntryService {

    @Autowired
    ListEntryRepository listEntryRepo;

    public ListEntry add(ListEntry listEntry) {
        return listEntryRepo.save(listEntry);
    }

    public List<ListEntry> findAll() {
        return listEntryRepo.findAll();
    }

    public ListEntry findById(long id) {
        return listEntryRepo.findById(id).orElse(null);
    }

    public List<ListEntry> findByUserId(long userId) {
        return listEntryRepo.findByUserId(userId);
    }

    public List<ListEntry> findByMalId(long malId) {
        return listEntryRepo.findByMalId(malId);
    }

    public ListEntry update(ListEntry entry) {
        return listEntryRepo.save(entry);
    }

    public void deleteById(long id) {
        listEntryRepo.deleteById(id);
    }

}
