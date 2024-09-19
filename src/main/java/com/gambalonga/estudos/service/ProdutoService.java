package com.gambalonga.estudos.service;

import com.gambalonga.estudos.Dto.ProdutoDTO;
import com.gambalonga.estudos.model.Produto;
import com.gambalonga.estudos.repository.ProdutoRepository;
import com.gambalonga.estudos.utils.ConversionUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ConversionUtil conversionUtil;

    public ProdutoService(ProdutoRepository produtoRepository, ConversionUtil conversionUtil) {
        this.produtoRepository = produtoRepository;
        this.conversionUtil = conversionUtil;
    }

    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        final Produto produto = conversionUtil.convertToEntity(produtoDTO, Produto.class);
        final Produto savedProduto = produtoRepository.save(produto);
        return conversionUtil.convertToDto(savedProduto, ProdutoDTO.class);
    }

    public List<ProdutoDTO> findAll() {
        return produtoRepository.findAll().stream()
                .map(produto -> conversionUtil.convertToDto(produto, ProdutoDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<ProdutoDTO> findById(Long id) {
        return produtoRepository.findById(id)
                .map(produto -> conversionUtil.convertToDto(produto, ProdutoDTO.class));
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
