package com.example.your_anime_list.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ListEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long userId;
    private long malId;     // MyAnimeList ID
    private String title;
    private int totalEpisodes;
    private int episodesWatched;
    private String[] genres;
    private WatchStatus status;
    private int score;
    private boolean favorite;
    private int durationMinutes;
    private String imageUrl;

    public ListEntry() {
    }

    public ListEntry(long id, long userId, long malId, String title, int totalEpisodes, int episodesWatched, String[] genres, WatchStatus status, int score, boolean favorite, int durationMinutes, String imageUrl) {
        this.id = id;
        this.userId = userId;
        this.malId = malId;
        this.title = title;
        this.totalEpisodes = totalEpisodes;
        this.episodesWatched = episodesWatched;
        this.genres = genres;
        this.status = status;
        this.score = score;
        this.favorite = favorite;
        this.durationMinutes = durationMinutes;
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getMalId() {
        return malId;
    }

    public void setMalId(long malId) {
        this.malId = malId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setTotalEpisodes(int totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }

    public int getEpisodesWatched() {
        return episodesWatched;
    }

    public void setEpisodesWatched(int episodesWatched) {
        this.episodesWatched = episodesWatched;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public WatchStatus getStatus() {
        return status;
    }

    public void setStatus(WatchStatus status) {
        this.status = status;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
