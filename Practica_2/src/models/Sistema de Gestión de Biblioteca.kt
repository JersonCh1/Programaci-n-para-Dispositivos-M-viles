// Descripción: Sistema de gestión de biblioteca con préstamo y devolución de materiales
// Autor: Jerson Ernesto Chura Pacci
// Fecha creación: 24/03/2025
// Fecha última modificación: 24/03/2025

abstract class Material(val titulo: String, val autor: String, val anioPublicacion: Int) {
    abstract fun mostrarDetalles()
}

class Libro(titulo: String, autor: String, anioPublicacion: Int, val genero: String, val numPaginas: Int) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Libro: $titulo, Autor: $autor, Año: $anioPublicacion, Género: $genero, Páginas: $numPaginas")
    }
}

class Revista(titulo: String, autor: String, anioPublicacion: Int, val issn: String, val volumen: Int, val numero: Int, val editorial: String) :
    Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Revista: $titulo, Autor: $autor, Año: $anioPublicacion, ISSN: $issn, Volumen: $volumen, Número: $numero, Editorial: $editorial")
    }
}

data class Usuario(val nombre: String, val apellido: String, val edad: Int)

interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestarMaterial(usuario: Usuario, material: Material)
    fun devolverMaterial(usuario: Usuario, material: Material)
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservados(usuario: Usuario)
}

class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuarios = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
        println("Material registrado: ${material.titulo}")
    }

    override fun registrarUsuario(usuario: Usuario) {
        usuarios[usuario] = mutableListOf()
        println("Usuario registrado: ${usuario.nombre} ${usuario.apellido}")
    }

    override fun prestarMaterial(usuario: Usuario, material: Material) {
        if (material in materialesDisponibles) {
            usuarios[usuario]?.add(material)
            materialesDisponibles.remove(material)
            println("${usuario.nombre} ha prestado '${material.titulo}'")
        } else {
            println("Material no disponible.")
        }
    }

    override fun devolverMaterial(usuario: Usuario, material: Material) {
        if (usuarios[usuario]?.contains(material) == true) {
            usuarios[usuario]?.remove(material)
            materialesDisponibles.add(material)
            println("${usuario.nombre} ha devuelto '${material.titulo}'")
        } else {
            println("Este material no pertenece a la cuenta de este usuario.")
        }
    }

    override fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles:")
        materialesDisponibles.forEach { it.mostrarDetalles() }
    }

    override fun mostrarMaterialesReservados(usuario: Usuario) {
        println("Materiales prestados a ${usuario.nombre}:")
        usuarios[usuario]?.forEach { it.mostrarDetalles() }
    }
}

fun main() {
    val biblioteca = Biblioteca()

    val libro1 = Libro("El Principito", "Antoine de Saint-Exupéry", 1943, "Ficción", 96)
    val revista1 = Revista("National Geographic", "Varios", 2023, "1234-5678", 5, 10, "NatGeo")

    val usuario1 = Usuario("Jerson", "Chura", 21)

    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(revista1)
    biblioteca.registrarUsuario(usuario1)

    biblioteca.prestarMaterial(usuario1, libro1)
    biblioteca.mostrarMaterialesReservados(usuario1)

    biblioteca.devolverMaterial(usuario1, libro1)
    biblioteca.mostrarMaterialesDisponibles()
}
