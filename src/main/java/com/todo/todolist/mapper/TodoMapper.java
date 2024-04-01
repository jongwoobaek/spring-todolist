package com.todo.todolist.mapper;

import com.todo.todolist.dto.PageRequestDTO;
import com.todo.todolist.domain.TodoVO;

import java.util.List;

public interface TodoMapper {
    String getTime();
    void insert(TodoVO todoVO);
    List<TodoVO> selectAll();
    TodoVO selectOne(Long tno);
    void deleteOne(Long tno);
    void update(TodoVO todoVo);
    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);
    int getPageCount(PageRequestDTO pageRequestDTO);
}
