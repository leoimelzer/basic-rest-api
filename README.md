# basic-rest-api

A simple grails project, containing CRUDs for departaments and employees manipulation.

## Departamento

### Index

**Request:**
- **Method:** _GET_
- **Endpoint:** _/departamento_
- **Example:** _http://localhost:8080/basic-rest-api/departamento_
- **Params:** none
- **Headers:** none
- **Body:** _raw json_

---

**Response:**

- **Status:** _200 OK_
  - **Body:**
    - ```json
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

- **Status:** _400 Bad Request_
- **Body:**
  - ```json
    {
        "success": "false",
        "message": "error-message"
    }
    ```

### Show

**Request:**
- **Method:** _GET_
- **Endpoint:** _/departamento/?_
- **Example:** _http://localhost:8080/basic-rest-api/departamento/1_
- **Params:** none
- **Headers:** none
- **Body:** _raw json_

**Response:**

- **Status:** _200 OK_
- **Body:**
  - ```json
      {
        "success": true,
        "data": {
          "id": 1,
          "nome": "Sistemas de Informação"
        }
      }
      ```

---

- **Status:** _400 Bad Request_
- **Body:**
  - ```json
    {
        "success": "false",
        "message": "error-message"
    }
    ```

### Save

**Request:**
- **Method:** _POST_
- **Endpoint:** _/departamento_
- **Example:** _http://localhost:8080/basic-rest-api/departamento_
- **Params:** none
- **Headers:** none
- **Body:** _raw json_
  - ```json
    {
        "id": "",
        "nome": ""
    }
    ```

---

**Response:**
- **Status:** _201 Created_
- **Body:**
  - ```json
    {
    "success": true,
        "data": {
            "id": 1,
            "nome": "Sistemas de Informação"
        }
    }
    ```

---

- **Status:** _400 Bad Request_
- **Body:**
  - ```json
    {
        "success": "false",
        "message": "error-message"
    }
    ```

### Update

**Request:**
- **Method:** _UPDATE_
- **Endpoint:** _/departamento_
- **Example:** _http://localhost:8080/basic-rest-api/departamento_
- **Params:** none
- **Headers:** none
- **Body:** _raw json_
  - ```json
    {
        "id": "",
        "nome": ""
    }
    ```

---

**Response:**
- **Status:** _204 No Content_
- **Body:** none

---

- **Status:** _400 Bad Request_
- **Body:**
  - ```json
    {
        "success": "false",
        "message": "error-message"
    }
    ```

### Delete

**Request:**
- **Method:** _DELETE_
- **Endpoint:** _/departamento_
- **Example:** _http://localhost:8080/basic-rest-api/departamento_
- **Params:** none
- **Headers:** none
- **Body:** _raw json_
  - ```json
    {
        "id": "",
        "nome": ""
    }
    ```

---

**Response:**
- **Status:** _204 No Content_
- **Body:** none

---

- **Status:** _400 Bad Request_
- **Body:**
  - ```json
    {
        "success": "false",
        "message": "error-message"
    }
    ```