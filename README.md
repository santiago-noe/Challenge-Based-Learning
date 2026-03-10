# 📚 ForumHub API

![Java](https://img.shields.io/badge/Java-17-blue?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.5-brightgreen?style=for-the-badge&logo=spring)
![MySQL](https://img.shields.io/badge/MySQL-8.0-orange?style=for-the-badge&logo=mysql)
![JWT](https://img.shields.io/badge/JWT-Security-yellow?style=for-the-badge&logo=json-web-tokens)
![License](https://img.shields.io/badge/License-MIT-red?style=for-the-badge)

<p align="center">
  <img src="https://img.shields.io/github/last-commit/TU_USUARIO/forumhub-api?style=flat-square" alt="Last Commit">
  <img src="https://img.shields.io/github/issues/TU_USUARIO/forumhub-api?style=flat-square" alt="Issues">
  <img src="https://img.shields.io/github/stars/TU_USUARIO/forumhub-api?style=flat-square" alt="Stars">
</p>

## 📋 Descripción del Proyecto

API REST desarrollada para el **Challenge Back End** de Alura Latam. ForumHub es una plataforma que permite a los estudiantes crear, visualizar, actualizar y eliminar tópicos de discusión, similar a un foro tradicional.

### ✨ Características Principales

| Funcionalidad | Estado |
|---------------|--------|
| ✅ CRUD completo de tópicos | Implementado |
| ✅ Autenticación JWT | Implementado |
| ✅ Validaciones de negocio | Implementado |
| ✅ Persistencia con MySQL | Implementado |
| ✅ Paginación en listados | Implementado |
| ✅ Soft delete | Implementado |

---

## 🚀 Tecnologías Utilizadas

| Tecnología | Versión | Descripción |
|------------|---------|-------------|
| ☕ Java | 17 | Lenguaje de programación |
| 🍃 Spring Boot | 3.1.5 | Framework principal |
| 🔒 Spring Security | 3.1.5 | Autenticación y autorización |
| 💾 Spring Data JPA | 3.1.5 | Persistencia de datos |
| 🐬 MySQL | 8.0 | Base de datos |
| 🔑 JWT | 4.4.0 | Tokens de autenticación |
| 📦 Maven | 3.9+ | Gestión de dependencias |

---

## 📦 Estructura del Proyecto
📦 forumhub
┣ 📂 src
┃ ┣ 📂 main
┃ ┃ ┣ 📂 java/com/forumhub
┃ ┃ ┃ ┣ 📂 config # Configuraciones (CORS, Security)
┃ ┃ ┃ ┣ 📂 controller # Controladores REST
┃ ┃ ┃ ┣ 📂 model # Entidades JPA
┃ ┃ ┃ ┣ 📂 repository # Repositorios de datos
┃ ┃ ┃ ┣ 📂 service # Lógica de negocio
┃ ┃ ┃ ┣ 📂 dto # Data Transfer Objects
┃ ┃ ┃ ┗ 📂 security # Seguridad y JWT
┃ ┃ ┗ 📂 resources
┃ ┃ ┗ 📜 application.properties
┃ ┗ 📂 test # Pruebas unitarias
┗ 📜 pom.xml # Dependencias


---

## 🔧 Instalación y Configuración

### 📋 Prerrequisitos

- ☕ **Java JDK 17** o superior
- 📦 **Maven 3.6+**
- 🐬 **MySQL 8.0+**
- 🐙 **Git** (opcional)

### ⚙️ Pasos de Instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/TU_USUARIO/forumhub-api.git
   cd forumhub-api
