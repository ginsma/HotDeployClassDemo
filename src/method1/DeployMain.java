package method1;

import java.io.File;

/**
 * @ClassName DeployMain
 * @Description TODO
 * @Author weizhi2018
 * @Date 2013-8-30 上午09:59:46
 *
 */

public class DeployMain {

    //Jar文件的热加载
    public static void main(String[] args) throws InterruptedException {
        while(true) {
            String libpath = System.getProperty("user.dir") + File.separator + "lib";

            DeployJar deployJar = new DeployJar();

            deployJar.loadPath(libpath);

            System.out.println(deployJar.loadClass("ognl.OgnlContext"));

            String jarPath = libpath + File.separator + "mybatis-spring-1.3.0.jar";
            deployJar.loadJar(jarPath);
            Thread.sleep(4000);
        }
    }

}