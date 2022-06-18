package com.argentinaPrograma.PortFolio.Service;

import com.argentinaPrograma.PortFolio.Model.Rol;
import com.argentinaPrograma.PortFolio.Model.Usuario;
import com.argentinaPrograma.PortFolio.Repository.RolRepository;
import com.argentinaPrograma.PortFolio.Repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UsuarioService implements UsuarioServiceInterface, UserDetailsService {

    private final UsuarioRepository userRepo;
    private final RolRepository rolRepo;
    private final PasswordEncoder passEnc;

    @Override
    public Usuario guardarUsuario(Usuario user) {
        user.setPassword(passEnc.encode(user.getPassword()));
        return userRepo.save(user); 
    }

    @Override
    public Rol guardarRol(Rol rol) {
        return rolRepo.save(rol);
    }

    @Override
    public void rolAUsuario(String username, String rolname) {
        Usuario user = userRepo.findByUsername(username);
        Rol rol = rolRepo.findByNombre(rolname);
        user.getRoles().add(rol);
    }

    @Override
    public Usuario getUsuario(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<Usuario> getUsuarios() {
        return userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Usuario user = userRepo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("El usuario no se encontró en la base de datos");
        }
        
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(rol -> 
                authorities.add(new SimpleGrantedAuthority(rol.getNombre()))
        );
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
