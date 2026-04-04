package com.nba.stats.repository;

import com.nba.stats.model.PlayerSeasonStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerSeasonStatsRepository extends JpaRepository<PlayerSeasonStats, Long> {
    List<PlayerSeasonStats> findByPlayerId(Long playerId);
    List<PlayerSeasonStats> findBySeason(String season);

    @Query("SELECT s FROM PlayerSeasonStats s WHERE s.season = :season ORDER BY s.pointsPerGame DESC")
    List<PlayerSeasonStats> findTopScorersBySeason(String season);

    @Query("SELECT s FROM PlayerSeasonStats s WHERE s.season = :season ORDER BY s.reboundsPerGame DESC")
    List<PlayerSeasonStats> findTopReboundersBySeason(String season);

    @Query("SELECT s FROM PlayerSeasonStats s WHERE s.season = :season ORDER BY s.assistsPerGame DESC")
    List<PlayerSeasonStats> findTopAssistsBySeason(String season);
}
