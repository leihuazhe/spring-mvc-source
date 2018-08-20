package com.maple.eventbus.bus

import com.maple.eventbus.bus.entity.TestBeanClass
import com.today.eventbus.AbstractEventBus
import wangzx.scala_commons.sql._

/**
  * desc: EventBus
  *
  * @author hz.lei
  * @since 2018年08月18日 下午8:41
  */
object EventBus extends AbstractEventBus {

  override def dispatchEvent(event: Any): Unit = {
    val beans = dataSource.rows[TestBeanClass](sql"select * from test")
    beans.foreach(println)
  }

  override def getInstance: EventBus.this.type = this
}
