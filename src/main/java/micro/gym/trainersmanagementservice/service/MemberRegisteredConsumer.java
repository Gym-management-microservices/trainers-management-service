package micro.gym.trainersmanagementservice.service;


import micro.gym.trainersmanagementservice.dto.MemberRegisteredEventDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MemberRegisteredConsumer {

    @RabbitListener(queues = "inscripciones.queue")
    public void recibirInscripcion(MemberRegisteredEventDTO event) {
        System.out.println("Nuevo miembro inscrito:");
        System.out.println("  ID:     " + event.getMemberId());
        System.out.println("  Nombre: " + event.getMemberName());
        System.out.println("  Email:  " + event.getEmail());
    }
}
