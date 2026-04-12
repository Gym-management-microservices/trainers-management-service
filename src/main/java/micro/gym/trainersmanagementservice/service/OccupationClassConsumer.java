package micro.gym.trainersmanagementservice.service;

import jakarta.transaction.Transactional;
import micro.gym.trainersmanagementservice.model.OffsetCheckpoint;
import micro.gym.trainersmanagementservice.repository.OffsetCheckpointRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import micro.gym.trainersmanagementservice.dto.CurrentOcuppationDTO;

import java.time.LocalDateTime;

@Service
public class OccupationClassConsumer {

    @Autowired
    private OffsetCheckpointRepository checkpointRepository;

    @KafkaListener(topics = "ocupacion-clases", groupId = "trainers-grupo")
    @Transactional
    public void actualizationOcupacion(
            ConsumerRecord<String, CurrentOcuppationDTO> record,
            Acknowledgment acknowledgment) {
        try {
            CurrentOcuppationDTO ocupacion = record.value();

            // Lógica de negocio
            System.out.println("======================================");
            System.out.println("NUEVA INSCRIPCIÓN EN TU CLASE");
            System.out.println("Entrenador : " + ocupacion.getTrainerId());
            System.out.println("Clase      : " + ocupacion.getClassId());
            System.out.println("Personas   : " + ocupacion.getCurrentOccupation());
            System.out.println("Offset     : " + record.offset());
            System.out.println("======================================");

            saveOffset(record.topic(), record.partition(), record.offset());

            acknowledgment.acknowledge();

        } catch (Exception e) {
            System.err.println("Error procesando mensaje en offset "
                    + record.offset() + ": " + e.getMessage());
        }
    }

    private void saveOffset(String topic, int partition, long offset) {
        OffsetCheckpoint checkpoint = checkpointRepository
                .findByTopicAndPartition(topic, partition)
                .orElse(new OffsetCheckpoint(null, topic, partition, offset, LocalDateTime.now()));

        checkpoint.setOffsetValue(offset);
        checkpoint.setUpdatedAt(LocalDateTime.now());
        checkpointRepository.save(checkpoint);

        System.out.println("Checkpoint guardado — Topic: " + topic
                + ", Partition: " + partition
                + ", Offset: " + offset);
    }
}
