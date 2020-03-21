package edu.mum.cs.cs425.onetomany.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.onetomany.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
