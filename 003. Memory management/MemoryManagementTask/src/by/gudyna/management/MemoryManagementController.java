package by.gudyna.management;

public class MemoryManagementController
{
    enum ExecutionType
    {
        META, STACK, MEMORY;
    }

    private static final String ARG_TYPE_MESSAGE = "For execution enter, please, one of: stack | memory | meta";

    public static void main(String args[])
    {
        if (args.length < 1)
        {
            System.out.println(ARG_TYPE_MESSAGE);
            System.exit(0);
        }

        String typeFromCommandLine = args[0].toUpperCase();

        try
        {
            ExecutionType type = ExecutionType.valueOf(typeFromCommandLine);
            MemoryErrorUtil.getErrorByCode(type);
        }
        catch (IllegalArgumentException ex)
        {
            System.out.println(ARG_TYPE_MESSAGE);
        }
    }
}
