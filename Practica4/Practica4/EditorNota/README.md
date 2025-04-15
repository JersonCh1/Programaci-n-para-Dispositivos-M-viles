# Editor de Nota Rápida

## Descripción
Esta aplicación para Android permite a los usuarios escribir notas rápidas, visualizarlas en una pantalla secundaria y elegir entre compartirlas o continuar editándolas.

## Funcionalidades
- **Editor de texto**: Interfaz simple para escribir notas de cualquier longitud
- **Visualización**: Pantalla dedicada para revisar el contenido de la nota
- **Opciones de acción**: Posibilidad de compartir la nota o volver a editarla
- **Persistencia de datos**: Conserva el contenido de la nota cuando el dispositivo cambia de orientación

## Tecnologías implementadas
- Kotlin
- Arquitectura de múltiples actividades
- Comunicación entre actividades mediante Intent
- ActivityResult API para devolución de información
- onSaveInstanceState() para manejo de cambios de configuración

## Estructura del proyecto
- **EditorActivity**: Actividad principal con campo de texto para escribir la nota
- **OpcionesActivity**: Actividad secundaria que muestra el contenido y opciones disponibles

## Capturas de pantalla
[Aquí se insertarían capturas de pantalla de la aplicación]

## Beneficios educativos
Esta aplicación demuestra:
- Cómo enviar datos entre actividades usando Intent.putExtra()
- Cómo recibir datos de retorno utilizando el patrón ActivityResult
- Técnicas para preservar el estado de la aplicación durante cambios de configuración
- Uso de Toast para notificaciones simples al usuario

## Pruebas realizadas
- Escritura y visualización de notas de diferentes longitudes
- Rotación del dispositivo para verificar la preservación del estado
- Pruebas de navegación entre actividades
- Verificación de mensajes Toast

## Autor
Jerson
Fecha: Abril 2025

## Curso
Programación para Dispositivos Móviles
