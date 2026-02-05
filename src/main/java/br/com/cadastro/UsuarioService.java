package br.com.cadastro;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();
    private int proximoId = 1;

    public void cadastrarUsuario(String nome, String email) {
        Usuario usuario = new Usuario(proximoId, nome, email);
        usuarios.add(usuario);
        proximoId++;
        System.out.println("Usuário cadastrado com sucesso");
    }
    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuario cadastrado.");
            return;
        }
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }
    public Usuario buscarPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }
    public void atualizarUsuario(int id, String novoNome, String novoEmail) {
        Usuario usuario = buscarPorId(id);

        if (usuario == null) {
            System.out.println("Usuario não encontrado");
            return;
        }
        usuario.setNome(novoNome);
        usuario.setEmail(novoEmail);
        System.out.println("Usuario atualizado com sucesso");
    }
    public void removerUsuario(int id) {
        Usuario usuario = buscarPorId(id);

        if (usuario == null) {
            System.out.println("Usuario não encontrado");
            return;
        }
        usuarios.remove(usuario);
        System.out.println("Usuario removido com sucesso");
    }
}
