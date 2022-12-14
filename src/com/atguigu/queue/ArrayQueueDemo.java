package com.atguigu.queue;

import java.util.Scanner;

/**
 * @Description: // 类说明，在创建类时要填写
 * @ClassName: ArrayQueueDemo    // 类名，会自动填充
 * @Author: MYH          // 创建者
 * @Date: 2022/8/21 20:51   // 时间
 * @Version: 1.0     // 版本
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取数据");
            System.out.println("h(head):查看队列头的数据");
            char key = scanner.next().charAt(0);//接收用户输入一个字符
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.print("请输入一个数：");
                    int i = scanner.nextInt();
                    arrayQueue.addQueue(i);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是：%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("头部数据是：%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
            }
        }
        System.out.println("程序以退出！");
    }
}

//使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue{
    private  int maxSize;//表示数组的最大容量
    private  int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数组用于存放数据,模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        front=-1;//指向队列的头部，分析出front是指向队列头的前一个位置
        rear=-1;//指向队列尾，指向队列尾的数据（即就是队列的最后一个数据）
    }
    //判断队列是否满
    public boolean isFull(){
        return rear==maxSize-1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return front==rear;
    }
    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if (isFull()){
            System.out.println("队列满，不能加入数据");
            return;
        }
        rear++;//让rear后移
        arr[rear]=n;
    }
    //从队列中取数据
    public int getQueue(){
        //判断队列是否空
        if (isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列空，不能取数据");//throw本身会导致代码return
        }
        front++;
        return arr[front];
    }
    //显示队列的所以数据
    public void showQueue(){
        //遍历arr数组
        if (isEmpty()){
            System.out.println("队列空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);//格式化输出
        }
    }
    //显示队列的头数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front+1];
    }
}