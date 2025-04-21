# Configurador de Pedidos de Comida - Aplicación Android

## Descripción
Aplicación Android que permite al usuario configurar un pedido de comida paso a paso, desde seleccionar el tipo de comida hasta añadir extras y ver un resumen final. Implementada utilizando el patrón de navegación con Fragments.

## Autor
Jerson Ernesto Chura Pacci

## Fecha
- Creación: 21/04/2025
- Última modificación: 21/04/2025

## Objetivo
Desarrollar una aplicación que permita al usuario armar un pedido de comida de manera interactiva, navegando entre diferentes pantallas y manteniendo el estado de la selección.

## Funcionalidades
- **Pantalla de inicio**: Con botón para iniciar un nuevo pedido
- **Selección de comida**: Permite elegir entre pizza, hamburguesa o ensalada
- **Selección de extras**: Ofrece opciones como bebida, papas fritas y postre
- **Resumen del pedido**: Muestra el detalle completo de la selección y permite confirmar o editar

## Componentes implementados
- 4 Fragments para cada paso del proceso
- Navigation Component para la navegación entre fragments
- Paso de datos entre fragments usando Bundle
- Comunicación bidireccional con Fragment Result API
- Uso de popBackStack para navegación hacia atrás
- Toast para notificaciones al usuario

## Estructura de archivos

app/
├── src/main/
│   ├── java/com/example/configuradorcomida/
│   │   ├── MainActivity.kt
│   │   ├── InicioFragment.kt
│   │   ├── SeleccionComidaFragment.kt
│   │   ├── SeleccionExtrasFragment.kt
│   │   └── ResumenPedidoFragment.kt
│   └── res/
│       ├── layout/
│       │   ├── activity_main.xml
│       │   ├── fragment_inicio.xml
│       │   ├── fragment_seleccion_comida.xml
│       │   ├── fragment_seleccion_extras.xml
│       │   └── fragment_resumen_pedido.xml
│       └── navigation/
│           └── nav_graph.xml

## Tecnologías utilizadas
- Kotlin
- Android Navigation Component
- Fragment API
- ConstraintLayout y LinearLayout para UI
- Bundle para paso de datos
- Fragment Result API para comunicación bidireccional

## Conceptos practicados
- Uso de fragments para dividir la UI en componentes reutilizables
- Navegación entre fragments usando Navigation Component
- Paso de datos hacia adelante con navigate() y Bundle
- Comunicación hacia atrás con setFragmentResult() y setFragmentResultListener()
- Uso de popBackStack() para regresar a fragments anteriores en la pila

## Instrucciones para ejecutar
1. Abrir el proyecto en Android Studio
2. Sincronizar el proyecto con archivos Gradle
3. Ejecutar la aplicación en un emulador o dispositivo físico con API 21 o superior
