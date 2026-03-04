# Sistema de Gestión de Pedidos  
Proyecto – Ingeniería de Software 1

## 📌 Descripción

Sistema básico para gestionar pedidos en una tienda en línea.  
Permite:

- Crear pedidos
- Confirmar pedidos
- Cancelar pedidos
- Aplicar validaciones
- Registrar actividad
- Simular transacciones

El proyecto integra:
- Arquitectura en Capas
- Command
- Decorator
- Prototype
- Unit of Work
- Principios SOLID

---

## 🏗 Arquitectura

El sistema está organizado en capas:
presentation → application → domain → infrastructure

Cada capa tiene una responsabilidad específica y dependencias unidireccionales.

---

## 📂 Estructura del Proyecto

### 📁 src/presentation
Contiene los comandos y el controlador.  
Implementa el patrón **Command**.

### 📁 src/application
Contiene los casos de uso y la lógica de aplicación.  
Coordina el dominio y la persistencia.

### 📁 src/application/decorators
Decoradores que agregan:
- Validación
- Logging
- Seguridad  
Implementa el patrón **Decorator**.

### 📁 src/domain
Modelo del negocio:
- Pedido
- Producto
- PedidoPrototype  
Implementa el patrón **Prototype**.

### 📁 src/infrastructure
Simulación de base de datos:
- Repositorio
- DatabaseContext
- UnitOfWork  
Implementa **Unit of Work**.

### 📁 src/main
Clase `Main` para ejecutar y probar el sistema.

---

## ▶ Ejecución

Desde la carpeta `src`:


javac main/Main.java
java main.Main


---

## 📸 Programa funcionando
<img width="1102" height="375" alt="image" src="https://github.com/user-attachments/assets/cdc67a61-d2e0-4bb1-b6cf-d3cd3e5702f1" />
