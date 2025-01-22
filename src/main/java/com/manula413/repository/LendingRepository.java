package com.manula413.repository;

import com.manula413.model.Lending;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LendingRepository extends JpaRepository<Lending, Long> {
}
