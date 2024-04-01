package com.todo.todolist.controller.todo;

import com.todo.todolist.domain.TodoVO;
import com.todo.todolist.dto.PageRequestDTO;
import com.todo.todolist.dto.TodoDTO;
import com.todo.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/list")
    public String list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
        log.info("todo list...!!!");

        if (bindingResult.hasErrors()) {
            pageRequestDTO = PageRequestDTO.builder().build();
        }

//        List<TodoDTO> dtoList = todoService.getList();
//        dtoList = dtoList.stream()
//                .sorted(Comparator.comparing(TodoDTO::getDueDate))
//                .collect(Collectors.toList());

        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));

        return "/todo/list";
    }

    @GetMapping("/register")
    public void register() {
        log.info("todo register...!!!");
    }

    @PostMapping("/register")
    public String register(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("todo post register...!!!");

        if (bindingResult.hasErrors()) {
            log.info("has error...!");

            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            return "redirect:/todo/register";
        }

        log.info("todoDTO: " + todoDTO);

        todoService.register(todoDTO);

        return "redirect:/todo/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long tno, PageRequestDTO pageRequestDTO, Model model) {
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);

        model.addAttribute("dto", todoDTO);
    }

    @PostMapping("/remove")
    public String remove(Long tno) {
        log.info("remove...!!!");

        todoService.delete(tno);

        return "redirect:/todo/list";
    }

    @PostMapping("/modify")
    public String modify(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("POST modify...!!!");

        if (bindingResult.hasErrors()) {
            log.info("has error...!");

            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("tno", todoDTO.getTno());

            return "redirect:/todo/modify";
        }

        todoService.modify(todoDTO);

        return "redirect:/todo/list";
    }
}

