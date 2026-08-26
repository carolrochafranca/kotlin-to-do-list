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
4. Execute o módulo `app`.

## Evidências

As imagens de execução devem ser armazenadas em `docs/evidencias`. Consulte o [roteiro de capturas](docs/evidencias/README.md) antes de enviar a atividade.
