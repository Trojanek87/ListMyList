package com.ListMyList.controller;


import com.ListMyList.logic.TaskService;
import com.ListMyList.model.comment.Comment;
import com.ListMyList.model.comment.CommentRepository;
import com.ListMyList.model.DTO.TaskReadModel;
import com.ListMyList.model.DTO.TaskWriteModel;
import com.ListMyList.model.task.Task;
import com.ListMyList.model.task.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final TaskRepository repository;
    @Autowired
    private final CommentRepository cRepository;
    public static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    TaskController(final TaskRepository repository, final CommentRepository cRepository, final TaskService taskService) {
        this.repository = repository;
        this.cRepository = cRepository;
        this.taskService = taskService;
    }

    @PostMapping
    ResponseEntity<Task> createTask(@RequestBody @Valid TaskWriteModel toCreate){

        Task result = taskService.createTask(toCreate);
        logger.warn("Task added");
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping(params = {"!sort", "!page", "!size" })
    ResponseEntity<?> readAllTasks(){
        logger.warn("Exposing all the tasks");
        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping
    ResponseEntity<List<Task>> readAllTasks(Pageable page){
        logger.warn("Exposing all the tasks");
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }
    @GetMapping("/{id}")
    ResponseEntity<TaskReadModel> readTask(@PathVariable Long id){
        return taskService.readTask(id)
                .map(task -> ResponseEntity.ok(task))  /*(ResponseEntity::ok)*/
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/comments")
    ResponseEntity <Set<Comment>> readComments(@PathVariable Long id){
        return ResponseEntity.ok(taskService.commentList(id));
    }

//    @GetMapping("/{id}")
//    ResponseEntity<Task> readTask(@PathVariable Long id){
//        return repository.findById(id)
//                .map(task -> ResponseEntity.ok(task))  /*(ResponseEntity::ok)*/
//                .orElse(ResponseEntity.notFound().build());
//    }

//    @GetMapping(path = "/tasks/comment/{id}")
//    ResponseEntity<List<Comment>> readTaskComment(@PathVariable Long id){
//        List<Comment> commentList = new ArrayList<>();
//
//
//
//
//        repository.findById(id)
//                .ifPresent(task -> task.findAllComment().addAll(commentList));
//
//        return ResponseEntity.ok(commentList);
//
//    }


    @PatchMapping(path = "/{id}", params ={"!comment"} )
    ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody Task toUpdate){
        if(!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        repository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }

//    @Transactional
//    @PatchMapping(path = "/comment/{id}")
//    ResponseEntity<?> addComment (@RequestBody @Valid Comment toCreate, @PathVariable Long id) {
//        if (!repository.existsById(id)){
//            logger.warn("nieudane dodanie komenta");
//            return ResponseEntity.notFound().build();
//        }
//
//
//
//        toCreate.setTask(repository.findById(id).orElse(new Task()));
//        var newComment = cRepository.save(toCreate);
//
//        repository.findById(id)
//                .ifPresent(task -> task.addComment(newComment));
//        logger.warn("udane dodanie komenta");
//        return ResponseEntity.ok().build();
//
//    }

    @DeleteMapping(path = "/{id}")
    ResponseEntity<?> deleteTask(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }



}
