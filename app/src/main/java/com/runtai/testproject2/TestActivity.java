package com.runtai.testproject2;

import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.runtai.testproject2.cehua.BaseActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @作者：高炎鹏
 * @日期：2017/3/21时间16:05
 * @描述：线程测试
 */
public class TestActivity extends BaseActivity{

    private static final String TAG = "TestActivity";
    private ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(128));;

    @Override
    protected void beforeSetContent() {

    }

    @Override
    protected int getView() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView() {
        id_test_1 = (Button) findViewById(R.id.id_test_1);
        id_test_2 = (Button) findViewById(R.id.id_test_2);
        id_test_3 = (Button) findViewById(R.id.id_test_3);
        id_test_4 = (Button) findViewById(R.id.id_test_4);
        id_test_1.setOnClickListener(this);
        id_test_2.setOnClickListener(this);
        id_test_3.setOnClickListener(this);
        id_test_4.setOnClickListener(this);
    }

    private Button id_test_1, id_test_2, id_test_3, id_test_4;

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()){
            case R.id.id_test_1:
                ten();
                break;
            case R.id.id_test_2:
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(2000);
                        Log.e("google_lenve_fb", "run: " + "添加的一个线程");
                    }
                };
                chuanshu(runnable);
                break;
            case R.id.id_test_3:
                break;
            case R.id.id_test_4:
                break;
        }
    }

    /**
     * newFixedThreadPool创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程。
     * <p>
     * 运行结果：总共只会创建5个线程， 开始执行五个线程
     * 当五个线程都处于活动状态，再次提交的任务都会加入队列等到其他线程运行结束
     * 当线程处于空闲状态时会被下一个任务复用
     */
    public void one() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 30; i++) {
            final int finalI = i;
            Runnable runnable = new Runnable(){
                @Override
                public void run() {
                    SystemClock.sleep(3000);
                    Log.d("google_lenve_fb", "run: "+ finalI);
                }
            };
            executorService.execute(runnable);
        }
    }

    /**
     * newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程
     * <p>
     * 可以看出缓存线程池大小是不定值，可以需要创建不同数量的线程
     * 在使用缓存型池时，先查看池中有没有以前创建的线程，如果有，就复用.如果没有，就新建新的线程加入池中
     * 缓存型池子通常用于执行一些生存期很短的异步型任务
     */
    public void two() {
        ExecutorService executorService = (ExecutorService) Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            Runnable syncRunnable = new Runnable() {
                @Override
                public void run() {
                    Log.e(TAG, Thread.currentThread().getName());
                }
            };
            executorService.execute(syncRunnable);
        }
    }

    /**
     * newScheduledThreadPool创建一个定长线程池，支持定时及周期性任务执行
     * <p>
     * 运行结果和newFixedThreadPool类似，不同的是newScheduledThreadPool是延时一定时间之后才执行
     */
    public void three() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 20; i++) {
            Runnable syncRunnable = new Runnable() {
                @Override
                public void run() {
                    Log.e(TAG, Thread.currentThread().getName());
                }
            };
            executorService.schedule(syncRunnable, 5000, TimeUnit.MILLISECONDS);
            /**
             * 创建并执行一个在给定初始延迟后首次启用的定期操作，后续操作具有给定的周期；
             *
             * 也就是将在 initialDelay 后开始执行，然后在initialDelay+period 后执行，接着在 initialDelay + 2 * period 后执行
             */
            //executorService.scheduleAtFixedRate(syncRunnable, 5000, 3000, TimeUnit.MILLISECONDS);
            /**
             * 创建并执行一个在给定初始延迟后首次启用的定期操作，随后，在每一次执行终止和下一次执行开始之间都存在给定的延迟
             */
            //executorService.scheduleWithFixedDelay(syncRunnable, 5000, 3000, TimeUnit.MILLISECONDS);
        }
    }

    /**
     * newSingleThreadExecutor创建一个单线程化的线程池
     * 它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO<先入先出>, LIFO<后进先出>, 优先级)执行
     */
    public void four() {
        ExecutorService executorService = (ExecutorService) Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            Runnable syncRunnable = new Runnable() {
                @Override
                public void run() {
                    Log.e(TAG, Thread.currentThread().getName());
                }
            };
            executorService.execute(syncRunnable);
        }
    }

    /**
     * 实现(延时)的单线程线程池
     */
    public void five() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        for (int i = 0; i < 20; i++) {
            Runnable syncRunnable = new Runnable() {
                @Override
                public void run() {
                    Log.e(TAG, Thread.currentThread().getName());
                }
            };
            executorService.execute(syncRunnable);
            /**
             * 延时
             */
            //executorService.schedule(new Thread(), 1000, TimeUnit.MILLISECONDS);
        }
    }

    /**
     * public ThreadPoolExecutor(int corePoolSize,                     线程池中核心线程的数量
     *                           int maximumPoolSize,                  线程池中最大线程数量
     *                           long keepAliveTime,                   非核心线程的超时时长，当系统中非核心线程闲置时间超过keepAliveTime之后，则会被回收。如果ThreadPoolExecutor的allowCoreThreadTimeOut属性设置为true，则该参数也表示核心线程的超时时长
     *                           TimeUnit unit,                        第三个参数的单位，有纳秒、微秒、毫秒、秒、分、时、天等
     *                           BlockingQueue<Runnable> workQueue,    线程池中的任务队列，该队列主要用来存储已经被提交但是尚未执行的任务。存储在这里的任务是由ThreadPoolExecutor的execute方法提交来的。
     *                           ThreadFactory threadFactory,          为线程池提供创建新线程的功能，这个我们一般使用默认即可
     *                           RejectedExecutionHandler handler)     拒绝策略，当线程无法执行新任务时（一般是由于线程池中的线程数量已经达到最大数或者线程池关闭导致的），默认情况下，当线程池无法处理新线程时，会抛出一个RejectedExecutionException。
     *
     * 这里是7个参数(我们在开发中用的更多的是5个参数的构造方法)
     *
     */
    public void ten() {
        for (int i = 0; i < 30; i++) {
            final int finalI = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    SystemClock.sleep(2000);
                    Log.e("google_lenve_fb", "run: " + finalI);
                }
            };
            poolExecutor.execute(runnable);
        }
    }

    public void chuanshu(Runnable runnable){
        poolExecutor.execute(runnable);
        Future future =  poolExecutor.submit(runnable);
        future.isDone();
    }

    public void eleven(){
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 30, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(6));
        for (int i = 0; i < 30; i++) {
            final int finalI = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    SystemClock.sleep(2000);
                    Log.d("google_lenve_fb", "run: " + finalI);
                }
            };
            poolExecutor.execute(runnable);
        }
    }

}
