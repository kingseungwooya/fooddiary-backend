package com.webproject.fooddiary.repository;



import com.webproject.fooddiary.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,String> {
    boolean existsById(String id);
}
