package com.gudyna.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ServiceMock
{
    public void saveMember(String name, String surname)
    {
        System.out.print("Saved");
    }

    public void deleteMember(String name, String surname)
    {
        System.out.print("Deleted");
    }

    @Async
    public void deleteAllMembers()
    {
        System.out.print("All members were deleted");
    }
}
