package co.com.udem.inmobiliaria.dto;

public class UsuarioDTO {
	
	private Long id;
	private String nombre;
	private String apellido;
	private String tipoIdentificacion;
	private Long nroIdentificacion;
	private String direccion;
	private Long telefono;
	private String email;
	private String password;	
	
	
	public UsuarioDTO() {
		super();
	}
	
	public UsuarioDTO(String nombre, String apellido, String tipoIdentificacion, Long nroIdentificacion,
			String direccion, Long telefono, String email, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoIdentificacion = tipoIdentificacion;
		this.nroIdentificacion = nroIdentificacion;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	public Long getNroIdentificacion() {
		return nroIdentificacion;
	}
	public void setNroIdentificacion(Long nroIdentificacion) {
		this.nroIdentificacion = nroIdentificacion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.direccion = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
