package basic.rest.api

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes='id')
class Departamento {
    Long id
    String nome

    static hasMany = [empregados: Empregado]

    static constraints = {
        id generator: 'increment', primary: true
        nome nullable: false, blank: false, unique: true, maxSize: 120
    }
}
