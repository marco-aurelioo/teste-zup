# Teste ZUP
Projeto para teste zup.

#### Passos do teste:
- [x] Criar uma app spring boot.
- [x] Criar entrypoint "transaction" com os verbos GET e POST.
- [x] No metodo POST guardar modelo de trasaction.
- [x] Criar validação do modelo transaction para conter todos os dados de transaction.
- [x] No metodo GET devolver todas transações ocorridas no ultimo minuto. 
- [x] Persistir transações (Não pode ser um banco de dados). 
- [x] Consulta de todas transações do ultimo minuto.
- [x] Revisar estrutura de armazenamento de transactions.
- [x] Definir modelo de escalonamento horizontal da aplicação.
    * Não ha forma de escalonamento se não houver ao menos um banco de dados em memória para centralizar a listagem de transações.
- [x] Criar mecanismo para garantir expurgo de informações não utilizadas na API.

#### Como executar no docker
No diretorio raiz da aplicação

Gerar jar file
* mvn clean package

Criar imagem docker 
* docker build -t tiozao/demozup .

Executar imagem (Serviço exposto na porta padrão 8080).
* docker run -d -p 8080:8080 --name demozup tiozao/demozup



