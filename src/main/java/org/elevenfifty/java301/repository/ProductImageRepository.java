package org.elevenfifty.java301.repository;

import org.elevenfifty.java301.beans.ProductImage;
import org.springframework.data.repository.CrudRepository;

public interface ProductImageRepository extends CrudRepository<ProductImage, Integer>{

	ProductImage findByProductId(int id);
}
