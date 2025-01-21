package com.example.your_anime_list.repository;

import com.example.your_anime_list.entity.ListEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListEntryRepository extends JpaRepository<ListEntry, Long> {
    // Derived queries
    List<ListEntry> findByUserId(long userId);
    List<ListEntry> findByMalId(long malId);
}
