package ru.practicum.hit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.hit.entity.Hit;

public interface StatsRepository extends JpaRepository<Hit, Long>, HitRepository {

}
