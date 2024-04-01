package com.todo.todolist.service;

import com.todo.todolist.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoServiceTests {

    @Autowired
    private TodoService todoService;

    @Test
    public void testRegister() {
        TodoDTO todoDTO = TodoDTO.builder()
                .title("title~~")
                .dueDate(LocalDate.now())
                .finished(true)
                .writer("writer~~")
                .build();

        log.info(todoDTO);

        todoService.register(todoDTO);
    }

//    @Test
//    public void testGetTodoList() {
//        todoService.getAll();
//    }
}
