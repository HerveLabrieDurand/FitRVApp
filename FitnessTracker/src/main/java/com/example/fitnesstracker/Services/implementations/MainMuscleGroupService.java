package com.example.fitnesstracker.Services.implementations;

import com.example.fitnesstracker.Entities.MainMuscleGroup;
import com.example.fitnesstracker.Repositories.MainMuscleGroupRepository;
import com.example.fitnesstracker.Services.interfaces.IMainMuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class MainMuscleGroupService implements IMainMuscleGroupService {
    private final MainMuscleGroupRepository mainMuscleGroupRepository;
    private final Logger logger = Logger.getLogger(MainMuscleGroupService.class.getName());

    @Autowired
    public MainMuscleGroupService(MainMuscleGroupRepository mainMuscleGroupRepository) {
        this.mainMuscleGroupRepository = mainMuscleGroupRepository;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public Optional<MainMuscleGroup> findByName(String name) {
        Optional<MainMuscleGroup> mainMuscleGroupOptional = Optional.empty();
        if (name == null || name.trim().isEmpty())
            logger.log(Level.SEVERE, "name cannot be empty");
        else {
            try {
                mainMuscleGroupOptional = mainMuscleGroupRepository.findByName(name);
            } catch (DataAccessException e) {
                logger.log(Level.SEVERE, "Failed to find main muscle group by name: " + name);
            }
        }

        return mainMuscleGroupOptional;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public Optional<MainMuscleGroup> findByMainMuscleGroupId(Long id) {
        Optional<MainMuscleGroup> mainMuscleGroupOptional = Optional.empty();
        if (id == null)
            logger.log(Level.SEVERE, "id cannot be null");
        else {
            try {
                mainMuscleGroupOptional = mainMuscleGroupRepository.findByMainMuscleGroupId(id);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Failed to find main muscle group by id: " + id);
            }
        }

        return mainMuscleGroupOptional;
    }
}
