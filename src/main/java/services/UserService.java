package services;

import model.UserModel;

public interface UserService {
    UserModel registrarUsuario(UserModel usuario);
    UserModel obtenerUsuarioPorId(Long id);
    UserModel actualizarUsuario(Long id, UserModel usuario);
    void eliminarUsuario(Long id);
}
