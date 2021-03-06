package method2.load;

import method2.load.custom.MyClassLoader;
import method2.load.manager.BaseManager;

/**
 * Created by Jean on 2017/2/17.
 */
public class LoadInfo {

    private MyClassLoader myLoader;
    private long loadTime;
    private BaseManager manager;

    public LoadInfo(MyClassLoader myLoader,long loadTime){
        this.myLoader = myLoader;
        this.loadTime = loadTime;
    }
    public MyClassLoader getMyLoader() {
        return myLoader;
    }
    public void setMyLoader(MyClassLoader myLoader) {
        this.myLoader = myLoader;
    }
    public long getLoadTime() {
        return loadTime;
    }
    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }
    public BaseManager getManager() {
        return manager;
    }
    public void setManager(BaseManager manager) {
        this.manager = manager;
    }



}
