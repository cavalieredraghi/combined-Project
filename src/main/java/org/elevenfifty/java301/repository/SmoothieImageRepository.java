package org.elevenfifty.java301.repository;

import org.elevenfifty.java301.beans.SmoothieImage;
import org.springframework.data.repository.CrudRepository;

public interface SmoothieImageRepository extends CrudRepository<SmoothieImage, Integer>{
	SmoothieImage findBySmoothieId(int id);
}
