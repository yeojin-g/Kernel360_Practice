package com.example.demo.db;

import java.util.List;
import java.util.Optional;

public interface DataRepository <T, ID> extends Repository<T, ID>{

    // create, update
    // data 있으면 update, 없으면 create로 동작
    T save(T data);

    // read
    // ID받아서 data return
    Optional<T> findById(ID id);

    List<T> findAll();

    // delete
    void delete(ID id);
}
