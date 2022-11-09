package com.example.demo.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.data.entity.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

}
