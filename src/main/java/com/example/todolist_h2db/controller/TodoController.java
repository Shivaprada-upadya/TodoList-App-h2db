package com.example.todolist_h2db.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todolist_h2db.model.Todo;
import com.example.todolist_h2db.repository.TodoRepository;

@Controller
//@RequestMapping("/api/")
public class TodoController {

	private final TodoRepository todoRepository;
	
	public TodoController(TodoRepository todoRepository)
	{
		this.todoRepository=todoRepository;
	}
	
	@GetMapping("/")
	public String index(Model model)
	{
		model.addAttribute("todos",todoRepository.findAll());
		return "index";
	}
	
	@GetMapping("/add")
	public String addForm(Model model)
	{
		model.addAttribute("todo",new Todo());
		return "add";
	}
	
	 // Save new todo
    @PostMapping("/add")
    public String addTodo(@ModelAttribute Todo todo) {
        todoRepository.save(todo);
        return "redirect:/";
    }
	
	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable Long id, Model model)
	{
		Todo todo = todoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid ID"));
		model.addAttribute("todo",todo);
		return "edit";
	}
	
	@PostMapping("edit/{id}")
	public String updateTodo(@PathVariable Long id,@ModelAttribute Todo todo)
	{
		Todo existingTodo = todoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid ID"));
		existingTodo.setTitle(todo.getTitle());
		existingTodo.setCompleted(todo.isCompleted());
		todoRepository.save(existingTodo);
		return "redirect:/";
	}
	
	@GetMapping("delete/{id}")
	public String deleteTodo(@PathVariable Long id) {
		todoRepository.deleteById(id);
		return "redirect:/";
	}
	
	@PostMapping("/toggle/{id}")
	public String toggleCompleted(@PathVariable Long id)
	{
		Todo todo =todoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Inalid ID"));		
		
		todo.setCompleted(!todo.isCompleted());
		
		todoRepository.save(todo);
		return "redirect:/";
	}
	
	
}
