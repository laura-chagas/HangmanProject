# Jogo da Forca Java

Um simples jogo da forca em Java desenvolvido pelo grupo Ana Julia Alves, Laura Xavier e Ana Clara Tomé.

## Classes

### Class PlayerClass

A classe `PlayerClass` é usada para representar informações sobre um jogador, incluindo seu nome e pontuação. Os métodos getter e setter são fornecidos para acessar e modificar essas informações.

### Class WordClass

Essa classe é usada para encapsular uma única palavra. Ela fornece métodos para acessar e modificar essa palavra.

### Class HangmanGame

Esta classe implementa a lógica de um jogo da forca. Ela permite que um jogador insira letras e tente adivinhar uma palavra específica. A cada letra correta adivinhada, a pontuação do jogador aumenta e a exibição da palavra é atualizada para mostrar as letras corretas.

### Word Generator Service

A classe `WordGeneratorService` se conecta a uma API que fornece palavras aleatórias e encapsula esse processo. Ela lida com as operações de conexão, leitura de respostas e conversão de JSON para uma instância da classe `WordClass`.

### Login Service e Register Service

Essas classes são responsáveis por fazer o login e registro dos usuários.

### Infra DAO

Essa classe é responsável por encapsular a interação com o banco de dados para operações relacionadas aos jogadores, como adicionar jogadores, autenticar jogadores e atualizar pontuações. Ela utiliza o JPA para simplificar a interação com o banco de dados e lida com a gestão de transações, garantindo a consistência dos dados.

### Repository PlayerRepository

Essa classe faz parte da camada de acesso a dados (Repository) e age como um intermediário entre a camada de domínio (Domain) e a infraestrutura (Infra). Ela utiliza o objeto DAO para realizar operações de persistência e recuperação de dados relacionados aos jogadores no banco de dados. Essa abordagem ajuda a manter uma separação clara entre as diferentes camadas da aplicação.

### Service Main

Essa classe é a principal responsável por orquestrar a interação do usuário com o jogo da forca. Ela permite que os jogadores registrem-se, façam login, joguem e verifiquem suas pontuações. O loop contínuo garante que o jogador possa executar essas ações repetidamente até que decida sair do programa.
