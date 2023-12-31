package com.xantrix.webapp.repository;

import com.xantrix.webapp.model.Utenti;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UtentiRepository extends MongoRepository<Utenti, String>
{
	public Utenti findByUserId(String UserId);
}
