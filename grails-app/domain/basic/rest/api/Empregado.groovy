package basic.rest.api

import java.time.LocalDate

class Empregado {
    Long id
    String nome
    LocalDate dataNascimento
    Integer matricula

    static belongsTo = [departamento: Departamento]

    static constraints = {
        id generator: 'increment', primary: true
        nome nullable: false, blank: false, maxSize: 120
        matricula nullable: false, unique: 'departamento'
    }
}
