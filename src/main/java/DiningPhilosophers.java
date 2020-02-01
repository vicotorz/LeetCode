import java.util.concurrent.Semaphore;

/**
 * LeetCode-1226
 * The Dining Philosophers
 */
public class DiningPhilosophers {
    private Semaphore[] semaphore = new Semaphore[5];// 对叉子进行加锁
    private Semaphore eatingPeople = new Semaphore(2);
    // permits代表同一时间内，最多允许多少个线程同时执行acquire()和release()之间的代码。

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            semaphore[i] = new Semaphore(1);
        }
    }

//	output[i] = [a, b, c] (3个整数)
//    		- a 哲学家编号。
//    		- b 指定叉子：{1 : 左边, 2 : 右边}.
//    		- c 指定行为：{1 : 拿起, 2 : 放下, 3 : 吃面}。
//    		如 [4,2,1] 表示 4 号哲学家拿起了右边的叉子。

    // 【0】---0---【1】
    // 【1】---1---【2】
    // 【2】---2---【3】
    // 【3】---3---【4】
    // 【4】---4---【0】

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
                           Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {

        int leftFork = philosopher;
        int rightFork = (philosopher+5-1)%5;

        eatingPeople.acquire();
        // 拿起左//拿起右
        semaphore[leftFork].acquire();
        semaphore[rightFork].acquire();
        // 吃饭
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();

        // 放下左
        // 放下右
        putLeftFork.run();
        putRightFork.run();
        semaphore[leftFork].release();
        semaphore[rightFork].release();

        eatingPeople.release();
    }
}
