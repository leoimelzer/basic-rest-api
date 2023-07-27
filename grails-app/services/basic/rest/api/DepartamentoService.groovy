package basic.rest.api

import grails.gorm.transactions.Transactional

@Transactional
class DepartamentoService {

    List<Departamento> getDepartamentos() {  Departamento.createCriteria().list {} }

    Departamento showDepartamento(Long id) { Departamento.get(id) }

    Departamento addDepartamento(DepartamentoCommand command) {
        Departamento record = new Departamento(nome: command.nome)

        if (!record.validate()) throw new Exception("${record.errors}")

        record.save(flush: true)
        return record
    }

    void editDepartamento(DepartamentoCommand command) {
        Departamento record = Departamento.get(command.id)
        if (!record) return

        record.nome = command.nome
        if (!record.validate()) throw new Exception("${record.errors}")

        record.save(flush: true)
    }

    void removeDepartamento(Long id) {
        Departamento record = Departamento.get(id)

        if (!record) return

        record.delete(flush: true)
    }
}
