# Sistema Gestor de Tarefas ESIG

## Descrição

Este é um sistema de gestão de tarefas desenvolvido em Java utilizando JSF (JavaServer Faces) como framework web, com persistência de dados e estrutura orientada a entidades. O sistema implementa as principais operações de um CRUD de tarefas, além de funcionalidades de filtro e atribuição de responsáveis.

## Funcionalidades Implementadas

- **Cadastro de tarefas**: Permite criar novas tarefas com título, descrição, responsável, prioridade, status e deadline.
- **Listagem de tarefas**: Exibe todas as tarefas cadastradas, com filtros por número, título/descrição e responsável.
- **Edição de tarefas**: Edita dados de uma tarefa existente.
- **Conclusão de tarefas**: Permite marcar uma tarefa como concluída.
- **Remoção de tarefas**: Exclui tarefas do sistema.
- **Atribuição de responsável**: Cada tarefa pode ter um usuário responsável.
- **Priorização**: Suporte a níveis de prioridade (baixa, média, alta).
- **Status**: Suporte a múltiplos status para tarefas (em andamento, concluído, etc).
- **Filtro/pesquisa**: Filtros por número, título/descrição, responsável e status.

> **Itens implementados**: a), b), c), d), e), f), g), h).

## Instruções de Execução em Ambiente Local

### Pré-requisitos

- Java JDK 8 ou superior
- Maven 3.x
- Um servidor de aplicação compatível com JSF, como Apache Tomcat 9+
- Banco de dados relacional (PostgreSQL, H2, MySQL ou outro, conforme configuração)
- **Para configuração do Apache Tomcat**, confira este vídeo: [Como configurar o Apache Tomcat](https://www.youtube.com/watch?v=kW1v_tvZC3Q)

### Passos para execução

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/heitorpita/sistema-gestor-de-tarefas-esig.git
   cd sistema-gestor-de-tarefas-esig
   ```

2. **Configure o banco de dados:**
    - Por padrão, o projeto pode estar configurado para H2/MySQL. Para utilizar o **PostgreSQL**, edite o arquivo `src/main/resources/META-INF/persistence.xml` conforme o exemplo abaixo.

#### Exemplo de configuração do PostgreSQL no `persistence.xml`:

```xml
<persistence-unit name="default">
  <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
  <class>projetoESIGJAVA.entities.Tarefa</class>
  <class>projetoESIGJAVA.entities.User</class>
  <properties>
    <property name="javax.persistence.jdbc.driver" value="org.postgresql.Driver"/>
    <property name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/nome_do_banco"/>
    <property name="javax.persistence.jdbc.user" value="seu_usuario"/>
    <property name="javax.persistence.jdbc.password" value="sua_senha"/>
    <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect"/>
    <property name="hibernate.hbm2ddl.auto" value="update"/>
    <property name="hibernate.show_sql" value="true"/>
  </properties>
</persistence-unit>
```

- Certifique-se de criar o banco de dados (`nome_do_banco`) no PostgreSQL antes de rodar o sistema.
- Altere `seu_usuario` e `sua_senha` para as credenciais corretas do seu ambiente.

3. **Compile o projeto:**
   ```bash
   mvn clean package
   ```

4. **Implante o arquivo WAR gerado em seu servidor de aplicação:**
    - O arquivo `.war` estará na pasta `target/`.
    - Copie para o diretório de deploy do Tomcat ou configure via painel de administração.

5. **Acesse o sistema:**
    - Abra o navegador em: `http://localhost:8080/sistema-gestor-de-tarefas-esig/`
    - A interface estará disponível para cadastro, consulta, edição e remoção de tarefas.

## Estrutura de Pastas

- `src/main/java/projetoESIGJAVA/bean/` — Beans JSF (controladores)
- `src/main/java/projetoESIGJAVA/entities/` — Entidades JPA (modelos)
- `src/main/java/projetoESIGJAVA/services/` — Serviços (regras de negócio)
- `src/main/java/projetoESIGJAVA/dto/` — Objetos auxiliares para formulários
- `src/main/webapp/` — Arquivos de interface (xhtml)
- `pom.xml` — Gerenciamento de dependências Maven

## Observações

- O projeto pode ser adaptado para outros servidores ou bancos relacionais, bastando ajustar o `persistence.xml`.
- Para dúvidas sobre configuração ou execução, consulte os arquivos de configuração ou abra uma issue no repositório.

---
Desenvolvido por Heitor Pita.