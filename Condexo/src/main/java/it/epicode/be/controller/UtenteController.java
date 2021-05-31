package it.epicode.be.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.model.Utente;
import it.epicode.be.service.UtenteService;

@RestController
@RequestMapping("/api")
public class UtenteController {

	@Autowired
	private UtenteService utenteService;

	@PostMapping("/creautente")
	public ResponseEntity<Utente> creaUtente(@RequestBody Utente utente) {
		try {
			Utente nuovoUtente = utenteService.creaUtente(utente);
			return new ResponseEntity<Utente>(nuovoUtente, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new WebServerException("Utente non salvato", e);
		}
	}

	@GetMapping("/allutenti")
	public ResponseEntity<List<Utente>> getAllUtenti() {
		List<Utente> listaUtenti = utenteService.getAllUtenti();
		ResponseEntity<List<Utente>> risultato = new ResponseEntity<>(listaUtenti, HttpStatus.OK);
		return risultato;
	}

	@GetMapping("/utente/{idUtente}")
	public ResponseEntity<Utente> getUtenteByID(@PathVariable(required = true) Long idUtente) {
		Optional<Utente> utenteByID = utenteService.getUtenteByID(idUtente);
		if (utenteByID.isPresent()) {
			return new ResponseEntity<>(utenteByID.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(utenteByID.get(), HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Utente> updateUtente(@PathVariable long id, @RequestBody Utente utente) {
		utenteService.updateUtente(id, utente);
		return new ResponseEntity<Utente>(utente, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Utente> deleteUtente(@PathVariable(required = true) long id) {
		utenteService.deleteUtente(id);
		return new ResponseEntity<Utente>(HttpStatus.OK);
	}
}
