package com.residencia.comercio.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.residencia.comercio.dtos.CategoriaDTO;
import com.residencia.comercio.entities.Categoria;
import com.residencia.comercio.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	Arquivo2Service arquivoService;
	
	@Autowired
	MailService emailService;
	
	public List<Categoria> findAllCategoria(){
		return categoriaRepository.findAll();
	}
	
	public List<CategoriaDTO> findAllCategoriaDTO(Integer pagina, Integer qtdRegistros){
		List<Categoria> categoriaList = new ArrayList<>();
		
		if(null != pagina && null != qtdRegistros) {
			Pageable page = PageRequest.of(pagina, qtdRegistros);
			Page<Categoria> categoriaPageable = categoriaRepository.findAll(page); 
			categoriaList = categoriaPageable.getContent();
		}else {
			categoriaList = categoriaRepository.findAll();
		}

		return categoriaList.stream()
		        .map(entity -> new CategoriaDTO(entity.getIdCategoria(), entity.getNomeCategoria(), entity.getNomeImagem()))
		        .collect(Collectors.toList());
	}
	
	public Categoria findCategoriaById(Integer id) {
		return categoriaRepository.findById(id).isPresent() ?
				categoriaRepository.findById(id).get() : null;
	}

	public CategoriaDTO findCategoriaDTOById(Integer id) {
		Categoria categoria = categoriaRepository.findById(id).isPresent() ?
				categoriaRepository.findById(id).get() : null;
		
		CategoriaDTO categoriaDTO = new CategoriaDTO();
		if(null != categoria) {
			categoriaDTO = converterEntidadeParaDto(categoria);
		}
		return categoriaDTO;
	}
	
	public Categoria saveCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public CategoriaDTO saveCategoriaDTO(CategoriaDTO categoriaDTO) {
			
		Categoria categoria = new Categoria();
		
		categoria.setIdCategoria(categoriaDTO.getIdCategoria());
		Categoria novoCategoria = categoriaRepository.save(categoria);
		
		return converterEntidadeParaDto(novoCategoria);
	}
	
	public Categoria updateCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public void deleteCategoria(Integer id) {
		Categoria inst = categoriaRepository.findById(id).get();
		categoriaRepository.delete(inst);
	}
	
	public void deleteCategoria(Categoria categoria) {
		categoriaRepository.delete(categoria);
	}
	
	private Categoria convertDTOToEntidade(CategoriaDTO categoriaDTO){
		Categoria categoria = new Categoria();
		
		categoria.setIdCategoria(categoriaDTO.getIdCategoria());
		return categoria;
	}
		
	private CategoriaDTO converterEntidadeParaDto(Categoria categoria) {
		CategoriaDTO categoriaDTO = new CategoriaDTO();
		categoriaDTO.setIdCategoria(categoria.getIdCategoria());
		return categoriaDTO;
	}
	
	public Categoria saveCategoriaComFoto(String categoriaString, MultipartFile file) throws Exception {
		
		Categoria categoriaConvertida = new Categoria();
		try {
			ObjectMapper objMapper = new ObjectMapper();
			categoriaConvertida = objMapper.readValue(categoriaString, Categoria.class);
		}catch(IOException e) {
			System.out.println("Ocorreu um erro na conversão");
		}
		
		/*
		List<Categoria> nomesImagemList = repositoryCategoria.findAllByNomeImagem(file.getOriginalFilename());
		if(nomesImagemList.isEmpty(){
		}else{
			for(String nome : nomesImagemList){
				//...
			}
		}
		
		*/
		
		Categoria categoriaBD = categoriaRepository.save(categoriaConvertida);
		categoriaBD.setNomeImagem(categoriaBD.getIdCategoria()+"_"+file.getOriginalFilename());
		Categoria categoriaAtualizada = categoriaRepository.save(categoriaBD);
		
		//Chamando o metodo que fara a copia do arquivo para a pasta definida
		arquivoService.criarArquivo(categoriaBD.getIdCategoria()+"_"+file.getOriginalFilename(), file);
		
		//Cuidado para definir um endereco de destinatario valido abaixo
		String corpoEmail = "Foi cadastrada uma nova categoria: " + categoriaAtualizada.toString(); 
		emailService.enviarEmailTexto("teste@teste.com", "Cadastro de Categoria", corpoEmail);

		
		return categoriaAtualizada;
	}
	
	public Long count() {
		return categoriaRepository.count();
	}
}
