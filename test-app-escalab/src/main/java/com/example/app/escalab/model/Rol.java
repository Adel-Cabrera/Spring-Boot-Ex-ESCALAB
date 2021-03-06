package com.example.app.escalab.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="rol")
public class Rol {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idRol;
	
	@Column(name="name", nullable=false, length = 70)
	private String name;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="usuarios_roles", joinColumns = @JoinColumn(name="id_rol", referencedColumnName = "idRol"), inverseJoinColumns = @JoinColumn(name="id_usuario", referencedColumnName = "idUsuario"))
	List<Usuario> usuarios;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="menus_roles", joinColumns = @JoinColumn(name="id_rol", referencedColumnName = "idRol"), inverseJoinColumns = @JoinColumn(name="id_menu", referencedColumnName = "idMenu"))
	List<Menu> menus;

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}


	

}
