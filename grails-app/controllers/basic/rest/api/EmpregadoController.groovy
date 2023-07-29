package basic.rest.api

class EmpregadoController {
    static responseFormats = ['json']

    EmpregadoService empregadoService = new EmpregadoService()

    Object index() {
        ArrayList data = empregadoService.index()
        respond([success: true, data: data], status: 200)
    }

    Object show(Long id) {
        Map data = empregadoService.show(id)
        respond([success: true, data: data], status: 200)
    }

    Object save(EmpregadoCommand command) {
        Map data = empregadoService.save(command)
        respond([success: true, data: data], status: 201)
    }

    Object update(EmpregadoCommand command) {
        empregadoService.update(command)
        respond([success: true], status: 204)
    }

    Object delete(Long id) {
        empregadoService.delete(id)
        respond([success: true], status: 204)
    }

    Object handleException(Exception ex) {
        respond([success: false, message: ex.getMessage()], status: 400)
    }
}
