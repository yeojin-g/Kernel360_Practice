package com.example.memorydb.db;

import java.util.List;
import java.util.Optional;

public interface DataRepository<T, ID> extends Repository<T, ID>{




    // create, update
    T save(T data);


    // read
    Optional<T> findById(ID id);

    // update
    void delete(ID id);

    List<T> findAll();


}
