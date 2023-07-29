package basic.rest.api

import java.time.LocalDate

class EmpregadoCommand {
    Long id
    String nome
    LocalDate dataNascimento
    Integer matricula
    Long departamentoId
}
