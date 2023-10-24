package com.example.bommodule.bom.contoller

import com.example.bommodule.bom.service.Bom01Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class Bom01Controller {

    @Autowired lateinit var bom01Service: Bom01Service

    @GetMapping("/bom/test")
    @ResponseBody
    private fun test(): Int {
        return bom01Service.test()
    }

}