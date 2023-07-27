package basic.rest.api

class Departamento {
    Long id
    String nome

    static hasMany = [empregados: Empregado]

    static constraints = {
        id generator: 'assigned', nullable: false, blank: false, primary: true, maxSize: 10
        nome nullable: false, blank: false, unique: true, maxSize: 120
    }
}
