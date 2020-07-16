package co.com.udem.inmobiliaria.util;

import java.text.ParseException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.udem.inmobiliaria.dto.UsuarioDTO;
import co.com.udem.inmobiliaria.entities.UsuarioEntity;


public class ConvertUsuario {
	
	@Autowired
	private ModelMapper modelMapper;
	   
    public UsuarioEntity convertToEntity(UsuarioDTO usuarioDTO) throws ParseException {
        return modelMapper.map(usuarioDTO, UsuarioEntity.class);
    }
    
    public UsuarioDTO convertToDTO(UsuarioEntity usuarioEntity) throws ParseException {
        return modelMapper.map(usuarioEntity, UsuarioDTO.class);
    }
    

}
