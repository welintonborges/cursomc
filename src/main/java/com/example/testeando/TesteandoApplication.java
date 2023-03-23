package com.example.testeando;

import com.example.testeando.domain.*;
import com.example.testeando.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@SpringBootApplication
public class TesteandoApplication implements CommandLineRunner {

	@Autowired
	private final CategoriaRepository categoriaRepository;

	@Autowired
	private final ProdutoRepository produtoRepository;
	@Autowired
	private final PessoaRepository pessoaRepository;
	@Autowired
	private final EstadoRepository estadoRepository;
	@Autowired
	private final CidadeRepository cidadeRepository;

	public TesteandoApplication(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository, PessoaRepository pessoaRepository,
								EstadoRepository estadoRepository, CidadeRepository cidadeRepository) {
		this.categoriaRepository = categoriaRepository;
		this.produtoRepository = produtoRepository;
		this.pessoaRepository = pessoaRepository;
		this.estadoRepository = estadoRepository;
		this.cidadeRepository = cidadeRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TesteandoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informatica1");
		Categoria cat2 = new Categoria(null, "Escritorio1");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		Pessoa pessoa1 = new Pessoa(null, "Welinton", 35);
		Pessoa pessoa2 = new Pessoa(null, "Rayane", 22);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList());



		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		pessoaRepository. saveAll(Arrays.asList(pessoa1, pessoa2));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlãndia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));

		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1));



	}
}
