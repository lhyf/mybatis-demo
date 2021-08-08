package org.lhyf.mybatis.proxy;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.lhyf.mybatis.bean.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author YF
 * @date 2021/08/08 10:00
 * @Description
 */
public class JdkProxyTest {


    /**
     * 自己编写的代理类,需要为代理接口的所有方法,返回不同的结果类型
     *
     * @param args
     */
    public static void main(String[] args) {

        ClassLoader classLoader = UserMapper.class.getClassLoader();
        UserMapper instance = (UserMapper) Proxy.newProxyInstance(classLoader, new Class<?>[]{UserMapper.class},
                new MapperInvocationHandler());

        String s = instance.toString();
        System.out.println("调用Object声明的方法返回值:" + s);

        User user = instance.getUserById(1);
        System.out.println(user);

        List<User> userList = instance.getUserList();
        System.out.println(userList);
    }

}

class MapperInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            System.out.println("调用Object声明的方法....");
            return method.invoke(this, args);
        }
        System.out.println("入参是:" + args);
        Type methodReturnType = method.getGenericReturnType();
        System.out.println("代理方法被调用...");
        return new User(Integer.parseInt(String.valueOf(args[0])), "张三");
    }
}
