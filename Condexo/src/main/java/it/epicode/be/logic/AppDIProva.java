package it.epicode.be.logic;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicode.be.model.Utente;
import it.epicode.be.repository.UtenteRepository;

@Component
public class AppDIProva implements CommandLineRunner {

	@Autowired
	private UtenteRepository utenteRepo;

	@SuppressWarnings("unused")
	private void popola() {
		Utente u1 = new Utente();
		u1.setNome("Mario");
		u1.setCognome("Rossi");
		u1.setUsername("mario_rossi");
		u1.setCodicefiscale("RSS");
		u1.setDataDiNascita(LocalDate.of(1990, 5, 12));
		utenteRepo.save(u1);
	}

	@Override
	public void run(String... args) throws Exception {
//		popola();
	}
}
