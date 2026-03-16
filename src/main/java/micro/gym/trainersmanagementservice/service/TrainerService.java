package micro.gym.trainersmanagementservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import micro.gym.trainersmanagementservice.model.Trainer;
import micro.gym.trainersmanagementservice.model.TrainerId;
import micro.gym.trainersmanagementservice.repository.TrainerRepository;

import java.util.List;


@Service
public class TrainerService {
    @Autowired
    private TrainerRepository trainerRepository;

    public void registerTrainer(Trainer entrenador) {
        trainerRepository.save(entrenador);
        System.out.println("Trainer " + entrenador.getName() + " registered correctly");
    }
    public List<Trainer> getTrainers(){
        return trainerRepository.findAll();
    }
    public Boolean searchTrainer(TrainerId entrenadorId) {
        if (trainerRepository.findById(entrenadorId).isPresent())
            return true;
        else{
            System.out.println("The trainer does not exist");
            return false;
        }
    }
}
