package com.example.demo.user.db;

import com.example.demo.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // select * from user where score > [??]
    // query method - by 이후로는 whrer 절
    public List<UserEntity> findAllByScoreGreaterThan(int score);

    // select * from user where score >= ?? AND score <= ??
    List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max);

    //복잡한 쿼리 사용 시 - native
    /*@Query( // u = user, ?1= 1번째 param(=min), ?2 = max
            "select u from user u where u.score >= ?1 AND score <= ?2"
    )
    List<UserEntity> score(int min, int max);
    */
    //복잡한 쿼리 사용 시 - native
    @Query( // 직접 sql문 작성 : 복잡한 쿼리 작성 시 추천 방법
            value = "select * from user as u where u.score >= :min AND score <= :max",
            nativeQuery = true
    )
    List<UserEntity> score(
            @Param(value = "min") int min,
            @Param(value = "max") int max
    );
}
