package com.cadastro.apicadastro.mapper;

import com.cadastro.apicadastro.dtos.ListarContatoPorPessoaDTO;
import com.cadastro.apicadastro.dtos.PessoaDTO;
import com.cadastro.apicadastro.entities.Contato;
import com.cadastro.apicadastro.entities.Pessoa;
import com.cadastro.apicadastro.requests.PessoaRegistroRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PessoaMapper {

    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);


    Pessoa toPessoa(PessoaRegistroRequest request);

    PessoaDTO toPessoaDTO(Pessoa pessoa);

    Pessoa toPessoa(PessoaDTO pessoaDTO);

    ListarContatoPorPessoaDTO toPessoaDTO(Contato contato);
}
