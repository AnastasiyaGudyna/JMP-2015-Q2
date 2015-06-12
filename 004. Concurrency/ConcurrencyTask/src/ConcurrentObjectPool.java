import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentObjectPool
{

    private static final int MAX_SIZE = 10;
    private static ConcurrentObjectPool instance;
    private static ReentrantLock lock = new ReentrantLock();
    private int currentPoolSize = 0;
    private LinkedBlockingQueue<Object> objects = new LinkedBlockingQueue<Object>(MAX_SIZE);

    private ConcurrentObjectPool()
    {
        super();
    };

    public static ConcurrentObjectPool getInstance()
    {
        if (instance == null)
        {
            try
            {
                lock.lock();
                if (instance == null)
                {
                    instance = new ConcurrentObjectPool();
                }
            }
            finally
            {
                lock.unlock();
            }
        }

        return instance;
    }

    public Object acquireObject() throws InterruptedException
    {
        Object object = objects.poll();
        if (object == null)
        {
            if (currentPoolSize < MAX_SIZE)
            {
                try
                {
                    lock.lock();
                    if (currentPoolSize < MAX_SIZE)
                    {
                        currentPoolSize++;
                        object = new Object();
                    }
                }
                finally
                {
                    lock.unlock();
                }
            }
            else
            {
                object = objects.take();
            }
        }

        return object;
    }

    public void releaseObject(Object object) throws InterruptedException
    {
        objects.put(object);
    }
}
