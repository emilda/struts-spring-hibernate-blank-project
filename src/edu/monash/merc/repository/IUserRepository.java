package edu.monash.merc.repository;

import edu.monash.merc.domain.User;

/**
 * IUserRepository DAO Interface
 *
 * @author  Sindhu Emilda &nbsp;&nbsp;&nbsp;&nbsp;
 * <a href="mailto:sindhu.emilda@monash.edu">sindhu.emilda@monash.edu</a>
 * @version 1.0
 */
public interface IUserRepository 
{
	public User getUserByUnigueId(String uniqueId);
	
	public boolean checkUserUniqueIdExisted(String uniqueId);
	
	public boolean checkEmailExisted(String email);
}
