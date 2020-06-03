package com.zhouyer.spbdemo.study.thread.alarm;

/**
 * @ClassName AlarmAgent
 * @Description 告警代理
 * @Author zhouyer
 * @Date 2020/4/28 20:20
 * @Version 1.0
 **/
public class AlarmAgent {
    private final static AlarmAgent INSTANCE = new AlarmAgent();

    //连接服务器状态
    private boolean connectToServer = false;
    private AlarmAgent() {

    }

    public static AlarmAgent getINSTANCE() {
        return INSTANCE;
    }

    public void sendAlarm(String msg) throws InterruptedException {
        synchronized (this){
            while(!connectToServer){
                System.out.println("无法连接到服务器");
                wait();
            }
            //发送信息
            doSendMsg(msg);
        }
    }

    private void init() {

    }

    private void connectToServerThread(){
        new Thread(()->{
            //模拟连接
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this){

            }
        }).start();
    }
    private void doSendMsg(String message) {
        System.out.println("Alarm send " + message);
    }
}
