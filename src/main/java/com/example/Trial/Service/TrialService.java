package com.example.Trial.Service;

import com.example.Trial.Entity.TrialEntity;

import java.util.List;
import java.util.Optional;

public interface TrialService {
    public TrialEntity dataPosting(TrialEntity trialEntity);
    public List<TrialEntity> dataGetting();
    public Optional<TrialEntity> OneDataGet(Long number);
    public TrialEntity updataByName(Long number, String name);
    public void deleteByName(Long id);
    public void deleteByname(String name);

}
