package br.com.usjt.tcc.teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.usjt.tcc.interfaces.dao.AnnouncementDao;
import br.com.usjt.tcc.interfaces.dao.ProductDao;
import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.model.Announcement;

@Component
public class AnnouncementDaoTeste {

	@Autowired
	private AnnouncementDao announcementDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private UserDao userDao;
	
	
	public void test() {

		Announcement announcement =  new Announcement();
		announcement.setProduct(productDao.busca(new Long(9)));
		announcement.setUser(userDao.busca(new Long(4)));
	
		announcementDao.adiciona(announcement);
		
	}
}
