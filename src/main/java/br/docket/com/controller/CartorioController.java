package br.docket.com.controller;


import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.docket.com.exception.InternalException;
import br.docket.com.exception.ObjetoInexistenteException;
import br.docket.com.exception.Resposta;
import br.docket.com.model.Cartorio;
import br.docket.com.service.CartorioService;


@RestController
@RequestMapping(path = "cartorio/")
public class CartorioController {
	CartorioService cartorioService;

	@Autowired
	public CartorioController(CartorioService cartorioService) {
		this.cartorioService = cartorioService;
	}
	
	@PostMapping("new")
	public ResponseEntity<?> novoCartorio(@RequestBody Cartorio cartorio){
		try {
		return new ResponseEntity<>(cartorioService.novoCartorio(cartorio), HttpStatus.CREATED);
		}catch(InternalException ie) {
			return ResponseEntity.badRequest().body(new Resposta(ie.getCode(), ie.getMessage(), null));
		}
	}
	
	@GetMapping("list")
    public ResponseEntity<?> listaCartorio() {
        List<Cartorio> cartorio = cartorioService.listaCartorio();
        if (cartorio.size()>0){
            return ResponseEntity.ok(cartorio);
        } else {
            return ResponseEntity.badRequest().body(new ObjetoInexistenteException("nenhum cartorio cadastrado"));
        }
    }
	
	@GetMapping("search/{id}")
    public ResponseEntity<?> buscaCartorioById(@PathVariable(value = "id") Long id) {
        Optional<Cartorio> cartorio  = cartorioService.pesquisaCartorioByID(id);
        if (cartorio.isPresent()){
            return ResponseEntity.ok(cartorio);
        } else {
            return ResponseEntity.badRequest().body(new ObjetoInexistenteException("nenhum cartorio com id "+id));
        }
    }
	
	@PutMapping("update/{id}")
    public ResponseEntity<Cartorio> atualizaCartorio(@RequestBody @Valid Cartorio cartorio,
                                                 @PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(cartorioService.atualizaCartorio(cartorio, id), HttpStatus.OK);
    }
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> DeletaProdutoVenda(@PathVariable(value = "id") Long id) {		
		try {
			Cartorio cartorioDeletado = cartorioService.deletaCartorio(id);
			return ResponseEntity.ok("Cartorio de ID " + cartorioDeletado.getId() + " deletado com sucesso!");
		}catch(ObjetoInexistenteException e){
			return ResponseEntity.badRequest().body(new  ObjetoInexistenteException("nenhum cartorio com id "+ id));
			
		}
	}
}
