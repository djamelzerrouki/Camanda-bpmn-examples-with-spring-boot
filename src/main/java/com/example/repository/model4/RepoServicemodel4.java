package com.example.repository.model4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Service;

@Repository
public interface RepoServicemodel4 extends JpaRepository<Service, Long>{

}