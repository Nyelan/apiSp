package med.doll.api.domain.medico;

import med.doll.api.domain.consulta.Consulta;
import med.doll.api.domain.endereco.dadosEndereco;
import med.doll.api.domain.paciente.Paciente;
import med.doll.api.domain.paciente.dadosCadastroPaciente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class medicoRepositoryTest {

    @Autowired
    private medicoRepository medicoRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    @DisplayName("Deveria devolver null quando único médico cadastrado não está disponível na data.")
    void escolherMedicoAleatorioLivreNaDataCenario1() {
        // GIVEN OU ARRANGE
        var proximaSegundaAs10 = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10, 0);

        var medico = cadastrarMedico("Paulo", "paulo@meddoll", "123456", Especialidade.CARDIOLOGIA);
        var paciente = cadastrarPaciente("Sara", "sara@gmail.com", "000000000000");
        cadastrarConsulta(medico, paciente, proximaSegundaAs10);

        // WHEN OU ACT
        var medicoLivre =  medicoRepository.escolherMedicoAleatorioLivreNaData(Especialidade.CARDIOLOGIA, proximaSegundaAs10);

        // THEN OU ASSERT
        assertThat(medicoLivre).isNull();
    }

    @Test
    @DisplayName("Deveria devolver médico quando ele estiver disponível na data.")
    void escolherMedicoAleatorioLivreNaDataCenario2() {
        // GIVEN OU ARRANGE
        var proximaSegundaAs10 = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10, 0);

        var medico = cadastrarMedico("Paulo", "paulo@meddoll", "123456", Especialidade.CARDIOLOGIA);

        // WHEN OU ACT
        var medicoLivre =  medicoRepository.escolherMedicoAleatorioLivreNaData(Especialidade.CARDIOLOGIA, proximaSegundaAs10);

        // THEN OU ASSERT
        assertThat(medicoLivre).isEqualTo(medico);
    }









    private void cadastrarConsulta(Medico medico, Paciente paciente, LocalDateTime data) {
        em.persist(new Consulta(null, medico, paciente, data, null));
    }

    private Medico cadastrarMedico(String nome, String email, String crm, Especialidade especialidade) {
        var medico = new Medico(dadosMedico(nome, email, crm, especialidade));
        em.persist(medico);
        return medico;
    }

    private Paciente cadastrarPaciente(String nome, String email, String cpf) {
        var paciente = new Paciente(dadosPaciente(nome, email, cpf));
        em.persist(paciente);
        return paciente;
    }

    private dadosCadastroMedico dadosMedico(String nome, String email, String crm, Especialidade especialidade) {
        return new dadosCadastroMedico(
                nome,
                email,
                "61999999999",
                crm,
                especialidade,
                dadosEndereco()
        );
    }

    private dadosCadastroPaciente dadosPaciente(String nome, String email, String cpf) {
        return new dadosCadastroPaciente(
                nome,
                email,
                "61999999999",
                cpf,
                dadosEndereco()
        );
    }

    private dadosEndereco dadosEndereco() {
        return new dadosEndereco(
                "rua xpto",
                "bairro",
                "00000000",
                "Brasilia",
                "DF",
                null,
                null
        );
    }

}