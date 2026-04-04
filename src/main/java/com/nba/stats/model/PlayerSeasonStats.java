package com.nba.stats.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "player_season_stats")
public class PlayerSeasonStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    @JsonIgnore
    private Player player;

    @Column(nullable = false)
    private String season;

    private Integer gamesPlayed;
    private Double pointsPerGame;
    private Double reboundsPerGame;
    private Double assistsPerGame;
    private Double stealsPerGame;
    private Double blocksPerGame;
    private Double fieldGoalPct;
    private Double threePointPct;
    private Double freeThrowPct;
    private Double minutesPerGame;

    public PlayerSeasonStats() {}

    public PlayerSeasonStats(Player player, String season, Integer gamesPlayed,
                              Double pointsPerGame, Double reboundsPerGame, Double assistsPerGame,
                              Double stealsPerGame, Double blocksPerGame,
                              Double fieldGoalPct, Double threePointPct, Double freeThrowPct,
                              Double minutesPerGame) {
        this.player = player;
        this.season = season;
        this.gamesPlayed = gamesPlayed;
        this.pointsPerGame = pointsPerGame;
        this.reboundsPerGame = reboundsPerGame;
        this.assistsPerGame = assistsPerGame;
        this.stealsPerGame = stealsPerGame;
        this.blocksPerGame = blocksPerGame;
        this.fieldGoalPct = fieldGoalPct;
        this.threePointPct = threePointPct;
        this.freeThrowPct = freeThrowPct;
        this.minutesPerGame = minutesPerGame;
    }

    public Long getId() { return id; }
    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }
    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }
    public Integer getGamesPlayed() { return gamesPlayed; }
    public void setGamesPlayed(Integer gamesPlayed) { this.gamesPlayed = gamesPlayed; }
    public Double getPointsPerGame() { return pointsPerGame; }
    public void setPointsPerGame(Double pointsPerGame) { this.pointsPerGame = pointsPerGame; }
    public Double getReboundsPerGame() { return reboundsPerGame; }
    public void setReboundsPerGame(Double reboundsPerGame) { this.reboundsPerGame = reboundsPerGame; }
    public Double getAssistsPerGame() { return assistsPerGame; }
    public void setAssistsPerGame(Double assistsPerGame) { this.assistsPerGame = assistsPerGame; }
    public Double getStealsPerGame() { return stealsPerGame; }
    public void setStealsPerGame(Double stealsPerGame) { this.stealsPerGame = stealsPerGame; }
    public Double getBlocksPerGame() { return blocksPerGame; }
    public void setBlocksPerGame(Double blocksPerGame) { this.blocksPerGame = blocksPerGame; }
    public Double getFieldGoalPct() { return fieldGoalPct; }
    public void setFieldGoalPct(Double fieldGoalPct) { this.fieldGoalPct = fieldGoalPct; }
    public Double getThreePointPct() { return threePointPct; }
    public void setThreePointPct(Double threePointPct) { this.threePointPct = threePointPct; }
    public Double getFreeThrowPct() { return freeThrowPct; }
    public void setFreeThrowPct(Double freeThrowPct) { this.freeThrowPct = freeThrowPct; }
    public Double getMinutesPerGame() { return minutesPerGame; }
    public void setMinutesPerGame(Double minutesPerGame) { this.minutesPerGame = minutesPerGame; }
}
