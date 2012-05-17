package edu.monash.merc.dao.impl;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import edu.monash.merc.dao.HibernateGenericDAO;
import edu.monash.merc.domain.User;
import edu.monash.merc.repository.IUserRepository;
/**
 * UserDAO class which provides data access functionality for User domain object
 *
 * @author  Sindhu Emilda &nbsp;&nbsp;&nbsp;&nbsp;
 * <a href="mailto:sindhu.emilda@monash.edu">sindhu.emilda@monash.edu</a>
 * @version 1.0
 */
@Scope("prototype")
@Repository
public class UserDAO extends HibernateGenericDAO<User> implements IUserRepository {

	public User getUserByUnigueId(String uniqueId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checkUserUniqueIdExisted(String uniqueId) {
		System.out.println("UserDAO checking ....checkUserUniqueIdExisted");
		long num = (Long) this.session().createCriteria(this.persistClass).setProjection(Projections.rowCount())
                .add(Restrictions.eq("uniqueId", uniqueId).ignoreCase()).uniqueResult();
        if (num == 1) {
            return true;
        } else {
            return false;
        }
	}

	public boolean checkEmailExisted(String email) {
		long num = (Long) this.session().createCriteria(this.persistClass).setProjection(Projections.rowCount())
                .add(Restrictions.eq("email", email).ignoreCase()).uniqueResult();
        if (num == 1) {
            return true;
        } else {
            return false;
        }
	}

}
