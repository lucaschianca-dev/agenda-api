package com.cadastro.apicadastro.mapper;

import com.cadastro.apicadastro.dtos.ContatoDTO;
import com.cadastro.apicadastro.entities.Contato;
import com.cadastro.apicadastro.requests.ContatoRegistroRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContatoMapper {

    ContatoMapper INSTANCE = Mappers.getMapper(ContatoMapper.class);

    Contato toContato(ContatoRegistroRequest request);

    ContatoDTO toContatoDTO(Contato contato);
}
