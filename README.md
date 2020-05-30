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
    * Alterando o requisito e utilizando um banco em memoria (Redis).
- [x] Criar mecanismo para garantir expurgo de informações não utilizadas na API.

#### Como executar no docker
No diretorio raiz da aplicação

Gerar jar file
* mvn clean package

Criar imagem docker 
* docker build -t tiozao/demozup .

Executar imagem (Serviço exposto na porta padrão 8080).
* docker run -d -p 8080:8080 --name demozup tiozao/demozup

### Branch Redis

Para conseguir escalar horizontalmente a solução posso criar um banco para unificar os registros de transações.
Escolhi o redis por ser um IMDB (in memory data base), posso configurar um ttl para os registros e me beneficiar delegando resposnabilidade de expurgo da informação para o banco.
Para isso terei que adaptar a aplicação:

-[x] Criar uma instancia redis.
-[x] Incluir um client redis na aplicação.
-[x] Alterar o fluxo de inserção de transações.
-[x] Alterar o fluxo de leitura.

Para rodar a instancia redis:

Baixar a imagem redis padrão
* docker pull redis

Subir um docker com o redis 
* docker run -dit -p 7001:6379 --name redis-container redis





