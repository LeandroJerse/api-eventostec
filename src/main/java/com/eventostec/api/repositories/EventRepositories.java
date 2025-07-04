package com.eventostec.api.repositories;

import com.eventostec.api.domain.event.Event;
import com.eventostec.api.domain.event.EventResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface EventRepositories extends JpaRepository<Event, UUID> {

    @Query("SELECT e FROM Event e WHERE e.date >= :currentDate ")
    public Page<Event> findUpComingEvents(@Param("currentDate")Date currentDate, Pageable pageabel);

}
