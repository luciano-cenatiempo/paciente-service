package com.lcena.pacientesservicio.controller;

import com.lcena.pacientesservicio.model.Paciente;
import com.lcena.pacientesservicio.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PacienteController {
    @Autowired
    IPacienteService pacienteService;

    // Obtener todos los pacientes
    @GetMapping("/pacientes/traer")
    public List<Paciente> getPacientes(){
        return pacienteService.getPacientes();

    }

    // crear un paciente
    @PostMapping("/pacientes/crear")
    public String createPaciente(@RequestBody Paciente paciente){
        pacienteService.savePaciente(paciente);
        return "Paciente creado correctamente";
    }

    // eliminar un paciente
    @DeleteMapping("/pacientes/eliminar/{id}")
    public String deletePaciente(@PathVariable Long id){
        Paciente pacienteDb= pacienteService.findPacienteById(id);
        if (pacienteDb != null){
            pacienteService.deletePaciente(id);
            return "El paciente fue eliminado correctamente";

        }
        return "No existe paciente con el ID indicado";

    }

    // editar un paciente
    @PutMapping("/paciente/editar/{id}")
    public Paciente editPaciente(@PathVariable Long id, @RequestBody Paciente paciente){
        Paciente pacienteDb = pacienteService.findPacienteById(id);
        if (pacienteDb != null){
            pacienteService.editPaciente(id,paciente);
            return pacienteService.findPacienteById(id);
        }
        // si no existe el paciente se devuelve null
        return null;
    }

    // Obtener un paciente
    @GetMapping("/pacientes/traer/{id}")
    public Paciente getPaciente(@PathVariable Long id){
        return pacienteService.findPacienteById(id);
    }


}
