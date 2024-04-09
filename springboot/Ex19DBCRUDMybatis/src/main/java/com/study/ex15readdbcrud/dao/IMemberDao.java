package com.study.ex15readdbcrud.dao;

import com.study.ex15readdbcrud.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @Mapper: 인터페이스 DAO와 MyBatis XML과 연결하는 용도
@Mapper
public interface IMemberDao {
    // list (SELECT *)
    public List<MemberDTO> list();

    // SELECT COUNT(*)
    public int count();

    // INSERT
    public int insert(MemberDTO dto);
//    public int insertMap(HashMap map);

    // SELECT WHERE id=
    public List<MemberDTO> findById(int id);

    // UPDATE
    public int update(MemberDTO dto);

    // DELETE
    public int delete(int id);

    // map.put("id", id)
    // map.put("userId", userId);
//    public int deleteMap(int id, String userId);

}
