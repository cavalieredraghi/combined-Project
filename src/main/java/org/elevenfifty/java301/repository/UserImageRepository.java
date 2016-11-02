package org.elevenfifty.java301.repository;

import org.elevenfifty.java301.beans.UserImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserImageRepository extends CrudRepository<UserImage, Integer> {

	  UserImage findByUserId(int id);
}

