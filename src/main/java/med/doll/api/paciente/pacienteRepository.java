package med.doll.api.paciente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface pacienteRepository extends JpaRepository<Paciente, Long> {
}
