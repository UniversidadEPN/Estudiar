package com.example.estudiar

class Usuario {
    var nombre: String? = null
    var apellido: String? = null
    var edad: Int = 0
    var celular: String? = null

    constructor() {}

    constructor(nombre: String, apellido: String, edad: Int, celular: String) {
        this.nombre = nombre
        this.apellido = apellido
        this.edad = edad
        this.celular = celular
    }
}
