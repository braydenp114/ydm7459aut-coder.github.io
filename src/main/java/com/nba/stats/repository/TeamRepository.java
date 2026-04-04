package com.nba.stats.repository;

import com.nba.stats.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByAbbreviation(String abbreviation);
    List<Team> findByConference(String conference);
    List<Team> findByDivision(String division);
}
