package com.desaextremo.retotres.Repositories;

import com.desaextremo.retotres.Entities.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GadgetRepository extends MongoRepository<Gadget,Integer> {
}
