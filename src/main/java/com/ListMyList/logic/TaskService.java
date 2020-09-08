package com.ListMyList.logic;

import com.ListMyList.model.comment.Comment;
import com.ListMyList.model.DTO.TaskReadModel;
import com.ListMyList.model.DTO.TaskWriteModel;
import com.ListMyList.model.task.Task;
import com.ListMyList.model.task.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Optional <TaskReadModel> readTask (Long id){
        if (taskRepository.existsById(id)) {
            return Optional.ofNullable(new TaskReadModel(taskRepository.findById(id).get()));
        }
        return Optional.empty();
    }

    public List<TaskReadModel> findAll(){
        List<TaskReadModel> allTasks = new ArrayList<>();

        for (Task task: taskRepository.findAll()) {
            allTasks.add(new TaskReadModel(task));
        }
        return allTasks;
    }

    public Task createTask (TaskWriteModel toCreate){
        Task result = taskRepository.save(toCreate.toTask());
        return result;
    }

    public Set<Comment> commentList(Long id){
        if (taskRepository.existsById(id)){
           return taskRepository.findById(id).get().getCommentsList();
        }
        return new HashSet<Comment>();
    }
}
