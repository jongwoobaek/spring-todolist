package com.todo.todolist.mapper;

import com.todo.todolist.dto.PageRequestDTO;
import com.todo.todolist.domain.TodoVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTest {
    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void testNow() {
        log.info("log.info 테스트임 : :" + todoMapper.getTime());
    }

    @Test
    public void testIInsert() {
        // given
        TodoVO todoVO = TodoVO.builder()
                .title("title")
                .dueDate(LocalDate.of(2024, 3, 14))
                .writer("writer")
                .finished(true)
                .build();

        // when
        todoMapper.insert(todoVO);

        // then

    }

    @Test
    public void testSelectAll() {
        // given
        TodoVO todoVO = TodoVO.builder()
                .title("제목1")
                .dueDate(LocalDate.now())
                .writer("사용자1")
                .build();

        todoMapper.insert(todoVO);

        List<TodoVO> todoVOList = todoMapper.selectAll();
        todoVOList.forEach(log::info);
    }

    @Test
    public void testSelectOne() {
        // given
        TodoVO todoVO = todoMapper.selectOne(1L);

        log.info(todoVO);

        // when
    }

    @Test
    public void testDeleteOne() {
        // given

        // when
        todoMapper.deleteOne(1L);

        Assertions.assertNull(todoMapper.selectOne(1L));
    }

    @Test
    public void testUpdate() {
        // given
    }

    @Test
    public void testSelectList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(2)
                .size(10)
                .build();

        List<TodoVO> todoVOList = todoMapper.selectList(pageRequestDTO);

        todoVOList.forEach(log::info);
    }
}