package edu.monash.merc.service;

import edu.monash.merc.domain.User;

public interface UserService {

	User getUserByUnigueId(String uniqueId);

	boolean checkUserUniqueIdExisted(String uniqueId);

	boolean checkEmailExisted(String email);

	void saveUser(User user);

}
