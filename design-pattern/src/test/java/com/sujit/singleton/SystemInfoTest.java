package com.sujit.singleton;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SystemInfoTest {


    @Test
    public void whenCalledGetInstanceTwoTimesShouldReturnSameObject() {
        assertEquals(SystemInfo.getInstance(), SystemInfo.getInstance());
    }

    @Test
    public void whenCalledGetInstanceMultipleTimesShouldReturnSameObject() {
        List<SystemInfo> instanceList = new ArrayList<>();
        instanceList.add(SystemInfo.getInstance());
        instanceList.add(SystemInfo.getInstance());
        instanceList.add(SystemInfo.getInstance());
        instanceList.add(SystemInfo.getInstance());
        instanceList.add(SystemInfo.getInstance());

        long countDiffernetObj = instanceList.stream().filter(instance -> instance.hashCode() != SystemInfo.getInstance().hashCode()).count();

        assertEquals(0,countDiffernetObj);
    }


    @Test
    public void whenCalledPrivateConstructorShouldSingletonRuleViolationException() {
       SystemInfo instance = SystemInfo.getInstance();
            Throwable exception = assertThrows(SingletonRuleViolationException.class, () -> {
                Constructor<SystemInfo> cons = SystemInfo.class.getDeclaredConstructor();
                cons.setAccessible(true);
                try {
                    cons.newInstance(); 
                }catch (InvocationTargetException ite ){
                    throw (Exception) ite.getCause();
                }
            });
        assertEquals("This Singleton Class is already initialized. Use getInstance Method instead",exception.getMessage());
    }

    @Test
    public void whenCalledWithMultipleThreadsShouldReturnSameObject() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(1000);
        List<Callable<Integer>> callables = new ArrayList<>();
        IntStream.range(1, 1000).forEach(i -> {
            callables.add(() -> SystemInfo.getInstance().hashCode());
        });

        List<Future<Integer>> hashValueList = executor.invokeAll(callables);
        boolean isFinished  = executor.awaitTermination(1, TimeUnit.SECONDS);

        long actual = hashValueList.stream().map(integerFuture -> {
            try {
                return integerFuture.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return null;
        }).filter(hashVal -> !hashVal.equals(SystemInfo.getInstance().hashCode())).count();
        assertEquals(0,actual);
    }
}