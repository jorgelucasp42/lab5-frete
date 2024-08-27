## Projeto de Sistema de Frete

### Descrição
Trabalho realizado por Jorge Silva e Rafael Simas para obtenção de nota na Disciplina de Laboratório de Banco de Dados. 

### Requisitos

- Java 18
- MySQL 8.0 ou superior
- IDE de sua preferência (recomendado: IntelliJ IDEA)

### Configuração do Banco de Dados

Antes de executar o projeto, certifique-se de configurar corretamente as credenciais de acesso ao banco de dados MySQL. As configurações padrão estão localizadas no arquivo `persistence.xml`. Altere as configurações conforme necessário:

```xml
<persistence-unit name="lab_jpa">
    <properties>
        <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/lab_jpa?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&createDatabaseIfNotExist=true"/>
        <property name="javax.persistence.jdbc.user" value="seu_usuario"/>
        <property name="javax.persistence.jdbc.password" value="sua_senha"/>
        <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
        <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect"/>
        <property name="hibernate.hbm2ddl.auto" value="update"/>
    </properties>
</persistence-unit>
```
