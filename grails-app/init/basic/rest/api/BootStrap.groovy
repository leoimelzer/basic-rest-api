package basic.rest.api

import java.time.LocalDate

class BootStrap {
    DepartamentoService departamentoService = new DepartamentoService()
    EmpregadoService empregadoService = new EmpregadoService()

    def init = { servletContext ->
        println "Initializing data..."

        departamentoService.save(new DepartamentoCommand(nome: "Insoft4 Sistemas de Informação"))
        departamentoService.save(new DepartamentoCommand(nome: "Insoft4 Equipamentos"))
        empregadoService.save(new EmpregadoCommand(
            nome: "Keith",
            dataNascimento: LocalDate.of(2000, 7, 29),
            matricula: 1,
            departamentoId: 2
            )
        )
        empregadoService.save(new EmpregadoCommand(
            nome: "Alice",
            dataNascimento: LocalDate.of(1998, 8, 16),
            matricula: 1,
            departamentoId:
                        1
            )
        )
        empregadoService.save(new EmpregadoCommand(
            nome: "Robin",
            dataNascimento: LocalDate.of(1992, 7, 20),
            matricula: 2,
            departamentoId: 1
            )
        )
        empregadoService.save(new EmpregadoCommand(
            nome: "Woody",
            dataNascimento: LocalDate.of(1995, 11, 15),
            matricula: 2,
            departamentoId: 2
            )
        )
        empregadoService.save(new EmpregadoCommand(
            nome: "Guthrie",
            dataNascimento: LocalDate.of(2002, 03, 23),
            matricula: 3,
            departamentoId: 1
            )
        )
    }
    def destroy = {
    }
}
