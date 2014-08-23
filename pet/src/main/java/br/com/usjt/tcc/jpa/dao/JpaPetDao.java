package br.com.usjt.tcc.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.usjt.tcc.interfaces.dao.PetDao;
import br.com.usjt.tcc.model.Pet;

@Repository
@Transactional
public class JpaPetDao implements PetDao{

	@PersistenceContext
	private EntityManager entityManager;

	public void adiciona(Pet pet) {
		entityManager.persist(pet);
	}

	public void atualiza(Pet pet) {
		entityManager.merge(pet);
	}

	@SuppressWarnings("unchecked")
	public List<Pet> lista() {
		Query query = entityManager.createQuery("select p from Pet p");
		return query.getResultList();
	}

	public Pet busca(Long id) {
		return entityManager.find(Pet.class, id);
	}

	@Override
	public Pet busca(Pet pet) {
		
			StringBuffer conteudo = new StringBuffer();
			conteudo.append("SELECT p FROM Pet p WHERE ");
	
			if(pet.getName()!=null)
				conteudo.append("p.name=:pName");
			if(pet.getSize()!=null)
				conteudo.append(" and p.size=:pSize");
			if(pet.getDeficiency()!=null)		
				conteudo.append(" and p.deficiency=:pDeficiency");
			if(pet.getType()!=null)
				conteudo.append(" and p.type.id=:pType");
			if(pet.getRace()!=null)
				conteudo.append(" and p.race.id=:pRace");
			if(pet.getColor()!=null)
				conteudo.append(" and p.color.id=:pColor");
			if(pet.getGender()!=null)
				conteudo.append(" and p.gender=:pGender");
		
			String conteudoS = conteudo.toString();
			
			TypedQuery<Pet> query = entityManager
					.createQuery(conteudoS,	Pet.class);
					

//			query.setParameter("pName", ((pet.getName()==null) ? "*" : pet.getName()));
//			query.setParameter("pSize", ((pet.getSize()==null) ? "*" : pet.getSize()));
//			query.setParameter("pDeficiency", ((pet.getDeficiency()==null) ? "*" : pet.getDeficiency()));
//			query.setParameter("pType", ((pet.getType()==null) ? "*" : pet.getType()));
//			query.setParameter("pRace", ((pet.getRace()==null) ? "*" : pet.getRace()));
//			query.setParameter("pColor", ((pet.getColor()==null) ? "*" : pet.getColor()));
//			query.setParameter("pGender", ((pet.getGender()==null) ? "*" : pet.getGender()));
//			query.setParameter("pIsNeutered", ((pet.getIsNeutered()==null) ? "*" : pet.getIsNeutered()));
//			query.setParameter("pIsDeficient", ((pet.getIsDeficient()==null) ? "*" : pet.getIsDeficient()));
			
			
			if(pet.getName()!=null)
				query.setParameter("pName", pet.getName());
			if(pet.getSize()!=null)
				query.setParameter("pSize", pet.getSize());
			if(pet.getDeficiency()!=null)
				query.setParameter("pDeficiency", pet.getDeficiency());
			if(pet.getType()!=null)
				query.setParameter("pType", pet.getType().getId());
			if(pet.getRace()!=null)
				query.setParameter("pRace", pet.getRace().getId());
			if(pet.getColor()!=null)
				query.setParameter("pColor", pet.getColor().getId());
			if(pet.getGender()!=null)
				query.setParameter("pGender", pet.getGender());
//			query.setParameter("pIsNeutered", pet.getIsNeutered());
//			query.setParameter("pIsDeficient", pet.getIsDeficient());

			return query.getSingleResult();
	}

}
