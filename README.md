## Sistema de Vendas

### resumo

O projeto Sistema de Vendas foi desenvolvido como material de apoio para entrevista à programador 
da empresa intersistemas, na área de programador de software. Esse 
documento apresenta a descrição do desenvolvimento do projeto(site).

### IDEs e Softwares usados no desenvolvimento do Projeto

NetBeans IDE 8.2 <br>
MySQL Workbench <br>
XAMPP Control Panel v3.2.4 <br>

### Tecnologia

JSF 2.2 <br>
MySQL >= 5.1.23 <br>
PrimeFaces 5.1 <br>

### Servidor Local

Apache Tomcat ou TomEE

#### Ativar Servidor

Execultado via botão de Execussão do NetBeans

Localhost Gerado: http://localhost:8080/Sistema-Vendas/

OBS: Seu Localhost pode ser diferente, caso esteja usando o Netbeans e tenha selecionado um browser (Microsoft Edge, Google Chrome, etc) o site será aberto automaticamnte, fornecendo assim o localhost.

### Cmder

CMDER nada mais é do que um “terminal” para o Windows, com essa ferramenta é possível rodar comandos UNIX (ls, rm, mv e etc) diretamente no Windows, e isso torna o trabalho no sistema operacional da Microsoft mais agradável (EspecializaTI, 2017).
No projeto foi utilizado para enviar o projeto para Github.

### Banco de Dados

Criei o *schema* sistema-vendas no MySQL Workbench e depois a tabela com o seguinte script sql:

<pre>
create table cliente (                                    
    id integer primary key auto_increment not null,      
    nome varchar(255) not null,                           
    email varchar(255) not null,                          
    senha varchar(255) not null,                          
    telefone varchar(255) not null,                      
    endereco varchar(255) not null                        
)                                                         
</pre>

No projeto o pacote *br.edu.ufrn.clientes.dao* possui todas as classes responsáveis por fazer a interface de conexão entre banco de dados e aplicação web.

## Descrição da Aplicação

### Página Inicial

Para acessar a página inicial é só digitar o Localhost no Browser (Microsoft Edge, Google Chrome, etc), como especificado no
item *Ativar Servidor*. Daí abrirá, teoricamente, uma página de boas vindas ao cliente. Para se cadastrar o cliente deve clicar no link *Gerenciar Clientes* disíponível no Menu. 
Em *Gerenciar Clientes* o usuário tem acesso a um CRUD básico.

OBS: Aplicação ainda em desenvolvimento.