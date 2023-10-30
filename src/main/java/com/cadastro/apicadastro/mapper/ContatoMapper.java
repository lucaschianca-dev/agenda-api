package com.cadastro.apicadastro.mapper;

import com.cadastro.apicadastro.dtos.ContatoDTO;
import com.cadastro.apicadastro.entities.Contato;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContatoMapper {

    ContatoMapper INSTANCE = Mappers.getMapper(ContatoMapper.class);

    ContatoDTO toContatoDTO(Contato contato);
}
