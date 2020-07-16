package co.com.udem.inmobiliaria.rest.controller;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.annotations.UpdateTimestamp;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import co.com.udem.inmobiliaria.dto.UsuarioDTO;
import co.com.udem.inmobiliaria.entities.UsuarioEntity;
import co.com.udem.inmobiliaria.repositories.UsuarioRepository;
import co.com.udem.inmobiliaria.util.Constantes;
import co.com.udem.inmobiliaria.util.ConvertUsuario;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
	

	@Autowired
	ConvertUsuario convertUsuario;
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	/**
	 * Permite crear un usuario
	 * @param usuarioDTO
	 * @return
	 */
	@PostMapping("/crearUsuario")
	Map<String, String> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		if (usuarioDTO != null) {
			Map<String, String> response = new HashMap<>();
			try {
				UsuarioEntity usuarioEntity = convertUsuario.convertToEntity(usuarioDTO);
				usuarioRepository.save(usuarioEntity);
				response.put(Constantes.CODIGO_HTTP, "200");
				response.put(Constantes.MENSAJE_EXITO, "Registrado insertado exitosamente");
			} catch (ParseException e) {
				response.put(Constantes.MENSAJE_ERROR, "Se ha producido un error al intentar crear usuario");
				e.printStackTrace();
			}
			return response;
		}
		return null;
	}
	
	
	/**
	 * Permite consultar un usuario por su nro de identificacion, si no existe retorna el objeto con valores nulos
	 * @param nroIdentificacion
	 * @return
	 */
	@GetMapping("/ObtenerUsuarioIdentificacion")
	UsuarioDTO obtenerUsuarioXidentificacion(Long nroIdentificacion) {
		if (nroIdentificacion != null) {
			UsuarioDTO usuarioDto = new UsuarioDTO();
			try {
				UsuarioEntity usuarioEntity = usuarioRepository.findUserByIdentification(nroIdentificacion);
				if(usuarioEntity!=null) {
				usuarioDto = convertUsuario.convertToDTO(usuarioEntity);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return usuarioDto;
		}
		return null;

	}
	
	
	/**
	 * Permite actualizar el usuario. recibe el usuarioDTO y el idUsuario
	 * @param usuarioDTO
	 * @param idUsuario
	 * @return
	 */
	@PutMapping("/ActualizarUsuario/{idUsuario}")
	Map<String, String> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO, @PathVariable(value = "idUsuario") Long idUsuario) {
		Map<String, String> response = new HashMap<>();
		if (idUsuario != null) {

			Optional<UsuarioEntity> usuarioOptional = usuarioRepository.findById(idUsuario);
			if (!usuarioOptional.isPresent()) {
				response.put(Constantes.CODIGO_HTTP, "204");
				response.put(Constantes.MENSAJE_EXITO, "Usuario no encontrado");
				return response;
			}
			try {

				usuarioDTO.setId(idUsuario);
				UsuarioEntity usuarioEntity = convertUsuario.convertToEntity(usuarioDTO);
				usuarioRepository.save(usuarioEntity);
				response.put(Constantes.CODIGO_HTTP, "200");
				response.put(Constantes.MENSAJE_EXITO, "Registrado actualizado exitosamente");
			} catch (ParseException e) {
				response.put(Constantes.MENSAJE_ERROR, "Se ha producido un error al intentar actualizar usuario");
				e.printStackTrace();
			}
			return response;
		}
		return null;
	}
	
	/**
	 * Permite eliminar un usuario, recibe el idUsuario a eliminar
	 * @param idUsuario
	 * @return
	 */
	@DeleteMapping("EliminarUsuario/{idUsuario}")
	Map<String, String> EliminarUsuario(@PathVariable(value = "idUsuario") Long idUsuario) {
		Map<String, String> response = new HashMap<>();
		if (idUsuario != null) {

			Optional<UsuarioEntity> usuarioOptional = usuarioRepository.findById(idUsuario);
			if (!usuarioOptional.isPresent()) {
				response.put(Constantes.CODIGO_HTTP, "204");
				response.put(Constantes.MENSAJE_EXITO, "Usuario no encontrado");
				return response;
			}
			try {
				usuarioRepository.deleteById(idUsuario);
				response.put(Constantes.CODIGO_HTTP, "200");
				response.put(Constantes.MENSAJE_EXITO, "Usuario eliminado exitosamente");
			} catch (IllegalArgumentException e) {
				response.put(Constantes.MENSAJE_ERROR, "Se ha producido un error al intentar eliminar usuario");
				e.printStackTrace();
			}
			return response;
		}
		return null;
	}
	
	/**
	 * Permite obtener todos los usuarios de la tabla Usuario
	 * @return
	 */
	@GetMapping("ObtenerUsuarios")	
	List<UsuarioDTO> ObtenerUsuarios(){
		Iterable<UsuarioEntity> iUsuarios = usuarioRepository.findAll();
		List<UsuarioEntity> listaUsuarioEntity = new ArrayList<UsuarioEntity>();
		List<UsuarioDTO> listaUsuarioDTO = new ArrayList<UsuarioDTO>();
		iUsuarios.iterator().forEachRemaining(listaUsuarioEntity::add);
		try {
			for (UsuarioEntity usuarioEntity : listaUsuarioEntity) {
				UsuarioDTO usuarioDTO = convertUsuario.convertToDTO(usuarioEntity);
				listaUsuarioDTO.add(usuarioDTO);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return listaUsuarioDTO;
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
