package com.example.Trial.Repository;

import com.example.Trial.Entity.TrialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrialRepo extends JpaRepository<TrialEntity,Long>{
    public void deleteByname(String name);
}