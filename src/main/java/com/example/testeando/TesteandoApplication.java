package com.example.testeando;

import com.example.testeando.domain.*;
import com.example.testeando.domain.enums.EstadoPagamento;
import com.example.testeando.domain.enums.TipoCliente;
import com.example.testeando.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;


@SpringBootApplication
public class TesteandoApplication implements CommandLineRunner {


	public static void main(String... args) throws Exception {
		SpringApplication.run(TesteandoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
