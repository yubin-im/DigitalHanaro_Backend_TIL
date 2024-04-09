package com.study.ex15readdbcrud.dao;

import com.study.ex15readdbcrud.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// @Mapper: 인터페이스 DAO와 MyBatis XML과 연결하는 용도
@Mapper
public interface IMemberDao {
    // list (SELECT *)
    public List<MemberDTO> list();

    // SELECT COUNT(*)

    // INSERT

    // SELECT WHERE id=

    // UPDATE

    // DELETE

}
