package org.lhyf.mybatis.test;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author YF
 * @date 2021/08/07 08:48
 * @Description
 */
public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<Driver> drivers = ServiceLoader.load(Driver.class);
        Iterator driversIterator = drivers.iterator();

        try{
            while(driversIterator.hasNext()) {
                System.out.println(" Loading done by the java.util.ServiceLoader :  "+driversIterator.next());
            }
        } catch(Throwable t) {
            // Do nothing
        }

    }
}
