# My First Spring Boot Scaffolding
## Info
- **Name**:Scaffolding
- **Create Time**:2018年2月24日13点11分
## Tools
- **Mybatis**
- **Thymeleaf**
- **JDBC**
- **MySQL**
### [通用Mapper](https://mapperhelper.github.io)
重点强调 @Transient 注解

许多人由于不仔细看文档，频繁在这个问题上出错。

如果你的实体类中包含了不是数据库表中的字段，你需要给这个字段加上@Transient注解，这样通用Mapper在处理单表操作时就不会将标注的属性当成表字段处理！

### MyBatis Generator

生成代码的方法:

在pom.xml这一级目录的命令行窗口执行mvn mybatis-generator:generate即可**前提是配置了mvn**
    
### 时间转格式注解
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")//解决时区问题，没有timezone会少一天

### [PageHelper](文档地址：https://pagehelper.github.io/)
```java
public PageInfo getUsers(){
    PageHelper.startPage(2,10);  //页码，数据条数
    List list = mapper.selectAll();//查询数据
    PageInfo<User> userPageInfo = new PageInfo<User>(list);//分页处理
    System.out.println(userPageInfo.getPages());//总页数
    userPageInfo.getList() {}//获取当页列表
    return userPageInfo;
}
```