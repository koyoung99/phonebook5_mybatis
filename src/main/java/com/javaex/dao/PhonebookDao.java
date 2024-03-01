package com.javaex.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private SqlSession sqlSession;

	// 전체가져오기
	public List<PersonVo> personSelect() {

		List<PersonVo> personList = sqlSession.selectList("phonebook.select");

		System.out.println(personList);

		return personList;

	}

	// 등록
	public int personInsert(PersonVo personVo) {

		int count = sqlSession.insert("phonebook.insert", personVo);

		System.out.println(count);

		return count;
	}

	// 등록 Map이용
	public int personInsert2(Map<String, String> pMap) {

		System.out.println("PhonebookDao.personInsert2()");
		System.out.println(pMap);

		sqlSession.insert("phonebook.insert2", pMap);

		return 0;
	}

	// 수정폼 -1개 가져오기
	public PersonVo personSelectOne(int no) {

		System.out.println("PhonebookDao.personSelectOne()");

		PersonVo personVo = sqlSession.selectOne("phonebook.selectOne", no);
		System.out.println(personVo);

		return personVo;
	}

	// 수정폼2-Map이용
	public Map<String, Object> personSelectOne2(int no) {

		System.out.println("PhonebookDao.personSelectOne2()");

		Map<String, Object> pMap = sqlSession.selectOne("phonebook.selectOne2", no);

		// System.out.println(pMapp.getName()); 이름만출력

		return pMap;
	}

	// 수정
	public int personUpdate(PersonVo personVo) {

		System.out.println("PhonebookDao.personUpdate()");

		int count = sqlSession.update("phonebook.update", personVo);
		System.out.println(count);

		return count;
	}

	// 삭제
	public int personDelete(int no) {
		System.out.println("PhonebookDao.personDelete()");

		int count = sqlSession.delete("phonebook.delete", no);
		System.out.println(no);

		return count;
	}

}
