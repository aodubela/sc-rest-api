package com.belagroup.sc.repository;

import com.belagroup.sc.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Game repository persistence layer
 *
 * @author aodubela
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
