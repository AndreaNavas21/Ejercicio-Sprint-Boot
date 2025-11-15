package com.ejerciciospring.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clubes")

public class Club {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;     // Atlético Bucaramanga
    private String ciudad;     // Bucaramanga
    private int fundacion;     // 1949, etc.
    private String estadio;    // Alfonso López

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entrenador_id", unique = true)
    private Entrenador entrenador;

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public int getFundacion() { return fundacion; }
    public void setFundacion(int fundacion) { this.fundacion = fundacion; }
    public String getEstadio() { return estadio; }
    public void setEstadio(String estadio) { this.estadio = estadio; }
    public Entrenador getEntrenador() { return entrenador; }
    public void setEntrenador(Entrenador entrenador) { this.entrenador = entrenador; }
	

}
