package com.example.fitnesstracker.Services.implementations;

import com.example.fitnesstracker.Entities.MuscleGroup;
import com.example.fitnesstracker.Repositories.MuscleGroupRepository;
import com.example.fitnesstracker.Services.interfaces.IMuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class MuscleGroupService implements IMuscleGroupService {

    @Autowired
    private final MuscleGroupRepository muscleGroupRepository;
    private final Logger logger = Logger.getLogger(MuscleGroupService.class.getName());

    public MuscleGroupService(MuscleGroupRepository muscleGroupRepository) {
        this.muscleGroupRepository = muscleGroupRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public Optional<MuscleGroup> save(MuscleGroup entity) {
        Optional<MuscleGroup> muscleGroupOptional = Optional.empty();
        if (entity == null)
            logger.log(Level.SEVERE, "entity must not be null");
        else {
            try {
                muscleGroupOptional = Optional.ofNullable(muscleGroupRepository.save(entity));
            } catch (DataAccessException e) {
                logger.log(Level.SEVERE, "Failed to create muscle group by name: " + entity.getName());
            }
        }

        return muscleGroupOptional;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public Optional<MuscleGroup> findByName(String name) {
        Optional<MuscleGroup> muscleGroupOptional = Optional.empty();
        if (name == null || name.trim().isEmpty())
            logger.log(Level.SEVERE, "name cannot be empty");
        else {
            try {
                muscleGroupOptional = muscleGroupRepository.findByName(name);
            } catch (DataAccessException e) {
                logger.log(Level.SEVERE, "Failed to find muscle group by name: " + name);
            }
        }

        return muscleGroupOptional;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public Optional<MuscleGroup> findByMuscleGroupId(Long id) {
        Optional<MuscleGroup> muscleGroupOptional = Optional.empty();
        if (id == null)
            logger.log(Level.SEVERE, "id cannot be null");
        else {
            try {
                muscleGroupOptional = muscleGroupRepository.findByMuscleGroupId(id);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Failed to find muscle group by id: " + id);
            }
        }

        return muscleGroupOptional;
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        if (id == null)
            logger.log(Level.SEVERE, "id cannot be null");
        else {
            try {
                muscleGroupRepository.deleteById(id);
            } catch (DataAccessException e) {
                logger.log(Level.SEVERE, "Failed to delete muscle group by id: " + id);
            }
        }
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public boolean existsById(Long id)  {
        boolean exists = false;
        if (id == null)
            logger.log(Level.SEVERE, "id cannot be null");
        else {
            try {
                exists = muscleGroupRepository.existsById(id);
            } catch (DataAccessException e) {
                logger.log(Level.SEVERE, "Failed to resolve the request: " + id);
            }
        }

        return exists;
    }
}
