package com.example.bommodule.bom.dao

import org.apache.ibatis.session.SqlSession
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Repository

@Repository
class Bom01Repository {
    companion object {
        private const val NAMESPACE = "com.example.bommodule.bom.dao.Bom01Repository."
    }

    @Autowired
    @Qualifier(value = "sqlSession1")
    private lateinit var sqlSession: SqlSession

    fun test(): Int {
        return sqlSession.selectOne(NAMESPACE +"test")
    }

}