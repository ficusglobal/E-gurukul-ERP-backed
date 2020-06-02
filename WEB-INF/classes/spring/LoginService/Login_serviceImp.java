package spring.LoginService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.UserloginDao;
import spring.model.User_role;
import spring.model.Userlogin;

@Service
@Transactional(readOnly = true)
public class Login_serviceImp implements Login_service {
	
	@Autowired
	   private UserloginDao userloginDao;
	
	
	@Transactional
	@Override
	public String save(Userlogin userlogin) {
		
		String em="null";
			try {
				em= userloginDao.save(userlogin);
			} catch (Exception e) {
				em=e.getMessage().toString();
			}
			return em;
		
	}

	@Override
	public String role(User_role user_role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Boolean checkuser(String email,String password) {
		Boolean check=false;
		String pass = null;
		try {
			Userlogin em=userloginDao.checkuser(email);
			pass = em.getPassword();
		if(pass.equals(password))
		{
			check=true;
		}
		} catch (Exception e) {
			System.out.print(e.getMessage().toString());
		}
		return check;
	}

	@Transactional
	@Override
	public Userlogin get(long userid) {
		return userloginDao.get(userid);
	}

	@Override
	public List<Userlogin> list() {
		return userloginDao.list();
	}

	@Transactional
	@Override
	public void update(long userid, Userlogin userlogin) {
		userloginDao.update(userid, userlogin);
		
	}

	@Transactional
	@Override
	public void delete(long userid) {
		userloginDao.delete(userid);
		
	}

}
