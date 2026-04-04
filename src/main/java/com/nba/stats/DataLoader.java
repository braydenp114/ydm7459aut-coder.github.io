package com.nba.stats;

import com.nba.stats.model.Player;
import com.nba.stats.model.PlayerSeasonStats;
import com.nba.stats.model.Team;
import com.nba.stats.repository.PlayerRepository;
import com.nba.stats.repository.PlayerSeasonStatsRepository;
import com.nba.stats.repository.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final TeamRepository teamRepo;
    private final PlayerRepository playerRepo;
    private final PlayerSeasonStatsRepository statsRepo;

    public DataLoader(TeamRepository teamRepo, PlayerRepository playerRepo,
                      PlayerSeasonStatsRepository statsRepo) {
        this.teamRepo = teamRepo;
        this.playerRepo = playerRepo;
        this.statsRepo = statsRepo;
    }

    @Override
    public void run(String... args) {
        if (teamRepo.count() > 0) return;

        // Teams
        Team lakers = teamRepo.save(new Team("Lakers", "LAL", "Los Angeles", "Western", "Pacific"));
        Team celtics = teamRepo.save(new Team("Celtics", "BOS", "Boston", "Eastern", "Atlantic"));
        Team warriors = teamRepo.save(new Team("Warriors", "GSW", "Golden State", "Western", "Pacific"));
        Team bucks = teamRepo.save(new Team("Bucks", "MIL", "Milwaukee", "Eastern", "Central"));
        Team nuggets = teamRepo.save(new Team("Nuggets", "DEN", "Denver", "Western", "Northwest"));
        Team heat = teamRepo.save(new Team("Heat", "MIA", "Miami", "Eastern", "Southeast"));
        Team suns = teamRepo.save(new Team("Suns", "PHX", "Phoenix", "Western", "Pacific"));
        Team sixers = teamRepo.save(new Team("76ers", "PHI", "Philadelphia", "Eastern", "Atlantic"));

        // Players
        Player lebron = playerRepo.save(new Player("LeBron", "James", "SF", 23, lakers));
        Player adavis = playerRepo.save(new Player("Anthony", "Davis", "C", 3, lakers));
        Player tatum = playerRepo.save(new Player("Jayson", "Tatum", "SF", 0, celtics));
        Player brown = playerRepo.save(new Player("Jaylen", "Brown", "SG", 7, celtics));
        Player curry = playerRepo.save(new Player("Stephen", "Curry", "PG", 30, warriors));
        Player klay = playerRepo.save(new Player("Klay", "Thompson", "SG", 11, warriors));
        Player giannis = playerRepo.save(new Player("Giannis", "Antetokounmpo", "PF", 34, bucks));
        Player jokic = playerRepo.save(new Player("Nikola", "Jokic", "C", 15, nuggets));
        Player butler = playerRepo.save(new Player("Jimmy", "Butler", "SF", 22, heat));
        Player beal = playerRepo.save(new Player("Bradley", "Beal", "SG", 3, suns));
        Player embiid = playerRepo.save(new Player("Joel", "Embiid", "C", 21, sixers));
        Player maxey = playerRepo.save(new Player("Tyrese", "Maxey", "PG", 0, sixers));

        String season = "2023-24";

        // Season stats
        statsRepo.save(new PlayerSeasonStats(lebron, season, 71, 25.7, 7.3, 8.3, 1.3, 0.5, 0.540, 0.410, 0.750, 35.3));
        statsRepo.save(new PlayerSeasonStats(adavis, season, 76, 24.7, 12.6, 3.5, 1.2, 2.3, 0.558, 0.227, 0.762, 35.5));
        statsRepo.save(new PlayerSeasonStats(tatum, season, 74, 26.9, 8.1, 4.9, 1.1, 0.6, 0.471, 0.371, 0.832, 35.8));
        statsRepo.save(new PlayerSeasonStats(brown, season, 70, 23.0, 5.5, 3.6, 1.2, 0.5, 0.492, 0.354, 0.738, 33.7));
        statsRepo.save(new PlayerSeasonStats(curry, season, 74, 26.4, 4.5, 5.1, 0.9, 0.4, 0.453, 0.408, 0.923, 33.1));
        statsRepo.save(new PlayerSeasonStats(klay, season, 57, 17.9, 3.3, 2.3, 0.8, 0.5, 0.434, 0.383, 0.883, 29.6));
        statsRepo.save(new PlayerSeasonStats(giannis, season, 73, 30.4, 11.5, 6.5, 1.2, 1.1, 0.611, 0.274, 0.657, 35.2));
        statsRepo.save(new PlayerSeasonStats(jokic, season, 79, 26.4, 12.4, 9.0, 1.4, 0.9, 0.583, 0.359, 0.816, 34.6));
        statsRepo.save(new PlayerSeasonStats(butler, season, 60, 20.8, 5.3, 5.0, 1.3, 0.3, 0.534, 0.271, 0.857, 33.3));
        statsRepo.save(new PlayerSeasonStats(beal, season, 53, 18.2, 4.0, 5.0, 0.8, 0.3, 0.480, 0.343, 0.811, 31.0));
        statsRepo.save(new PlayerSeasonStats(embiid, season, 39, 34.7, 11.0, 5.6, 1.2, 1.7, 0.528, 0.380, 0.875, 33.6));
        statsRepo.save(new PlayerSeasonStats(maxey, season, 70, 25.9, 3.7, 6.2, 1.0, 0.3, 0.484, 0.386, 0.874, 35.2));

        System.out.println("NBA Stats data loaded successfully.");
        System.out.println("API available at http://localhost:8080/api");
        System.out.println("  GET /api/teams");
        System.out.println("  GET /api/players");
        System.out.println("  GET /api/stats/leaders");
    }
}
