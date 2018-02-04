package com.crud.tasks.counter;

import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskCounter {

    @Autowired
    private TaskRepository taskRepository;

    public String countTasks() {
        long size = taskRepository.count ();
        String task = size == 1 ? " task" : " tasks";
        return "Currently in database you got: " + size + task;
    }
}
