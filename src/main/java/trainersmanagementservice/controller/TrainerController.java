package trainersmanagementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import trainersmanagementservice.model.Trainer;
import trainersmanagementservice.model.TrainerId;
import trainersmanagementservice.service.TrainerService;

import java.util.List;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @PostMapping("/register")
    @PreAuthorize("hasRole('ADMIN')")
    public void registerMember(@RequestBody Trainer trainer) {
        trainerService.registerTrainer(trainer);
    }
    
    @GetMapping("/trainers")
    @PreAuthorize("hasAnyRole('ADMIN', 'MEMBER')")
    public List<Trainer> getTrainers() {
        return trainerService.getTrainers();
    }
    
    @GetMapping("/search/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TRAINER', 'MEMBER')")
    public Boolean searchTrainer(@PathVariable("id") TrainerId trainerId) {
        return trainerService.searchTrainer(trainerId);
    }
}
