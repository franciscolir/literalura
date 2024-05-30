package com.aluracursos.literalura;

import com.aluracursos.literalura.principal.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.opcionesMenu();
}}
