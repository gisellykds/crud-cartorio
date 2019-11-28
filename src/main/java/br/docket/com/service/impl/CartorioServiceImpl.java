package br.docket.com.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.docket.com.exception.ObjetoInexistenteException;
import br.docket.com.model.Cartorio;
import br.docket.com.repository.CartorioRepository;
import br.docket.com.service.CartorioService;

@Service
public class CartorioServiceImpl implements CartorioService{

	@Autowired
	private CartorioRepository cartorioRepository;
	
	@Autowired
	public CartorioServiceImpl(CartorioRepository cartorioRepository) {
		this.cartorioRepository = cartorioRepository;
	}

	// metodos crud
	@Override
	public Cartorio novoCartorio(Cartorio cartorio) {
		return cartorioRepository.save(cartorio);
	}

	@Override
	public List<Cartorio> listaCartorio() {
		return cartorioRepository.findAll();
	}

	@Override
	public Optional<Cartorio> pesquisaCartorioByID(Long id) {
		Optional<Cartorio> cartorio = cartorioRepository.findById(id);
		if(!cartorio.isPresent())
			throw new ObjetoInexistenteException("cartorio com o ID " + id + " nao encontrado");
			return cartorio;
	}

	@Override
	public Cartorio atualizaCartorio(Cartorio cartorio, Long id) {
		Optional<Cartorio> cartorio2 = cartorioRepository.findById(id);
		if (cartorio2.isPresent()) {
			Cartorio cartorio3 = cartorio2.get();
			cartorio.setId(cartorio3.getId());
			cartorioRepository.save(cartorio);
			return cartorio;
		}
		return null;
	}

	@Override
	public Cartorio deletaCartorio(Long id) {
		Optional<Cartorio> cartorio = cartorioRepository.findById(id);
		if(!cartorio.isPresent())
			throw new ObjetoInexistenteException("cartorio com o ID " + id + " nao encontrado");
		cartorioRepository.deleteById(id);
		return cartorio.get();
	}

	
}
