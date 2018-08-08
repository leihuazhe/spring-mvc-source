## 父子容器

`web-mvc`环境下,有父子容器的概念

- 父容器 `WebApplicationContext`

```
Root WebApplicationContext: startup date [Wed Aug 08 12:44:18 CST 2018]; root of context hierarchy
```

- 子容器 NameSpace for DispatcherServlet `WebApplicationContext`
```
WebApplicationContext for namespace 'appServlet-servlet': startup date [Wed Aug 08 12:44:31 CST 2018]; parent: Root WebApplicationContext

```
### web.xml DispatcherServlet 配置
web.xml中对DispatcherServlet的配置，如果不指定其spring.xml地址，默认的地址及文件名为:
`WEB-INF/${servletName}-servlet.xml`.本例中的文件为`appServlet-servlet.xml`

```xml
    <!-- servlet 分发器 -->
    <servlet>
        <servlet-name>appServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!--<init-param>
            <param-name>contextConfigLocation</param-name>
            &lt;!&ndash;默认&ndash;&gt;
            <param-value></param-value>
        </init-param>-->
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>appServlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    <servlet-mapping>
        <servlet-name>appServlet</servlet-name>
        <url-pattern>*.html</url-pattern>
    </servlet-mapping>
```