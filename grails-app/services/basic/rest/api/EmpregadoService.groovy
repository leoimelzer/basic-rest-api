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
            departamento: emp.departamentoId
        ]
    }

    ArrayList index() {
        List<Empregado> empregados = Empregado.createCriteria().list {}

        ArrayList response = []

        for (Empregado emp : empregados) {
            response << getResponseObject(emp)
        }

        return response
    }

    Map show(Long id) {
        Empregado emp = Empregado.get(id)

        if (!emp) {
            throw new Exception("Empregado não encontrado.")
        }

        Map response = getResponseObject(emp)
        return response
    }

    Map save(EmpregadoCommand command) {
        Empregado emp = new Empregado()

        emp.nome = command.nome
        emp.departamento = command.departamento
        emp.matricula = command.matricula
        if (command.dataNascimento) emp.dataNascimento = command.dataNascimento

        if (!emp.validate()) {
            throw new Exception("${emp.errors}")
        }

        emp.save(flush: true)

        Map response = getResponseObject(emp)

        return response
    }

    void update(EmpregadoCommand command) {
        Empregado emp = Empregado.get(command.id)

        if (!emp) {
            throw new Exception("Empregado não encontrado.")
        }

        if (command.nome) emp.nome = command.nome
        if (command.dataNascimento) emp.dataNascimento = command.dataNascimento
        if (command.matricula) emp.matricula = command.matricula
        if (command.departamento) emp.departamento = command.departamento

        if (!emp.validate()) {
            throw new Exception("${emp.errors}")
        }

        emp.save(flush: true)
    }

    void delete(Long id) {
        Empregado emp = Empregado.get(id)

        if (!emp) {
            throw new Exception("Empregado não encontrado.")
        }

        emp.delete(flush: true)
    }
}
