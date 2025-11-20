package com.example.Trial.ServiceImple;

import com.example.Trial.Entity.TrialEntity;
import com.example.Trial.Repository.TrialRepo;
import com.example.Trial.Service.TrialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrialServiceImple implements TrialService {
    @Autowired
    TrialRepo trialRepo;
    @Override
    public TrialEntity dataPosting(TrialEntity trialEntity) {
        return trialRepo.save(trialEntity);
    }

    @Override
    public List<TrialEntity> dataGetting() {
        return trialRepo.findAll();
    }

    @Override
    public Optional<TrialEntity> OneDataGet(Long number) {
        Optional o= trialRepo.findById(number);
        if(o.isPresent()){
            return o;
        }
        return null;
    }

    @Override
    public TrialEntity updataByName(Long number, String name) {
        TrialEntity t1 = trialRepo.findById(number).orElse(null);
        if(t1!=null){
            t1.setName(name);
            return trialRepo.save(t1);
        }
        return null;
    }

    @Override
    public void deleteByName(Long number) {
        TrialEntity t2 = trialRepo.findById(number).orElse(null);
        if(t2!=null){
            trialRepo.delete(t2);
        }
    }

    @Override
    public void deleteByname(String name) {
        trialRepo.deleteByname(name);
    }

}
