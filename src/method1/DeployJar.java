package method1;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @ClassName DeployJar
 * @Description 热加载Jar包
 * @Author weizhi2018
 * @Date 2013-8-30 上午08:59:27
 *
 */

public class DeployJar {
    // 后缀
    private final static String CLAZZ_SUFFIX = ".class";

    // 类加载器
    private ClassLoader classLoader;

    /**
     * @Title loadPath
     * @Description 创建加载器
     * @Author weizhi2018
     * @param jarPath
     *            jar包所在路经
     * @throws
     */
    public void loadPath(String jarPath) {
        try {
            File jarFiles = new File(jarPath);

            File[] jarFilesArr = jarFiles.listFiles();
            URL[] jarFilePathArr = new URL[jarFilesArr.length];
            int i = 0;
            for (File jarfile : jarFilesArr) {
                String jarname = jarfile.getName();
                if (jarname.indexOf(".jar") < 0) {
                    continue;
                }
                //String jarFilePath = "file:\\" + jarPath + File.separator
                String jarFilePath = "file:\\" + jarPath + File.separator
                        + jarname;
                jarFilePathArr[i] = new URL(jarFilePath);
                i++;
            }

            classLoader = new URLClassLoader(jarFilePathArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Title loadJar
     * @Description 遍历jar包下的类
     * @Author weizhi2018
     * @param jarName
     *            jar包名字 完整路径
     * @throws
     */
    public void loadJar(String jarName) {
        if (jarName.indexOf(".jar") < 0) {
            return;
        }
        try {
            JarFile jarFile = new JarFile(jarName);
            Enumeration<JarEntry> em = jarFile.entries();
            while (em.hasMoreElements()) {
                JarEntry jarEntry = em.nextElement();
                String clazzFile = jarEntry.getName();

                if (!clazzFile.endsWith(CLAZZ_SUFFIX)) {
                    continue;
                }
                String clazzName = clazzFile.substring(0,
                        clazzFile.length() - CLAZZ_SUFFIX.length()).replace(
                        '/', '.');
                System.out.println(clazzName);

                // loadClass(clazzName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Title loadClass
     * @Description 通过类加载器实例化
     * @Author weizhi2018
     * @param clazzName
     *            类名字
     * @return
     * @throws
     */
    public Object loadClass(String clazzName) {
        if (this.classLoader == null) {
            return null;
        }
        Class clazz = null;
        try {
            clazz = this.classLoader.loadClass(clazzName);
            Object obj = clazz.newInstance();
            return obj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoClassDefFoundError e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}