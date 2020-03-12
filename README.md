# swaggerdoc
根据swagger访问路径,导出完整规范的接口文档
<br>

### 说明

<font face="STCAIYUN">如果只是需要嵌入已存在的swagger项目，
加上maven配置，加入test里的Swagger2Doc.java修改url就可以了。
</font>
<br>实现转换使用的是Swagger2Markup
##### 引入Swagger2Markup
```xml
<dependency>
    <groupId>io.github.swagger2markup</groupId>
    <artifactId>swagger2markup</artifactId>
    <version>1.3.3</version>
</dependency>
```

这时候执行测试类内容时，通常会报一个错。如相关jar包不存，如
```ftl
NoClassDefFoundError: ch/netzwerg/paleo/ColumnIds$StringColumnId
```

等等，官方给的解释一般是，加上：
```xml
<repositories>
    <repository>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
        <id>jcenter-releases</id>
        <name>jcenter</name>
        <url>http://jcenter.bintray.com</url>
    </repository>
</repositories>
```

如果没解决，我这就是这个情况，可以把上面的repositories内容改为：
```xml
<repositories>
    <repository>
        <id>spring-libs-milestone</id>
        <url>https://repo.spring.io/libs-milestone</url>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
    </repository>
    <!-- jhipster-needle-maven-repository -->
</repositories>
<pluginRepositories>
    <pluginRepository>
        <id>spring-plugins-release</id>
        <url>https://repo.spring.io/plugins-release</url>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
    </pluginRepository>
</pluginRepositories>
```

##### 编写测试类
 可以直接用这里的测试目录里的Swagger2Doc.java，还可以根据Swagger2Markup
 的说明做一些个性化的修改。
 
### 如何使用swaggerdoc
（后面准备在加上转word、pdf等格式，加上docker方便快速部署）<br>
启动swaggerdoc后，访问http://localhost:8080
<br>
![image](https://github.com/OceanBBBBbb/swaggerdoc/blob/master/mdfiles/1.png)
<br>
正常将看到如图页面，输入可访问的swagger-api文档地址，注意是这个一般后缀为api-docs的可以访问到
文档json内容的地址。而不是swagger-ui.html这个。如图
<br>
![image](https://github.com/OceanBBBBbb/swaggerdoc/blob/master/mdfiles/2.png)

<br>
然后选择文档类型：<br>
 * Markdown: 就是熟悉的README.MD格式，拿到后，导入到Markdown编辑器即可。<br>
 * Confluence: wiki格式，在Confluence中使用时，导入为wiki格式。<br>
 * AsciiDocs: 这个我也不知道在哪用。<br>

可以看一下Markdown的效果：<br>
![image](https://github.com/OceanBBBBbb/swaggerdoc/blob/master/mdfiles/md.png)
<br>和<br>
![image](https://github.com/OceanBBBBbb/swaggerdoc/blob/master/mdfiles/md2.png)

<br>
Confluence的效果（截图内容都是冰山一角）<br>
![image](https://github.com/OceanBBBBbb/swaggerdoc/blob/master/mdfiles/cf.png)





