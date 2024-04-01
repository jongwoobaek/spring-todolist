package com.todo.todolist.domain;

import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class TodoVO {
    private int tno;
    private String title;
    private LocalDate dueDate;
    private String writer;
    private boolean finished;
}
