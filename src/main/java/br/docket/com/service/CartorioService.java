package br.docket.com.service;

import java.util.List;
import java.util.Optional;
import br.docket.com.model.Cartorio;

public interface CartorioService {

	Cartorio novoCartorio(Cartorio cartorio);

	List<Cartorio> listaCartorio();

	Optional<Cartorio> pesquisaCartorioByID(Long id);

	Cartorio atualizaCartorio(Cartorio cartorio, Long id);

	Cartorio deletaCartorio(Long id);



}
