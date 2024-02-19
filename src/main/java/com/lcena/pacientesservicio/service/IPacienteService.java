package com.lcena.pacientesservicio.service;

import com.lcena.pacientesservicio.model.Paciente;

import java.util.List;

public interface IPacienteService {
    public List<Paciente> getPacientes();

    public void savePaciente(Paciente paciente);

    public void deletePaciente(Long id);

    public Paciente findPacienteById(Long id);

    public Paciente findPacienteByDni(Integer dni);

    public void editPaciente(Long id, Paciente paciente);

}
