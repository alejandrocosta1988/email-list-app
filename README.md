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

A construção do pool de conexões foi um desafio que começou com a criação de um arquivo context.xml. Esse arquivo foi armazenado no diretório META-INF da aplicação web. Dentro do arquivo context.xml, vários detalhes de configuração foram realizados. A começar por todas as informações associadas ao banco de dados, como url, usuário e senha, além de nome do driver e nome do banco de dados.
Além das informações diretamente associadas ao banco de dados, também foram ajustadas configurações associadas ao pool de conexões. Por exemplo, número máximo de conexões ativas, remoção de conexões abandonadas (conexões cujos resultados ou declarações, por exemplo, não foram fechados), tempo necessário para realizar a remoção de uma conexão abandonada, dentre vários outros parâmetros.
Após criação do context.xml, foi necessário a criação de uma classe para definir o pool de conexões propriamente dito (`ConnectionPool`). Essa classe foi criada seguindo um padrão Singleton, o que significa que uma única instância dela será criada e sempre será retornada.
A partir da classe `ConnectionPool`, se torna possível retirar uma conexão do pool, utiizá-la e, depois, devolvê-la para o pool de conexões. 