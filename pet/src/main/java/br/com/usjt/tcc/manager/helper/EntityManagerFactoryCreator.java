package br.com.usjt.tcc.manager.helper;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//@Component
//@ApplicationScoped
public class EntityManagerFactoryCreator{ //implements ComponentFactory<EntityManagerFactory> {

	private EntityManagerFactory entityManagerFactory;

	@PostConstruct
	public void abre() {
		this.entityManagerFactory = Persistence
				.createEntityManagerFactory("tcc-mysql");
	}

	//@Override
	public EntityManagerFactory getInstance() {
		return this.entityManagerFactory;
	}

	@PreDestroy
	public void fecha() {
		this.entityManagerFactory.close();
	}
}