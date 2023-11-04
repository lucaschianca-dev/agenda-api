package com.cadastro.apicadastro.repositories;

import com.cadastro.apicadastro.dtos.ListarContatoPorPessoaDTO;
import com.cadastro.apicadastro.entities.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
    @Query("select C FROM Contato AS C WHERE C.pessoa.id=:id")
    Optional<List<ListarContatoPorPessoaDTO>> buscarContatosPorId(Long id);

    boolean existsById(Long id);
}
