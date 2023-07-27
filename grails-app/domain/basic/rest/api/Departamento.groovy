package basic.rest.api

class Departamento {
    Long id
    String nome

    static hasMany = [empregados: Empregado]

    static constraints = {
        id generator: 'increment', primary: true
        nome nullable: false, blank: false, unique: true, maxSize: 120
    }
}
