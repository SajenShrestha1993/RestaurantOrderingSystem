package com.ibm.newhire.menums.repo;




import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.ibm.newhire.menums.model.Item;

@Repository
public interface MenuRepository extends MongoRepository<Item, Long> 
{
	public Item findByName(String name);
	public Item findById(BigInteger id);
}