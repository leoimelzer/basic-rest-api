package basic.rest.api

import grails.gorm.transactions.Transactional

import java.time.format.DateTimeFormatter

@Transactional
class EmpregadoService {

    private static Map getResponseObject(Empregado emp) {
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy")

        return [
            id: emp.id,
            nome: emp.nome,
            matricula: emp.matricula,
            dataNascimento: emp.dataNascimento.format(FORMATTER),
            departamentoId: emp.departamentoId
        ]
    }

    ArrayList index() {
        ArrayList response = []
        List<Empregado> empregados = Empregado.createCriteria().list {}

        for (Empregado emp : empregados) {
            response << getResponseObject(emp)
        }

        return response
    }

    Map show(Long id) {
        Empregado emp = Empregado.get(id)

        if (!emp) throw new Exception("Empregado não encontrado.")

        Map response = getResponseObject(emp)
        return response
    }

    Map save(EmpregadoCommand command) {
        Departamento departamento = Departamento.get(command.departamentoId)

        if (!departamento) throw new Exception("Departamento não encontrado.")

        if (Empregado.findByDepartamentoAndMatricula(departamento, command.matricula)) {
            throw new Exception("Matrícula já cadastrada para este departamento.")
        }

        Empregado empregado = new Empregado()
        empregado.nome = command.nome
        empregado.departamento = departamento
        empregado.matricula = command.matricula
        if (command.dataNascimento) empregado.dataNascimento = command.dataNascimento

        if (!empregado.validate()) {
            throw new Exception("${empregado.errors}")
        }

        empregado.save(flush: true)
        Map response = getResponseObject(empregado)
        return response
    }

    void update(EmpregadoCommand command) {
        Empregado empregado = Empregado.get(command.id)
        if (!empregado) throw new Exception("Empregado não encontrado.")

        Departamento departamento = Departamento.get(command.departamentoId ?: empregado.departamentoId)
        if (!departamento) throw new Exception("Departamento não encontrado.")

        /*
          Realizará a busca de um empregado conforme os parâmetros recebidos, caso os valores obtidos em
          "departamentoId" e "matrícula" levem a um empregado já cadastrado e diferente do empregado editado
          retornará o erro tratado informando da violação da UK
        */
        Integer matricula = command.matricula ?: empregado.matricula
        Empregado existentEmpregado = Empregado.findByDepartamentoAndMatricula(departamento, matricula)

        if (existentEmpregado && existentEmpregado !== empregado) {
            throw new Exception("Matrícula já cadastrada para este departamento.")
        }

        if (command.nome) empregado.nome = command.nome
        if (command.dataNascimento) empregado.dataNascimento = command.dataNascimento
        if (command.matricula) empregado.matricula = command.matricula
        if (command.departamentoId) empregado.departamento = Departamento.findById(command.departamentoId)

        if (!empregado.validate()) throw new Exception("${empregado.errors}")

        empregado.save(flush: true)
    }

    void delete(Long id) {
        Empregado emp = Empregado.get(id)

        if (!emp) throw new Exception("Empregado não encontrado.")

        emp.delete(flush: true)
    }
}
