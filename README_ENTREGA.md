# SIGTAL-API-AA5-EV01

## Evidencia de desempeño GA7-220501096-AA5-EV01
### Diseño y desarrollo de servicios web - caso

**Proyecto:** SIGTAL - Sistema Integral de Gestión para Taller Automotriz Electricista Londoño  
**Evidencia:** GA7-220501096-AA5-EV01  
**Tipo:** Servicio Web REST API  
**Lenguaje:** Java 21  
**Framework:** Spring Boot 3.5.6  
**Gestor de dependencias:** Maven  
**Base de datos:** MySQL  
**ORM:** Spring Data JPA / Hibernate  
**Servidor:** Tomcat embebido  
**Puerto:** 8080  
**Versionamiento:** Git  
**Repositorio:** https://github.com/MauricioPolo306/SIGTAL-API-AA5-EV01

---

## 1. Descripción

El proyecto implementa un servicio web REST para el registro y autenticación de usuarios, de acuerdo con los requerimientos de la evidencia GA7-220501096-AA5-EV01.

El servicio permite registrar usuarios en MySQL y realizar el inicio de sesión mediante usuario y contraseña. Cuando las credenciales son correctas se devuelve:

`Autenticación satisfactoria.`

Cuando la contraseña es incorrecta se devuelve:

`Contraseña incorrecta.`

El código contiene comentarios explicativos y el proyecto utiliza Git y GitHub para el control de versiones.

## 2. Objetivos

- Registrar usuarios.
- Almacenar usuarios en MySQL.
- Validar usuarios existentes.
- Autenticar mediante usuario y contraseña.
- Validar el estado del usuario.
- Devolver mensajes de éxito o error.
- Mantener código comentado.
- Utilizar Git para versionamiento.
- Publicar el proyecto en GitHub.

## 3. Tecnologías

| Tecnología | Uso |
|---|---|
| Java 21.0.12 | Lenguaje |
| Spring Boot 3.5.6 | Framework |
| Maven 3.9.16 | Construcción y dependencias |
| MySQL/MariaDB | Base de datos |
| Spring Data JPA | Persistencia |
| Hibernate | ORM |
| Apache Tomcat | Servidor embebido |
| Git | Control de versiones |
| GitHub | Repositorio |
| NetBeans | IDE |
| PowerShell | Pruebas |

## 4. Estructura principal

SIGTAL-API-AA5-EV01
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/com/sigtal/api/
│   │   │   ├── App.java
│   │   │   ├── SigtalApiApplication.java
│   │   │   ├── controller/AuthController.java
│   │   │   ├── dto/UsuarioResponse.java
│   │   │   ├── model/Usuario.java
│   │   │   ├── repository/UsuarioRepository.java
│   │   │   └── service/AuthService.java
│   │   └── resources/application.properties
│   └── test/
├── .gitignore
├── pom.xml
└── README_ENTREGA.md

## 5. Endpoints

### Registro

**POST**

`http://localhost:8080/api/auth/registro`

Ejemplo:

json
{
  "nombre": "Usuario Prueba",
  "usuario": "prueba",
  "password": "123456",
  "rol": "USUARIO",
  "estado": "ACTIVO"
}

### Inicio de sesión

**POST**

`http://localhost:8080/api/auth/login`

Ejemplo correcto:

json
{
  "usuario": "prueba",
  "password": "123456"
} 

Respuesta:

Autenticación satisfactoria.

Ejemplo con contraseña incorrecta:

json
{
  "usuario": "prueba",
  "password": "999999"
}

Respuesta:

Contraseña incorrecta.

Código HTTP:

`401 Unauthorized`

## 6. Pruebas realizadas

Registro:

powershell
Invoke-RestMethod `
  -Uri "http://localhost:8080/api/auth/registro" `
  -Method POST `
  -ContentType "application/json" `
  -Body '{"nombre":"Usuario Prueba","usuario":"prueba","password":"123456","rol":"USUARIO","estado":"ACTIVO"}'

Login correcto:

powershell
Invoke-RestMethod `
  -Uri "http://localhost:8080/api/auth/login" `
  -Method POST `
  -ContentType "application/json" `
  -Body '{"usuario":"prueba","password":"123456"}'

Resultado:

Autenticación satisfactoria.

Login con contraseña incorrecta:

powershell
Invoke-RestMethod `
  -Uri "http://localhost:8080/api/auth/login" `
  -Method POST `
  -ContentType "application/json" `
  -Body '{"usuario":"prueba","password":"999999"}'

Resultado:

Contraseña incorrecta.

## 7. Prueba Maven

Se ejecutó:

powershell
mvn test

Resultado:

Tests run: 1
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS

## 8. Ejecución

Desde la carpeta del proyecto:

powershell
cd "C:\Users\fmaur\OneDrive\Documentos\NetBeansProjects\SIGTAL-API-AA5-EV01"
mvn spring-boot:run

La API queda disponible en:

`http://localhost:8080`

## 9. Versionamiento

Se utilizó Git.

Comandos principales:

powershell
git init
git add .
git commit -m "Creacion API registro y autenticacion AA5 EV01"
git branch -M main
git remote add origin https://github.com/MauricioPolo306/SIGTAL-API-AA5-EV01.git
git push -u origin main

El proyecto se encuentra en la rama:

`main`

## 10. Repositorio

Repositorio oficial:

https://github.com/MauricioPolo306/SIGTAL-API-AA5-EV01

## 11. Cumplimiento de la evidencia

El proyecto cumple los requerimientos principales:

- Servicio web para registro.
- Servicio web para inicio de sesión.
- Validación de usuario y contraseña.
- Mensaje de autenticación satisfactoria.
- Mensaje de error ante contraseña incorrecta.
- Código comentado.
- Uso de Git.
- Repositorio remoto en GitHub.
- Pruebas exitosas mediante Maven y PowerShell.

## 12. Autor

**Mauricio Polo**

**Evidencia:** GA7-220501096-AA5-EV01

**Proyecto:** SIGTAL - Sistema Integral de Gestión para Taller Automotriz Electricista Londoño
