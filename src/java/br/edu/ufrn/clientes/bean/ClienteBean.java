package br.edu.ufrn.clientes.bean;

import br.edu.ufrn.clientes.bean.exception.ErroSistema;
import br.edu.ufrn.clientes.dao.ClienteDAO;
import br.edu.ufrn.clientes.entidade.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class ClienteBean {
    
    private Cliente cliente = new Cliente(); 
    private List<Cliente> cli = new ArrayList<Cliente>();
    private ClienteDAO clienteDAO = new ClienteDAO();
    
    public void adicionar(){
        try {
            //cli.add(cliente);
            clienteDAO.salvar(cliente);
            cliente = new Cliente();
            adicionarMensagem("Salvo!", "Cliente Salvo com Sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    
    public void listar(){
        try {
            cli = clienteDAO.buscar();
            if (cli == null || cli.size() == 0){
                adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhum cliente!", FacesMessage.SEVERITY_WARN);
            } 
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    
    public void deletar(Cliente c){
        try {
            clienteDAO.deletar(c.getId());
            adicionarMensagem("Deletado!", "Cliente deletado com Sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    
    public void editar(Cliente c){
        cliente = c;
    } 
    
    public void adicionarMensagem(String sumario, String detalhe, FacesMessage.Severity tipoErro){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(tipoErro, sumario, detalhe);
        context.addMessage(null, message);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getCli() {
        return cli;
    }

    public void setCli(List<Cliente> cli) {
        this.cli = cli;
    }
}
