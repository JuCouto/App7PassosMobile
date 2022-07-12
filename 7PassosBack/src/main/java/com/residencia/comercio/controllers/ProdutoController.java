package com.residencia.comercio.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.residencia.comercio.dtos.ProdutoDTO;
import com.residencia.comercio.dtos.ProdutoInterfaceDTO;
import com.residencia.comercio.entities.Produto;
import com.residencia.comercio.exceptions.NoSuchElementFoundException;
import com.residencia.comercio.services.ArquivoService;
import com.residencia.comercio.services.EmailService;
import com.residencia.comercio.services.ProdutoService;

@RestController
@RequestMapping("/produto")
@Validated 
public class ProdutoController {
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
    ArquivoService arquivoService;

	@Autowired
	EmailService emailService;
	
	@PostMapping(value = "/produto-com-foto", consumes = { MediaType.APPLICATION_JSON_VALUE,
			 MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Produto> saveProdutoComFoto(@RequestPart("produto") String produto, @RequestPart("file") MultipartFile file) {
    	Produto novoProduto = produtoService.saveProdutoComFoto(produto, file);
    	if(null == novoProduto)
    		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    	else
    		return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }
	
	@GetMapping("/entidade")
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> produtoList = produtoService.findAll();
		if(produtoList.isEmpty())
			throw new NoSuchElementFoundException("Não foram encontrados Produtos");
		else
			return new ResponseEntity<>(produtoService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAllDTO(@RequestParam(required = false) Integer pagina, @RequestParam(required = false) Integer qtdRegistros){
		List<ProdutoDTO> produtoDTOList = produtoService.findAllDTO(pagina, qtdRegistros);
		if(produtoDTOList.isEmpty())
			throw new NoSuchElementFoundException("Não foram encontrados Produtos");
		else
			return new ResponseEntity<>(produtoDTOList, HttpStatus.OK);
	}
	
	@GetMapping("/categoria")
	public ResponseEntity<List<ProdutoDTO>> findAllDTOByCategoria(@RequestParam(required = false) Integer pagina,
			@RequestParam(required = false) Integer qtdRegistros,
			@RequestParam(required = false) Integer idCategoria
			){
		List<ProdutoDTO> produtoDTOList = produtoService.findAllDTOByCategoria(pagina, qtdRegistros, idCategoria);
		if(produtoDTOList.isEmpty())
			throw new NoSuchElementFoundException("Não foram encontrados Produtos");
		else
			return new ResponseEntity<>(produtoDTOList, HttpStatus.OK);
	}
	
	@GetMapping("/busca")
	public ResponseEntity<List<ProdutoInterfaceDTO>> buscaDTO(@RequestParam(required = true) String keyword){
		List<ProdutoInterfaceDTO> produtoDTOList = produtoService.buscaDTO(keyword);
		if(produtoDTOList.isEmpty())
			throw new NoSuchElementFoundException("Não foram encontrados Produtos");
		else
			return new ResponseEntity<>(produtoDTOList, HttpStatus.OK);
	}	
	
	@GetMapping("/query")
	public ResponseEntity<Produto> findByIdQuery(
			@RequestParam
			@NotBlank(message = "O sku deve ser preenchido.")
			String sku){
		return new ResponseEntity<>(null, HttpStatus.CONTINUE);
	}
	
	@GetMapping("/request")
	public ResponseEntity<Produto> findByIdRequest(
			@RequestParam
			@NotBlank(message = "O id deve ser preenchido.")
			Integer id){
		return new ResponseEntity<>(null, HttpStatus.CONTINUE);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Integer id){
		
		emailService.sendTextMail("to@example.com", "Assunto do e-mail", "Corpo do E-mail");
		try {
			emailService.sendHtmlMail("to@example.com", "Assunto do e-mail", "Corpo do E-mail");
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		Produto produto = produtoService.findById(id);
		if(null == produto)
			throw new NoSuchElementFoundException("Não foi encontrado Produto com o id: " + id);
		else
			return new ResponseEntity<>(produto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Produto> save(@Valid @RequestBody Produto produto){
		return new ResponseEntity<>(produtoService.save(produto), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Produto> update(@RequestBody Produto produto){
		Produto produtoAtualizado = produtoService.update(produto);
		return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> update(@PathVariable Integer id, @RequestBody Produto produto){
		Produto produtoAtualizado = produtoService.updateComId(produto, id);
		if(null == produtoAtualizado)
			return new ResponseEntity<>(produtoAtualizado, HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
	}
	
	@DeleteMapping 
	public ResponseEntity<String> delete(Produto produto){
		produtoService.delete(produto);
		return new ResponseEntity<>("", HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<String> deletePorId(Integer id){
		produtoService.deletePorId(id);
		return new ResponseEntity<>("", HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public Long count() {
		return produtoService.count();
	}
	
}
