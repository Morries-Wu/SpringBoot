#改造成Dubbo
    1、添加dubbo核心依赖
    2、添加要使用的注册中心依赖
    3、添加要使用的协议依赖
    4、配置dubbo相关的信息
    5、配置注册中心地址
    6、配置所使用的协议

#增加依赖
    <dependency>
            <groupId>org.apache.dubbo</groupId>
            <artifactId>dubbo-spring-boot-starter</artifactId>
            <version>3.0.7</version>
        </dependency>

        <dependency>
            <groupId>org.apache.dubbo</groupId>
            <artifactId>dubbo-rpc-dubbo</artifactId>
            <version>3.0.7</version>
        </dependency>

        <dependency>
            <groupId>org.apache.dubbo</groupId>
            <artifactId>dubbo-registry-zookeeper</artifactId>
            <version>3.0.7</version>
        </dependency>

#配置properties
    dubbo.application.name=provider-apllication
    dubbo.protocol.name=dubbo
    dubbo.protocol.port=20880
    dubbo.registry.address=zookeeper://127.0.0.1:2181

#改造服务
    cunsumer和provider中都用到User类,所以可以单独新建一个maven项目来存储
    consumer和provider公用的一些类,新增一个common模块,把User类转移到这个模块中
    
    要改造成Dubbo,得先抽象出来服务,用接口表示
    
    像UserService就是一个服务,不过我们得额外定义一个接口,把我们之前的UserService
    改为UserServiceImpl,然后新定义一个接口UserService,该接口表示一个服务,UserServiceImpl为该服务的具体表现

    public inteface UserService{
        public User getUser(String uid);
    }

    @DubboService
    public class UserService implements UserService{
        public User getUser(String uid){
            User user=new User(uid,"Morries_Wu");
            return user;
        }
    }


