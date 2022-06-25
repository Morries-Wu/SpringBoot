import Com.Config.SpringConfig;
import Com.Vo.Cat;
import Com.Vo.Student;
import Com.Vo.Tiger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {

    /*
     * 使用xml作为容器配置文件*/
    @Test
    public void test01() {
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Student myStudent = (Student) ctx.getBean("myStudent");
        System.out.println("容器中的对象:" + myStudent);

    }

    /**
     * 使用JavaConfing
     */
    @Test
    public void test02() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student student = (Student) ctx.getBean("createStudent");
        System.out.println("使用JavaConfig创建的bean对象:" + student);

    }

    /**
     * 使用ImportResource
     */
    @Test
    public void test03() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Cat myCat = (Cat) ctx.getBean("myCat");
        System.out.println(myCat);
    }

    @Test
    public void test04() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Tiger tiger = (Tiger) ctx.getBean("tiger");
        System.out.println(tiger);
    }

    @Test
    public void test05() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student student = (Student) ctx.getBean("makeStudent");
        System.out.println(student);
    }

}
