package services;

import model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel registrarUsuario(UserModel usuario) {
        return userRepository.save(usuario);
    }

    @Override
    public UserModel obtenerUsuarioPorId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserModel actualizarUsuario(Long id, UserModel usuario) {
        UserModel usuarioExistente = userRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setNombreUsuario(usuario.getNombreUsuario());
            usuarioExistente.setCorreoElectronico(usuario.getCorreoElectronico());
            // Continúa con otros campos según sea necesario
            return userRepository.save(usuarioExistente);
        }
        return null; // Retorna null si no se encuentra el usuario con el ID proporcionado
    }

    @Override
    public void eliminarUsuario(Long id) {
        userRepository.deleteById(id);
    }
}
