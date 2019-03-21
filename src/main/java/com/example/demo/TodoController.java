package com.example.demo;

import com.example.demo.models.Todo;
import com.example.demo.models.User;
import com.example.demo.repository.TodoRepository;
import com.example.demo.repository.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Todos Controller", description = "Todos Controller")
@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class TodoController {
    @Autowired
    UserRepository userrepos;

    @Autowired
    TodoRepository todorepos;

    // GET /users - returns all users
    @GetMapping("/users")
    public List<User> findUsers() {
        return userrepos.findAll();
    }

    // GET /todos - return all the todos
    @GetMapping("/todos")
    public List<Todo> findTodos() {
        return todorepos.findAll();
    }

    // GET /user/userid/{userid} - return the user based off of the user id
    @GetMapping("/users/userid/{userid}")
    public User findUserById(@PathVariable long userid) {
        var foundUser = userrepos.findById(userid);
        if (foundUser.isPresent()) {
            return foundUser.get();
        }
        return null;
    }

    // GET /users/username/{username} - return the user based off of the username
    @GetMapping("/users/username/{username}")
    public User findUserByName(@PathVariable String username) {
        return userrepos.findByUsername(username);
    }

    // GET /todos/todois/{todois} - return the todo based off of the todo id.
    @GetMapping("/todos/todoid/{todoid}")
    public Todo findTodoById(@PathVariable long todoid) {
        var foundTodo = todorepos.findById(todoid);
        if (foundTodo.isPresent()) {
            return foundTodo.get();
        }
        return null;
    }

    // GET /todos/users - return a listing of the todos with its assigned user's name
    @GetMapping("/todos/users")
    public
}
