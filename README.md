# basic-rest-api

A simple grails project, containing CRUDs for departaments and employees manipulation.

## Departamento

**Endpoint:** _/departamento_

**Allowed Methods:** _GET_ , _POST_, _PUT_, _DELETE_

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
    "message": "error-message"
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
    "message": "error-message"
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
    "id": "",
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