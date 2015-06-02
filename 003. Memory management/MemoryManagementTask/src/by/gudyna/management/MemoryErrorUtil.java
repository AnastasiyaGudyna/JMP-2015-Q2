package by.gudyna.management;

import java.util.ArrayList;

public class MemoryErrorUtil
{

    public static void getErrorByCode(MemoryManagementController.ExecutionType type)
    {
        switch (type)
        {
        case META:
            MemoryErrorUtil.getPermGenError();
            break;
        case STACK:
            MemoryErrorUtil.getStackOverflowException();
            break;
        case MEMORY:
            MemoryErrorUtil.getOutOfMemoryError();
            break;
        }
    }

    private static void getOutOfMemoryError()
    {
        ArrayList<Object> list = new ArrayList<Object>();
        while (true)
        {
            list.add(new Object());
        }
    }

    private static void getStackOverflowException()
    {
        int[] a = new int[100];
        while (true)
        {
            getStackOverflowException();
        }
    }

    private static void getPermGenError()
    {
        System.out.println("Sorry, but I can't do it");
    }
}
