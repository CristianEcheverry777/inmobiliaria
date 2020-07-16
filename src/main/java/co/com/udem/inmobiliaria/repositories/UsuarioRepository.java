package co.com.udem.inmobiliaria.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.udem.inmobiliaria.entities.UsuarioEntity;



public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {
	
	
	/**
	 * Permite consultar un usuario por su nroIdentificacion
	 * @param nroIdentifiacion
	 * @return
	 */
	@Query(value = "SELECT * FROM USUARIO WHERE NRO_IDENTIFICACION=?1", nativeQuery = true)
	UsuarioEntity findUserByIdentification(Long nroIdentificacion);

}
