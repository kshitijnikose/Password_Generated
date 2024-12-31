package com.assigenment.passwordgen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assigenment.passwordgen.Model.user;

@Repository
public interface userepo extends JpaRepository<user, Long>{
    
}
