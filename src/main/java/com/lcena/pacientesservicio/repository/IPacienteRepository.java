package com.lcena.pacientesservicio.repository;

import com.lcena.pacientesservicio.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Long> {
    public Optional<Paciente> findByDni(Integer dni);
}
