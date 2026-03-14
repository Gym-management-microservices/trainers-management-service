package TrainerService.controller;

import TrainerService.model.Trainer;
import TrainerService.model.TrainerId;
import TrainerService.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @PostMapping("/register")
    public void registerTrainer(@RequestBody Trainer trainer) {
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
