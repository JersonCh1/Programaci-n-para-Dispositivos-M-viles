# Editor de Perfil con Confirmación

## Descripción
Esta aplicación para Android permite a los usuarios completar un formulario con su información personal, visualizar un resumen de los datos ingresados y confirmar o editar la información.

## Funcionalidades
- **Formulario de datos**: Captura nombre, edad, ciudad y correo electrónico del usuario
- **Visualización de resumen**: Muestra los datos ingresados para su verificación
- **Confirmación o edición**: Permite confirmar los datos o volver al formulario para editarlos
- **Persistencia de datos**: Conserva la información cuando el dispositivo cambia de orientación

## Tecnologías implementadas
- Kotlin
- Arquitectura de múltiples actividades
- Objetos Parcelable para transferencia de datos
- ActivityResult API para comunicación entre actividades
- onSaveInstanceState() para manejo de cambios de configuración

## Estructura del proyecto
- **FormularioActivity**: Actividad principal con campos para ingresar datos
- **ResumenActivity**: Actividad secundaria que muestra el resumen de la información
- **Usuario**: Clase de datos Parcelable para transferir información entre actividades

## Autor
Jerson
Fecha: Abril 2025

## Curso
Programación para Dispositivos Móviles
