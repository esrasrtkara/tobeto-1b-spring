package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
}
