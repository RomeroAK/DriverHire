package com.example.driverhire2.driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    @Query("SELECT d FROM Driver d WHERE d.Idnumber = ?1")
    Optional<Driver> findbyIdnumber(String idNum);

    @Query("SELECT d FROM Driver d WHERE d.experience = ?1")
   Optional<Driver> getByExperience(int experience);



}
