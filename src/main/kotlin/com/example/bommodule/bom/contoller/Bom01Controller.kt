package com.example.bommodule.bom.contoller

import com.example.bommodule.bom.service.Bom01Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class Bom01Controller {

    @Autowired lateinit var bom01Service: Bom01Service

    @GetMapping("/bom/test")
    private fun test(): String {
        return "bom/bom01"
    }

}