package com.todo.todolist.service;

import com.todo.todolist.domain.TodoVO;
import com.todo.todolist.dto.PageRequestDTO;
import com.todo.todolist.dto.PageResponseDTO;
import com.todo.todolist.dto.TodoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TodoService {
    void register(TodoDTO todoDTO);

    //    List<TodoDTO> getAll();
    TodoDTO getOne(Long tno);

    void delete(Long tno);

    void modify(TodoDTO todoDTO);

    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);
}
