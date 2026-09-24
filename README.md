# Kotlin To-Do List

Aplicativo Android de tarefas desenvolvido para exercitar a camada de apresentação de uma aplicação com persistência local. Ele permite cadastrar, editar, concluir, excluir e navegar entre a lista e o formulário de tarefas.

## Tecnologias

- Kotlin e Coroutines/Flow
- Jetpack Compose e Material 3
- Room (SQLite)
- ViewModel
- Navigation Compose

## Arquitetura

O projeto usa uma separação simples inspirada em MVVM:

- `data`: contém `Tarefa`, `TarefaDao` e `TarefaDatabase`. O DAO concentra as consultas e alterações no Room.
- `repository/TarefaRepository`: é a fronteira de acesso aos dados. A ViewModel não conhece detalhes do DAO; recebe do repositório o `Flow` da lista, observa uma tarefa por ID e delega salvar/excluir.
- `viewmodel/TarefaViewModel`: transforma o `Flow<List<Tarefa>>` em `StateFlow`, preservando um estado observável para a UI. Também expõe as ações de salvar, excluir e alternar a conclusão usando `viewModelScope`.
- `ui/ListaTarefasScreen`: recebe o estado e callbacks. Ela desenha as tarefas em `LazyColumn`, dispara os callbacks de concluir, editar e excluir, e oferece o botão de nova tarefa. Há um preview com dados estáticos.
- `ui/FormularioTarefaScreen`: recebe uma tarefa opcional. Quando ela é nula, cria uma tarefa; quando existe, inicializa os campos com seus dados e preserva o ID e a conclusão ao salvar. Também possui preview.
- `navigation/AppNavigation`: usa as rotas `lista` e `formulario?id={id}`. O ID `0` indica cadastro; qualquer ID existente abre a edição.
- `MainActivity`: cria o banco Room, o repositório e a `TarefaViewModelFactory`, obtém a ViewModel dentro do Compose e inicia `AppNavigation`.

## Executar

1. Abra a pasta do projeto no Android Studio.
2. Aguarde a sincronização do Gradle e instale os componentes do Android SDK sugeridos pela IDE, caso solicitado.
3. Escolha um emulador ou dispositivo com Android 7.0 (API 24) ou superior.
4. Execute o módulo `app`.~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

## Evidências

![Lista inicial](docs/evidencias/1%20-Tela-inicial-com-a-lista-de-tarefas-em-execução.png)

![Formulário de cadastro](docs/evidencias/2%20-%20Cadastro%20de%20uma%20nova%20tarefa.png)

![Tarefa cadastrada](docs/evidencias/3%20-%20Tarefa%20cadastrada%20aparecendo%20na%20lista.png)

![Edição de tarefa](docs/evidencias/4%20-%20Edição%20de%20uma%20tarefa%20existente.png)

![Tarefa concluída](docs/evidencias/5%20-%20Tarefa%20marcada%20como%20concluída.png)

![Navegação](docs/evidencias/7%20-%20Navegação%20entre%20a%20lista%20e%20o%20formulário.png)

![Build executado com sucesso](docs/evidencias/8%20-%20Build%20ou%20execução%20do%20projeto%20sem%20erros.png)

<img width="375" height="854" alt="WhatsApp Image 2026-09-23 at 22 15 00" src="https://github.com/user-attachments/assets/4b96ff97-38b6-4f5f-8af2-7c2a5ca99b0d" />

<img width="384" height="852" alt="WhatsApp Image 2026-09-23 at 22 15 16" src="https://github.com/user-attachments/assets/839ff0c5-4e0c-4682-b805-637d17aa0d82" />

<img width="381" height="855" alt="WhatsApp Image 2026-09-23 at 22 15 29" src="https://github.com/user-attachments/assets/59ae49c1-d5c8-43f3-8737-758f89e559fc" />
