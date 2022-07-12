package com.residencia.comercio.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.residencia.comercio.dtos.CadastroEmpresaReceitaDTO;
import com.residencia.comercio.dtos.FornecedorDTO;
import com.residencia.comercio.entities.Fornecedor;
import com.residencia.comercio.repositories.FornecedorRepository;

@Service
public class FornecedorService {
	@Autowired
	FornecedorRepository fornecedorRepository;
	
	public List<Fornecedor> findAllFornecedor(){
		return fornecedorRepository.findAll();
	}
	
	public Fornecedor findFornecedorById(Integer id) {
		return fornecedorRepository.findById(id).isPresent() ?
				fornecedorRepository.findById(id).get() : null;
	}

	public FornecedorDTO findFornecedorDTOById(Integer id) {
		Fornecedor fornecedor = fornecedorRepository.findById(id).isPresent() ?
				fornecedorRepository.findById(id).get() : null;
		
		FornecedorDTO fornecedorDTO = new FornecedorDTO();
		if(null != fornecedor) {
			fornecedorDTO = converterEntidadeParaDto(fornecedor);
		}
		return fornecedorDTO;
	}
	
	public Fornecedor saveFornecedor(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}
	
	public FornecedorDTO saveFornecedorDTO(FornecedorDTO fornecedorDTO) {
			
		Fornecedor fornecedor = new Fornecedor();
		
		fornecedor.setIdFornecedor(fornecedorDTO.getIdFornecedor());
		Fornecedor novoFornecedor = fornecedorRepository.save(fornecedor);
		
		return converterEntidadeParaDto(novoFornecedor);
	}
	
	public Fornecedor updateFornecedor(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}
	
	public void deleteFornecedor(Integer id) {
		Fornecedor inst = fornecedorRepository.findById(id).get();
		fornecedorRepository.delete(inst);
	}
	
	public void deleteFornecedor(Fornecedor fornecedor) {
		fornecedorRepository.delete(fornecedor);
	}
	
	private Fornecedor convertDTOToEntidade(FornecedorDTO fornecedorDTO){
		Fornecedor fornecedor = new Fornecedor();
		
		fornecedor.setIdFornecedor(fornecedorDTO.getIdFornecedor());
		return fornecedor;
	}
		
	private FornecedorDTO converterEntidadeParaDto(Fornecedor fornecedor) {
		FornecedorDTO fornecedorDTO = new FornecedorDTO();
		fornecedorDTO.setIdFornecedor(fornecedor.getIdFornecedor());
		return fornecedorDTO;
	}
	
	public CadastroEmpresaReceitaDTO consultarDadosPorCnpj(String cnpj) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://www.receitaws.com.br/v1/cnpj/{cnpj}";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("cnpj", cnpj);

		CadastroEmpresaReceitaDTO cadastroEmpresaReceitaDTO = 
				restTemplate.getForObject(uri, CadastroEmpresaReceitaDTO.class, params);

		return cadastroEmpresaReceitaDTO;
	}
}
