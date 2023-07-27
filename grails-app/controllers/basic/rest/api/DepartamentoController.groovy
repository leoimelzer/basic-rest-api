package basic.rest.api


import grails.rest.*
import grails.converters.*

class DepartamentoController {
    DepartamentoService departamentoService = new DepartamentoService()
	static responseFormats = ['json', 'xml']

    Object index() {
        List<Departamento> data = departamentoService.getDepartamentos()
        respond([success: true, data: data], status: 200)
    }

    Object show(Long id) {
        Departamento data = departamentoService.showDepartamento(id)
        respond([success: true, data: data], status: 200)
    }

    Object save(DepartamentoCommand command) {
        Departamento data = departamentoService.addDepartamento(command)
        respond([success: true, data: data], status: 201)
    }

    Object update(DepartamentoCommand command) {
        departamentoService.editDepartamento(command)
        respond([success: true], status: 204)
    }

    Object delete(Long id) {
        departamentoService.removeDepartamento(id)
        respond([success: true], status: 204)
    }

    Object handleException(Exception ex) {
        respond([success: false, message: ex.getMessage()], status: 400)
    }
}
