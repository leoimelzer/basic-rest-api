package basic.rest.api

class DepartamentoController {
	static responseFormats = ['json']

    DepartamentoService departamentoService = new DepartamentoService()

    Object index() {
        List<Departamento> data = departamentoService.index()
        respond([success: true, data: data], status: 200)
    }

    Object show(Long id) {
        Departamento data = departamentoService.show(id)
        respond([success: true, data: data], status: 200)
    }

    Object save(DepartamentoCommand command) {
        Departamento data = departamentoService.save(command)
        respond([success: true, data: data], status: 201)
    }

    Object update(DepartamentoCommand command) {
        departamentoService.update(command)
        respond([success: true], status: 204)
    }

    Object delete(Long id) {
        departamentoService.delete(id)
        respond([success: true], status: 204)
    }

    Object handleException(Exception ex) {
        respond([success: false, message: ex.getMessage()], status: 400)
    }
}
