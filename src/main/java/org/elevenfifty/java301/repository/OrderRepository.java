package org.elevenfifty.java301.repository;

import org.elevenfifty.java301.beans.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>{

}
