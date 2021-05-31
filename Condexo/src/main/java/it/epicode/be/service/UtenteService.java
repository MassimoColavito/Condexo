package it.epicode.be.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.be.model.Utente;
import it.epicode.be.repository.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepository;

	public Utente creaUtente(Utente utente) {
		return utenteRepository.save(utente);
	}

	public List<Utente> getAllUtenti() {
		List<Utente> listaUtenti = utenteRepository.findAll();
		return listaUtenti;
	}

	public Optional<Utente> getUtenteByID(Long id) {
		return utenteRepository.findById(id);
	}

	public void deleteUtente(long id) {
		utenteRepository.deleteById(id);
	}

	public Utente updateUtente(long id, Utente u) {
		Utente update = utenteRepository.findById(id).get();
		update.getId();
		update.setNome(u.getNome());
		update.setCognome(u.getCognome());
		update.setUsername(u.getUsername());
		update.setCodicefiscale(u.getCodicefiscale());
		update.setDataDiNascita(u.getDataDiNascita());
		utenteRepository.save(update);
		return update;
	}
}
