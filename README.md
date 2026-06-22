# ModeloPersonasLlanquihueTour - Desarrollo Orientado a Objetos

## Autor del proyecto

* **Nombre completo:** Emilio Nuñez Jara
* **Sección:** PRY2202-008A
* **Carrera:** Analista Programador Computacional
* **Sede:** Campus Virtual

---

## Descripción general del sistema

Proyecto desarrollado en Java para la agencia turística **Llanquihue Tour**.

El sistema permite gestionar información de:

* Clientes
* Empleados
* Proveedores

El proyecto aplica conceptos de Programación Orientada a Objetos, tales como:

* Encapsulamiento
* Herencia
* Composición
* Constructores
* Getters y setters
* Sobreescritura del método `toString()`
* Uso de colecciones dinámicas `ArrayList`
* Lectura y escritura de archivos de texto
* Validaciones básicas mediante `try-catch`

El objetivo del sistema es automatizar tareas básicas de registro, búsqueda, modificación, filtrado y visualización de información por consola.

---

## Funcionalidades del sistema

### Clientes

* Registrar clientes.
* Mostrar clientes registrados.
* Buscar clientes por RUT.
* Modificar datos de clientes.

### Empleados

* Registrar empleados.
* Mostrar empleados registrados.
* Buscar empleados por RUT.
* Modificar datos de empleados.
* Filtrar empleados por rol.

Los roles utilizados para empleados son:

* Guía
* Operador

### Proveedores

* Registrar proveedores.
* Mostrar proveedores registrados.
* Buscar proveedores por RUT.
* Modificar datos de proveedores.

---

## Estructura general del proyecto

```plaintext
📁 src/
│
├── APP/
│   └── Main.java
│
├── MODEL/
│   ├── Persona.java
│   ├── Direccion.java
│   ├── Empleado.java
│   └── Proveedor.java
│
├── SERVICE/
│   ├── PersonaService.java
│   ├── EmpleadoService.java
│   ├── ProveedorService.java
│   ├── ArchivoService.java
│   ├── ArchivoEmpleadoService.java
│   └── ArchivoProveedorService.java
│
└── UTIL/
    └── Validaciones.java
```

---

## Archivos de datos

El sistema utiliza una carpeta llamada `data` para almacenar la información en archivos de texto.

```plaintext
📁 data/
├── cliente.txt
├── colaboradores.txt
└── proveedores.txt
```

Cada archivo cumple una función específica:

* `cliente.txt`: almacena los datos de clientes.
* `colaboradores.txt`: almacena los datos de empleados.
* `proveedores.txt`: almacena los datos de proveedores.

Si la carpeta `data` o los archivos de texto no existen, el sistema los crea automáticamente al guardar información por primera vez.

---

## Clases principales

### Persona

Representa la información base de una persona.

Contiene:

* RUT
* Nombre
* Teléfono
* Email
* Dirección

### Direccion

Representa la dirección asociada a una persona.

Contiene:

* Calle
* Comuna
* Ciudad

Esta clase se relaciona con `Persona` mediante composición, ya que cada persona posee una dirección.

### Empleado

Hereda de la clase `Persona`.

Además de los datos generales, contiene:

* Cargo
* Sueldo
* Rol

### Proveedor

Hereda de la clase `Persona`.

Además de los datos generales, contiene:

* Empresa
* Servicio prestado

---

## Conceptos de Programación Orientada a Objetos aplicados

### Encapsulamiento

Los atributos de las clases se encuentran declarados como `private`, accediendo a ellos mediante métodos `get` y `set`.

### Herencia

Las clases `Empleado` y `Proveedor` heredan de la clase `Persona`.

### Composición

La clase `Persona` contiene un objeto de tipo `Direccion`.

### Sobreescritura

Las clases implementan el método `toString()` para mostrar la información de forma ordenada por consola.

---

## Validaciones implementadas

El sistema cuenta con una clase `Validaciones`, encargada de verificar los datos ingresados por el usuario.

Se validan datos como:

* RUT no vacío y con formato válido.
* Nombre solo con letras.
* Teléfono con formato válido.
* Email con formato válido.
* Rol válido para empleados.
* Evitar registros duplicados por RUT.

---

## Instrucciones para clonar y ejecutar el proyecto

### 1. Clonar el repositorio desde GitHub

```bash
git clone https://github.com/enunezj/ModeloPersonasLlanquihueTour.git
```

### 2. Abrir el proyecto

Abrir la carpeta del proyecto en **IntelliJ IDEA**.

### 3. Ejecutar el sistema

Ejecutar la clase principal:

```plaintext
src/APP/Main.java
```

o ejecutar directamente la clase:

```java
APP.Main
```

---

## Ejecución por consola

Al ejecutar el sistema, se muestra un menú con opciones para:

```plaintext
1. Agregar cliente
2. Mostrar clientes
3. Buscar cliente por RUT
4. Agregar empleado
5. Mostrar empleados
6. Buscar empleado por RUT
7. Modificar cliente
8. Modificar empleado
9. Filtrar empleados por rol
10. Agregar proveedor
11. Mostrar proveedores
12. Buscar proveedor por RUT
13. Modificar proveedor
0. Salir
```

---

## Tecnologías utilizadas

* Java
* IntelliJ IDEA
* Git
* GitHub

---

## Repositorio GitHub

https://github.com/enunezj/ModeloPersonasLlanquihueTour

---

## Fecha de entrega

21/06/2026
