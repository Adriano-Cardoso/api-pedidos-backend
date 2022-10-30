package com.api.order.repository;

import com.api.order.domain.City;
import com.api.order.domain.State;
import com.api.order.domain.response.CityResponse;
import com.api.order.domain.response.StateResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    @Query("SELECT NEW com.api.order.domain.response.CityResponse(c.cityId, c.name, c.stateId) FROM City c where c.name=:name")
    Optional<CityResponse> findByName(@Param("name") String name);
}
