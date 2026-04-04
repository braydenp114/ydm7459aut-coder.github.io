package com.nba.stats.service;

import com.nba.stats.model.Player;
import com.nba.stats.model.PlayerSeasonStats;
import com.nba.stats.repository.PlayerRepository;
import com.nba.stats.repository.PlayerSeasonStatsRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerSeasonStatsRepository statsRepository;

    public PlayerService(PlayerRepository playerRepository, PlayerSeasonStatsRepository statsRepository) {
        this.playerRepository = playerRepository;
        this.statsRepository = statsRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    public List<Player> getPlayersByTeam(Long teamId) {
        return playerRepository.findByTeamId(teamId);
    }

    public List<Player> searchPlayers(String name) {
        return playerRepository.searchByName(name);
    }

    public List<PlayerSeasonStats> getPlayerStats(Long playerId) {
        return statsRepository.findByPlayerId(playerId);
    }

    public List<PlayerSeasonStats> getTopScorers(String season, int limit) {
        return statsRepository.findTopScorersBySeason(season)
                .stream().limit(limit).toList();
    }

    public List<PlayerSeasonStats> getTopRebounders(String season, int limit) {
        return statsRepository.findTopReboundersBySeason(season)
                .stream().limit(limit).toList();
    }

    public List<PlayerSeasonStats> getTopAssists(String season, int limit) {
        return statsRepository.findTopAssistsBySeason(season)
                .stream().limit(limit).toList();
    }
}
