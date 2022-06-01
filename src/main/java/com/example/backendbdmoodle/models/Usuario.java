package com.example.backendbdmoodle.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario
{
    private String nombre;
    private String apellido;
    private String email;

    public Usuario()
    {

    }

    public Usuario(String nombre, String apellido, String email)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }
}
