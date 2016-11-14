package org.elevenfifty.java301.repository;

import org.elevenfifty.java301.beans.Product;
import org.elevenfifty.java301.beans.Smoothie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SmoothieRepository extends CrudRepository<Smoothie, Integer>{

}
