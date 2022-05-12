# Email List App

Essa aplicação permite a um usuário salvar um determinado e-mail em uma lista de e-mails registrados. Além disso, será possível consultar todos os e-mails registrados, realizar atualizações e remover e-mails.

### Objetivos

O principal objetivo do desenvolvimento dessa aplicação é praticar conhecimentos/técnicas associados com o desenvolvimento web utilizando JavaServer Pages (JSP) e Servlets, além da conexão da aplicação com um banco de dados MySQL.
A utilização de um pool de conexões (ou connection pooling) foi um dos objetivos principais da construção dessa aplicação.

### Pontos trabalhados durante o desenvolvimento

- Desenvolvimento backend utilizando JSP e Servlets;
- Utilização de EL (Expression Language);
- Arquitetura MVC;
- Conexão com banco de dados MySQL utilizando driver Connector/J;
- Conexão com banco de dados utilizando connection pooling;
- Testes unitários com JUnit;

### Construindo um pool de conexões

Para construção do pool de conexões foi necessário adicionar as seguintes dependências:
`commons-dbcp2-2.9.0.jar`
`commons-pool2-2.11.0.jar`
`commons-logging-1.2.jar`

O pool foi criado a partir de uma classe nomeada `ConnectionPool`.

A construção do pool de conexões foi um desafio considerável. Foram necessárias várias tentativas diferentes para conseguir implementar. O aprendizado foi gratificante.

#### `ConnectionPool`
A classe utiliza um padrão Singleton para retornar sempre o mesmo pool de conexões.
A definição do pool de conexões utilizou um `BasicDataSource`, que foi configurado para conter inicialmente 10 conexões, um número máximo de 100 conexões, um número máximo de 30 conexões ociosas, uma espera máxima de conexões pelo pool de 10 segundos, a remoção de conexões abandonadas que foram retiradas do pool para uso, bem como remoção de conexões abandonadas durante manutenção do pool e um tempo limite para remoção de conexões abandonadas de 60 segundos.
`ConnectionPool` oferece um método público para se retirar uma conexão do pool e utilizar, bem como um método público para fechar essa conexão e, assim, retorná-la para o pool de conexões.
