package micro.gym.trainersmanagementservice;

import micro.gym.trainersmanagementservice.model.Availability;
import micro.gym.trainersmanagementservice.model.Speciality;
import micro.gym.trainersmanagementservice.model.Trainer;
import micro.gym.trainersmanagementservice.model.TrainerId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import micro.gym.trainersmanagementservice.repository.TrainerRepository;


@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public void run(String... args) throws Exception {
        // Cargar entrenadores de ejemplo
        Trainer entrenador1 = new Trainer();
        entrenador1.setTrainerId(new TrainerId("1"));
        entrenador1.setName("Carlos Rodríguez");
        entrenador1.setSpeciality(new Speciality("Yoga"));
        entrenador1.setAvailability(new Availability("MA-JU 10:30-12:30"));
        trainerRepository.save(entrenador1);

        Trainer entrenador2 = new Trainer();
        entrenador2.setTrainerId(new TrainerId("2"));
        entrenador2.setName("Ana Martínez");
        entrenador2.setSpeciality(new Speciality("Spinning"));
        entrenador2.setAvailability(new Availability("MI-VI 12:30-14:30"));
        trainerRepository.save(entrenador2);

        System.out.println("Datos de ejemplo cargados exitosamente.");
    }
}