# P_reserve_natural

This API allows the management of a nature reserve, including animal administration, secure authentication with Basic Auth and session management with cookies.


**Technologies Used**

  - Java 21
  - Spring Boot 3.4.1
  - Spring Security
  - Spring Data JPA
  - H2 Database/MySQL
  - maven
  - Docker

- **API endpoints**:

  <pre> ``` | HTTP Method | Endpoint | Description | Authorization | |------------|---------------------------|---------------------------------------------------|--------------| | GET | /api/animals | Get a paginated list of all animals (max 20) | Public | | GET | /api/animals/family/{name} | Get animals by family (max 10) | Public | | GET | /api/animals/country/{name}| Get animals by country (no pagination) | Public | | GET | /api/animals/type/{name} | Get animals by type and family | Public | | GET | /api/animals/count | Get the total number of animals | Admin | | GET | /api/animals/{name} | Get a specific animal by name | Admin | | POST | /api/animals | Add a new animal | Admin | | PUT | /api/animals/{id} | Update an existing animal | Admin | | DELETE | /api/animals/{id} | Delete an animal | Admin | | POST | /api/auth/login | Authenticate and get session cookies | Public | | POST | /api/auth/logout | Logout and clear session cookies | Public | ``` </pre>

- **Diagram**:
[![Captura-desde-2025-01-31-23-06-59.png](https://i.postimg.cc/g2YKLB5k/Captura-desde-2025-01-31-23-06-59.png)](https://postimg.cc/BXVFdN4d)
    

## Autor

**Mariel Blanco**
