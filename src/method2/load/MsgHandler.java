package method2.load;


import method2.load.manager.BaseManager;

import java.io.File;

/**
 * Created by Jean on 2017/2/17.
 */
public class MsgHandler implements Runnable{

    public void run() {

        while(true){
            BaseManager manager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
            manager.logic()
;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //class文件的热加载
    public static void main(String[] args) {
        new Thread(new MsgHandler()).start();
 /*     File loadFile = new File("/Users/Jean/Work/客户信息/Java热重载/Test/out/production/Test/" +
              ""+ManagerFactory.MY_MANAGER.replaceAll(".","/")+".class");
      long lastModified = loadFile.lastModified();
      System.out.println("method2.load.manager.MyManager".replaceAll("\\.","/"));*/
    }

}