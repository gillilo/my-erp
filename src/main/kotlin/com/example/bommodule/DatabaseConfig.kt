package com.example.bommodule

import com.zaxxer.hikari.HikariDataSource
import org.apache.ibatis.session.SqlSession
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.SqlSessionTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import javax.sql.DataSource

@Configuration
class DatabaseConfig {

    @Bean
    fun servletWebServerFactory(): ServletWebServerFactory? {
        return TomcatServletWebServerFactory()
    }

    @Bean
    @ConfigurationProperties("spring.datasource.hikari.db1")
    fun dataSource1(): DataSource? {
        return DataSourceBuilder.create().type(HikariDataSource::class.java).build()
    }

//    @Bean
//    @ConfigurationProperties("spring.datasource.hikari.db2")
//    fun dataSource2(): DataSource? {
//        return DataSourceBuilder.create().type(HikariDataSource::class.java).build()
//    }

//    @Autowired
//    @Qualifier(value = "dataSource1")
//    private val dataSource1: DataSource? = null

//    @Autowired
//    @Qualifier(value = "dataSource2")
//    private val dataSource2: DataSource? = null

//    @Bean
//    @Throws(Exception::class)
//    fun sqlSessionFactory2(): SqlSessionFactory? {
//        val sqlSessionFactoryBean = SqlSessionFactoryBean()
//
//        sqlSessionFactoryBean.setDataSource(dataSource2)
//        val resolver = PathMatchingResourcePatternResolver()
//        val resources = resolver.getResources("classpath*:mybatis/**/*.xml")
//        sqlSessionFactoryBean.setMapperLocations(*resources)
//        return sqlSessionFactoryBean.getObject()
//    }

    @Bean
    @Primary
    @Throws(Exception::class)
    fun sqlSession1(): SqlSession? {
        val sqlSessionFactoryBean = SqlSessionFactoryBean()
        sqlSessionFactoryBean.setDataSource(dataSource1())
        val resolver = PathMatchingResourcePatternResolver()
        val resources = resolver.getResources("classpath*:mybatis/**/*.xml")
        sqlSessionFactoryBean.setMapperLocations(*resources)
        val sqlSessionFactory1 = sqlSessionFactoryBean.getObject()

        return SqlSessionTemplate(sqlSessionFactory1)
    }

//    @Bean
//    @Throws(Exception::class)
//    fun sqlSession2(): SqlSession? {
//        return SqlSessionTemplate(sqlSessionFactory2())
//    }

}