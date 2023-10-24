package com.example.bommodule.bom.service

import com.example.bommodule.bom.dao.Bom01Repository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class Bom01ServiceImpl: Bom01Service {

    @Autowired lateinit var bom01Repository: Bom01Repository

    override fun test(): Int {
        return bom01Repository.test()
    }
}