package com.maple.controller

import com.google.gson.Gson
import javax.sql.DataSource

import wangzx.scala_commons.sql._

object ResourceProcessor {

  case class TestBean(id: Int, name: String, age: String)

  private val gson = new Gson


  def getResource(dataSource: DataSource): String = {

    val testBeanList: List[TestBean] = dataSource.rows[TestBean](sql"select * from test")

    gson.toJson(testBeanList)

  }

}
