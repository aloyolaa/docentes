package com.prueba.docente.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "docente")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "dni", length = 8)
    private String dni;

    @Column(name = "fecha_nacimiento")
    @JdbcTypeCode(SqlTypes.DATE)
    private LocalDate fechaNacimiento;

    @Column(name = "sueldo")
    private Double sueldo;

    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "sexo", length = 45)
    private String sexo;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}