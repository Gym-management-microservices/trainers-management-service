package trainersmanagementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import trainersmanagementservice.model.Trainer;
import trainersmanagementservice.model.TrainerId;
import trainersmanagementservice.service.TrainerService;

import java.util.List;

@RestController
@RequestMapping("/trainers")
@Tag(name = "Trainers", description = "Gestión de entrenadores del gimnasio")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Registrar un nuevo entrenador", description = "Crea un nuevo registro de entrenador en el gimnasio. Solo ADMIN puede registrar")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Entrenador registrado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos"),
        @ApiResponse(responseCode = "401", description = "No autenticado"),
        @ApiResponse(responseCode = "403", description = "No tiene permisos")
    })
    public void createTrainer(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos del entrenador a registrar",
            required = true,
            content = @Content(mediaType = "application/json",
                examples = @ExampleObject(value = "{ \"name\": \"Carlos López\", \"email\": \"carlos@example.com\", \"specialization\": \"Musculación\", \"phone\": \"987654321\" }")))
        @RequestBody Trainer trainer) {
        trainerService.registerTrainer(trainer);
    }
    
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MEMBER')")
    @Operation(summary = "Obtener todos los entrenadores", description = "Obtiene el listado completo de todos los entrenadores disponibles")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Entrenadores obtenidos exitosamente",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Trainer.class))),
        @ApiResponse(responseCode = "401", description = "No autenticado"),
        @ApiResponse(responseCode = "403", description = "No tiene permisos")
    })
    public List<Trainer> getTrainers() {
        return trainerService.getTrainers();
    }
    
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TRAINER', 'MEMBER')")
    @Operation(summary = "Buscar entrenador por ID", description = "Busca y obtiene un entrenador específico por su identificador")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Entrenador encontrado"),
        @ApiResponse(responseCode = "404", description = "Entrenador no encontrado"),
        @ApiResponse(responseCode = "401", description = "No autenticado"),
        @ApiResponse(responseCode = "403", description = "No tiene permisos")
    })
    public Boolean searchTrainer(
        @Parameter(description = "ID del entrenador", required = true)
        @PathVariable("id") TrainerId trainerId) {
        return trainerService.searchTrainer(trainerId);
    }
}
