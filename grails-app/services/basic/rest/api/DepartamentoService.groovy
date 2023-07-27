package basic.rest.api

import grails.gorm.transactions.Transactional

@Transactional
class DepartamentoService {

    List<Departamento> index() {  Departamento.createCriteria().list {} }

    Departamento show(Long id) { Departamento.get(id) }

    Departamento save(Long id, String nome) {
        Departamento record = new Departamento()
        record.id = id
        record.nome = nome

        if (!record.validate()) throw new Exception("${record.errors}")

        record.save(flush: true)
        return record
    }

    void update(Long id, String nome) {
        Departamento record = Departamento.get(id)

        if (!record) return
        if (nome) record.nome = nome
        if (!record.validate()) throw new Exception("${record.errors}")

        record.save(flush: true)
    }

    void delete(Long id) {
        Departamento record = Departamento.get(id)
        if (!record) return
        record.delete(flush: true)
    }
}
