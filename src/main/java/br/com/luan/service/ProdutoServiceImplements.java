package br.com.luan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luan.Repository.ProdutoRepository;
import br.com.luan.entity.Produto;

@Service
public class ProdutoServiceImplements implements ProdutoService {

	@Autowired
	private ProdutoRepository empRepo;

	@Override
	public List<Produto> getAllProduto() {
		return empRepo.findAll();
	}

	@Override
	public void save(Produto produto) {
		empRepo.save(produto);
	}

	@Override
	public Produto getById(Long id) {
		Optional<Produto> optional = empRepo.findById(id);
		Produto produto = null;
		if (optional.isPresent())
			produto = optional.get();
		else
			throw new RuntimeException("Produto not found for id : " + id);
		return produto;
	}

	@Override
	public void deleteViaId(long id) {
		empRepo.deleteById(id);
	}

}
