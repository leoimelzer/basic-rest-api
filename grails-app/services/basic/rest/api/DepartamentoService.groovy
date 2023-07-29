package basic.rest.api

import grails.gorm.transactions.Transactional

@Transactional
class DepartamentoService {

    List<Departamento> index() { Departamento.createCriteria().list {} }

    Departamento show(Long id) {
        Departamento departamento = Departamento.get(id)

        if (!departamento) throw new Exception("Departamento não encontrado.")

        return departamento
    }

    Departamento save(DepartamentoCommand command) {
        if (Departamento.findByNome(command.nome)) {
            throw new Exception("Departamento já cadastrado com este nome.")
        }

        Departamento departamento = new Departamento()
        departamento.nome = command.nome

        if (!departamento.validate()) throw new Exception("${departamento.errors}")

        departamento.save(flush: true)
        return departamento
    }

    void update(DepartamentoCommand command) {
        Departamento departamento = Departamento.get(command.id)
        if (!departamento) throw new Exception("Departamento não encontrado.")

        /*
          Realizará a busca de um departamento conforme o nome recebido em command.nome,
          caso exista um departamento com o nome recebido e este seja diferente do registro sendo editado
          retornará o erro tratado informando da violação da UK
        */
        Departamento existentDepartamento = Departamento.findByNome(command.nome ?: departamento.nome)

        if (existentDepartamento && existentDepartamento !== departamento) {
            throw new Exception("Departamento já cadastrado com este nome.")
        }

        if (command.nome) departamento.nome = command.nome
        if (!departamento.validate()) throw new Exception("${departamento.errors}")

        departamento.save(flush: true)
    }

    void delete(Long id) {
        Departamento departamento = Departamento.get(id)

        if (!departamento) throw new Exception("Departamento não encontrado.")

        departamento.delete(flush: true)
    }
}
