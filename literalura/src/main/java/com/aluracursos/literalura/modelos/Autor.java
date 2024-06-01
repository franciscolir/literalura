package com.aluracursos.literalura.modelos;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;

    private String fechaNacimiento;
    private String fechaDefuncion;

    @OneToMany(mappedBy = "autor", fetch = FetchType.EAGER)
    private Set<Libros> libros;

    public Autor() {
    }

    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.fechaNacimiento = datosAutor.fechaNacimiento();
        this.fechaDefuncion = datosAutor.fechaDefuncion();
    }

    @Override
    public String toString() {
        return
                "~~~~~~~~~~AUTOR~~~~~~~~~~\n"+
                "Nombre: " + nombre + '\n' +
                "Fecha de Nacimiento: " + fechaNacimiento + '\n' +
                "Fecha de Defuncion: " + fechaDefuncion+ '\n' +
                "~~~~~~~~~~~~~~~~~~~~~~~~~";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimineto() {
        return fechaNacimiento;
    }

    public void setFechaNacimineto(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(String fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public Set<Libros> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libros> libros) {
        this.libros = libros;
    }
}
