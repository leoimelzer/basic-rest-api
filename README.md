# basic-rest-api

A simple grails project, containing CRUDs for departaments and employees manipulation.

## Departamento

**Endpoint:** _/departamento_

**Allowed Methods:** _GET_, _POST_, _PUT_, _DELETE_

<br/>

### Index

#### Request

- **Method:** _GET_

#### Response

_200 OK:_
```json
{
  "success": true,
  "data": [
      {
          "id": 1,
          "nome": "Sistemas de Informação"
      },
      {
          "id": 2,
          "nome": "Equipamentos"
      }
  ]
}
```

---


_400 Bad Request:_
```json
{
    "success": false,
    "message": "error.message"
}
```


### Show

#### Request

- **Method:** _GET_
- **Append:** _/$id_

#### Response

_200 OK:_
```json
{
  "success": true,
  "data": {
    "id": 1,
    "nome": "Sistemas de Informação"
  }
}
```

---

_400 Bad Request:_
```json
{
    "success": false,
    "message": "error.message"
}
```

### Save

#### Request

- **Method:** _POST_
- **Body:** _raw json_
```json
{
    "nome": ""
}
```

#### Response

_201 Created:_
```
{
    "success": true,
    "data": {
        "id": 1,
        "nome": "Sistemas de Informação"
    }
}
```

---

_400 Bad Request:_
```
{
    "success": false,
    "message": "error.message"
}
```

### Update

#### Request
- **Method:** _PUT_
- **Body:** _raw json_

```json
{
    "id": 0,
    "nome": ""
}
```

#### Response

_204 No Content_

---

_400 Bad Request:_

```json
{
    "success": false,
    "message": "error.message"
}
```

### Delete

#### Request

- **Method:** _DELETE_
- **Append:** _/$id_

#### Response

_204 No Content_

---

_400 Bad Request:_

```json
{
    "success": false,
    "message": "error.message"
}
```

## Empregado

**Endpoint:** _/empregado_

**Allowed Methods:** _GET_, _POST_, _PUT_, _DELETE_

<br/>

### Index

#### Request

- **Method:** _GET_

#### Response

_200 OK:_
```json
{
    "success": true,
    "data": [
        {
            "id": 1,
            "nome": "Keith",
            "matricula": 1,
            "dataNascimento": "29/07/2000",
            "departamentoId": 1
        },
        {
            "id": 2,
            "nome": "Alice",
            "matricula": 1,
            "dataNascimento": "16/08/1998",
            "departamentoId": 2
        }
    ]
}
```

---


_400 Bad Request:_
```json
{
    "success": false,
    "message": "error.message"
}
```


### Show

#### Request

- **Method:** _GET_
- **Append:** _/$id_

#### Response

_200 OK:_
```json
{
    "success": true,
    "data": {
        "id": 1,
        "nome": "Keith",
        "matricula": 1,
        "dataNascimento": "29/07/2000",
        "departamentoId": 1
    },
}
```

---

_400 Bad Request:_
```json
{
    "success": false,
    "message": "error.message"
}
```

### Save

#### Request

- **Method:** _POST_
- **Body:** _raw json_
```json
{
    "nome": "",
    "dataNascimento": "yyyy-MM-dd",
    "matricula": 0,
    "departamentoId": 0
}
```

#### Response

_201 Created:_
```
{
    "success": true,
    "data": {
        "id": 1,
        "nome": "Robin",
        "matricula": 1,
        "dataNascimento": "20/07/1992",
        "departamentoId": 1
    }
}
```

---

_400 Bad Request:_
```
{
    "success": false,
    "message": "error.message"
}
```

### Update

#### Request
- **Method:** _UPDATE_
- **Body:** _raw json_

```json
{
    "id": 0,
    "nome": "",
    "matricula": 0,
    "dataNascimento": "yyyy-MM-dd",
    "departamentoId": 0
}
```

#### Response

_204 No Content_

---

_400 Bad Request:_

```
{
    "success": false,
    "message": "error.message"
}
```

### Delete

#### Request

- **Method:** _DELETE_
- **Append:** _/$id_

#### Response

_204 No Content_

---

_400 Bad Request:_

```
{
    "success": false,
    "message": "error.message"
}
```