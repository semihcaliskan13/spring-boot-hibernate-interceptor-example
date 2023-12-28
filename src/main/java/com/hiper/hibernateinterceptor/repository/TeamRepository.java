package com.hiper.hibernateinterceptor.repository;

import com.hiper.hibernateinterceptor.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}
