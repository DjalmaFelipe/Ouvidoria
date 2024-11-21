package com.unifacisa.ouvidoria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.unifacisa.ouvidoria.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;

	/*@GetMapping("/enviar-email")
	public String enviarEmail(@RequestParam String destinatario, @RequestParam String assunto,
			@RequestParam String corpo) {
		emailService.enviarEmail(destinatario, assunto, corpo);
		return "Email enviado com sucesso!";

	} */
	@GetMapping ("/email")
	public String enviaremail () {
		emailService.enviarEmail("djalma.bezerra@maisunifacisa.com.br", "Teste", "Teste");
		return "Email enviado com sucesso!";
				
	}
}
