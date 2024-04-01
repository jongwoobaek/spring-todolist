package com.todo.todolist.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    private Long tno;

    @NotEmpty
    private String title;

    @FutureOrPresent
    private LocalDate dueDate;

    private boolean finished;

    @NotBlank
    private String writer;
}
