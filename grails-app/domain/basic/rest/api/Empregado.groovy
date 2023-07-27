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
        nome nullable: false, blank: false, unique: true, maxSize: 120
        dataNascimento nullable: true, blank: false
        matricula nullable: false, blank: false, unique: true
        departamento nullable: false
    }

}
