package controller;

import model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.UserService;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserModel registrarUsuario(@RequestBody UserModel usuario) {
        return userService.registrarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public UserModel obtenerUsuarioPorId(@PathVariable Long id) {
        return userService.obtenerUsuarioPorId(id);
    }

    @PutMapping("/{id}")
    public UserModel actualizarUsuario(@PathVariable Long id, @RequestBody UserModel usuario) {
        return userService.actualizarUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        userService.eliminarUsuario(id);
    }
}
