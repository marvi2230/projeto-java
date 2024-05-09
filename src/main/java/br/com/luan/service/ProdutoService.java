package br.com.luan.service;

import java.util.List;

import br.com.luan.entity.Produto;

public interface ProdutoService {
	
	    List<Produto> getAllProduto();
	    void save(Produto produto);
	    Produto getById(Long id);
	    void deleteViaId(long id);
}
