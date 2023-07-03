package com.reeqr;

import java.util.concurrent.*;

/*
    需求: Callable任务处理使用步骤
        1 创建线程池
        2 定义Callable任务
        3 创建Callable任务，提交任务给线程池
        4 获取执行结果

    <T> Future<T> submit(Callable<T> task) : 提交Callable任务方法    
    返回值类型Future的作用就是为了获取任务执行的结果。
    Future是一个接口，里面存在一个get方法用来获取值

    练一练：使用线程池计算 从0~n的和，并将结果返回
 */
public class Test2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建指定线程数量的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        Future<Integer> future = threadPool.submit(new CalculateTask(100));
        Integer sum = future.get();
        System.out.println(sum);
    }
}

// 使用线程池计算 从0~n的和，并将结果返回
class CalculateTask implements Callable<Integer> {
    private int num;

    public CalculateTask(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;// 求和变量
        for (int i = 0; i <= num; i++) {
            sum += i;
        }
        return sum+3;
    }
}
