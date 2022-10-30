package com.api.order.repository;

import com.api.order.domain.Category;
import com.api.order.domain.State;
import com.api.order.domain.response.CategoryResponse;
import com.api.order.domain.response.StateResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
    @Query("SELECT NEW com.api.order.domain.response.StateResponse(s.stateId, s.name) FROM State s where s.name=:name")
    Optional<StateResponse> findByName(@Param("name") String name);
}
