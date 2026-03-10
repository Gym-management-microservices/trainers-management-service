package trainersmanagementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void registerMember(@RequestBody Trainer trainer) {
        trainerService.registerTrainer(trainer);
    }
    @GetMapping("/trainers")
    public List<Trainer> getTrainers() {
        return trainerService.getTrainers();
    }
    @GetMapping("/search/{id}")
    public Boolean searchTrainer(@PathVariable("id") TrainerId trainerId) {
        return trainerService.searchTrainer(trainerId);
    }
}
