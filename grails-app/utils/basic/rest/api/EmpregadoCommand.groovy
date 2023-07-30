package basic.rest.api

import grails.validation.Validateable

import java.time.LocalDate

class EmpregadoCommand implements Validateable {
    Long id
    String nome
    LocalDate dataNascimento
    Integer matricula
    Long departamentoId

    static constraints = {
        id generator: 'increment', primary: true
        nome nullable: false, blank: false, maxSize: 120
        matricula nullable: false, unique: 'departamento'
    }
}
