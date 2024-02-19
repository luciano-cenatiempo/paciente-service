package com.lcena.pacientesservicio.service;

import com.lcena.pacientesservicio.model.Paciente;
import com.lcena.pacientesservicio.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private IPacienteRepository pacienteRepo;

    @Override
    public List<Paciente> getPacientes() {
        return pacienteRepo.findAll();
    }

    @Override
    public void savePaciente(Paciente paciente) {
        pacienteRepo.save(paciente);
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepo.deleteById(id);
    }

    @Override
    public Paciente findPacienteById(Long id) {
        Optional<Paciente> optionalPaciente = pacienteRepo.findById(id);
        if (optionalPaciente.isPresent()){
            return optionalPaciente.get();
        }
        return null;
    }

    @Override
    public Paciente findPacienteByDni(Integer dni) {
        Optional<Paciente> optionalPaciente = pacienteRepo.findByDni(dni);
        if (optionalPaciente.isPresent()){
            return optionalPaciente.get();
        }
        return null;
    }

    @Override
    public void editPaciente(Long id, Paciente paciente) {
        Optional<Paciente> pacienteOptional = pacienteRepo.findById(id);
        if (pacienteOptional.isPresent()){
            pacienteRepo.save(paciente);
        }
    }
}
