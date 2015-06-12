import java.util.ArrayList;

public class ClassicalObjectPool
{
    private static final int MAX_SIZE = 10;
    private static ClassicalObjectPool instance;
    private int currentPoolSize = 0;
    private ArrayList<Object> objects = new ArrayList<Object>();

    private ClassicalObjectPool()
    {
        super();
    };

    public static ClassicalObjectPool getInstance()
    {
        if (instance == null)
        {
            synchronized (ClassicalObjectPool.class)
            {
                if (instance == null)
                {
                    instance = new ClassicalObjectPool();
                }
            }
        }

        return instance;
    }

    public synchronized Object acquireObject() throws InterruptedException
    {
        while (objects.isEmpty())
        {
            if (currentPoolSize < MAX_SIZE)
            {
                currentPoolSize++;
                return new Object();
            }
            else
            {
                objects.wait();
            }
        }

        Object object = objects.get(0);
        objects.remove(object);
        objects.notifyAll();

        return object;
    }

    public synchronized void releaseObject(Object object)
    {
        objects.add(object);
        objects.notifyAll();
    }

}
