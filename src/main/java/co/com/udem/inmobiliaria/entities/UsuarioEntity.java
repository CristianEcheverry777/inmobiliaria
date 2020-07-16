package co.com.udem.inmobiliaria.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor
@Table(name="usuario")
public class UsuarioEntity implements Serializable{
		
    
		@Id
    	@GeneratedValue(strategy = GenerationType.IDENTITY)
    	private Long id; 
		private String nombre;
		private String apellido;
		private String tipoIdentificacion;
		private Long nroIdentificacion;
		private String direccion;
		private Long telefono;
		private String email;
		private String password;	
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
			
		
		
		

	

}
