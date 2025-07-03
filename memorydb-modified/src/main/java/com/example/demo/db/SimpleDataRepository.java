package com.example.demo.db;

import com.example.demo.entity.Entity;

import java.util.*;
import java.util.stream.Collectors;

// wildcard를 통해 T, ID 타입 제한 - ID 설정을 위해서
abstract public class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T, ID> {

    private List<T> dataList = new ArrayList<T>();

    private static long index = 0;

    private Comparator<T> sort =  new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    };

    // create

    @Override
    public T save(T data) {
        // data == null
        if(Objects.isNull(data)){
            throw new RuntimeException("Data is null");
        }

        // db에 이미 데이터가 있는가? - create와 update 동시 수행을 위해
        var prevData = dataList.stream()
                .filter(it -> {
                    return it.getId().equals(data.getId());
                })
                        .findFirst();

        if(prevData.isPresent()){
            // data 있는 경우 - update
            // id는 동일
            dataList.remove(prevData.get());
            dataList.add(data);

        }else{
            // data 없는 경우 - create
            index++;
            data.setId(index++);
            dataList.add(data);
        }

        // unique id 지정 필요
        data.setId(index);
        dataList.add(data);

        index++;
        return null;
    }

    // read
    @Override
    public Optional<T> findById(ID id) {
        return dataList.stream()
                .filter(it -> {
                    return it.getId().equals(id);
                })
                .findFirst();
    }

    @Override
    public List<T> findAll() {
        return dataList
                .stream()
                .sorted(sort)
                .collect(Collectors.toList());
    }

    // delete
    @Override
    public void delete(ID id) {
        var deleteEntity = dataList.stream()
                .filter(it -> {
                    return it.getId().equals(id);
                })
                .findFirst();

        if(deleteEntity.isPresent()){
            dataList.remove(deleteEntity.get());
        }
    }
}
