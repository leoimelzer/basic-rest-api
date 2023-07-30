package basic.rest.api

import grails.validation.Validateable

class DepartamentoCommand implements Validateable {
    Long id
    String nome

    static constraints = {
        id generator: 'increment', primary: true
        nome nullable: false, blank: false, unique: true, maxSize: 120
    }
}
