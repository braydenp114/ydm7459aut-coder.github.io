package com.nba.stats.controller;

import com.nba.stats.model.PlayerSeasonStats;
import com.nba.stats.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    private final PlayerService playerService;

    public StatsController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/leaders")
    public Map<String, List<PlayerSeasonStats>> getLeaders(
            @RequestParam(defaultValue = "2023-24") String season,
            @RequestParam(defaultValue = "10") int limit) {
        Map<String, List<PlayerSeasonStats>> leaders = new LinkedHashMap<>();
        leaders.put("points", playerService.getTopScorers(season, limit));
        leaders.put("rebounds", playerService.getTopRebounders(season, limit));
        leaders.put("assists", playerService.getTopAssists(season, limit));
        return leaders;
    }

    @GetMapping("/leaders/points")
    public List<PlayerSeasonStats> getPointsLeaders(
            @RequestParam(defaultValue = "2023-24") String season,
            @RequestParam(defaultValue = "10") int limit) {
        return playerService.getTopScorers(season, limit);
    }

    @GetMapping("/leaders/rebounds")
    public List<PlayerSeasonStats> getReboundsLeaders(
            @RequestParam(defaultValue = "2023-24") String season,
            @RequestParam(defaultValue = "10") int limit) {
        return playerService.getTopRebounders(season, limit);
    }

    @GetMapping("/leaders/assists")
    public List<PlayerSeasonStats> getAssistsLeaders(
            @RequestParam(defaultValue = "2023-24") String season,
            @RequestParam(defaultValue = "10") int limit) {
        return playerService.getTopAssists(season, limit);
    }
}
