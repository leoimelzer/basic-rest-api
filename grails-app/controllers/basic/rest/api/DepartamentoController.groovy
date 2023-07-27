package basic.rest.api


import grails.rest.*
import grails.converters.*

class DepartamentoController {
    DepartamentoService departamentoService = new DepartamentoService()
	static responseFormats = ['json', 'xml']

    def index() {
        List<Departamento> data = departamentoService.index()

        respond([success: true, data: data], status: 200)
    }

    def show() {
        Long id = Long.parseLong(params.id)
        Departamento data = departamentoService.show(id)

        respond([success: true, data: data], status: 200)
    }

    def save() {
        Long id = Long.parseLong(request.JSON.id)
        String nome = request.JSON.nome
        Departamento data = departamentoService.save(id, nome)

        respond([success: true, data: data], status: 201)
    }

    def update() {
        Long id = Long.parseLong(request.JSON.id)
        String nome = request.JSON.nome
        departamentoService.update(id, nome)

        respond([success: true], status: 204)
    }

    def delete() {
        Long id = Long.parseLong(request.JSON.id)
        departamentoService.delete(id)

        respond([success: true], status: 204)
    }

    def handleException(Exception ex) {
        respond([success: false, message: ex.getMessage()], status: 400)
    }
}
