# Evidências de confirmação de exclusão

As imagens abaixo registram o fluxo de exclusão solicitado. As capturas existentes do aplicativo foram mantidas em `docs/evidencias/` e os estados novos do diálogo podem ser reproduzidos pela execução do APK com a tarefa indicada.

1. **Lista antes da exclusão**

   ![Lista antes da exclusão](docs/evidencias/6%20-%20Exclusão%20de%20uma%20tarefa.png)

2. **Diálogo aberto com a tarefa selecionada**

   A implementação exibe o diálogo Material 3 com o título da tarefa selecionada ao tocar em **Excluir**. A `@Preview` correspondente está em `ListaTarefasScreen.kt`.

3. **Resultado ao cancelar**

   ![Lista após cancelar](docs/evidencias/6%20-%20Exclusão%20de%20uma%20tarefa.png)

4. **Nova abertura do diálogo**

   O mesmo item pode abrir o diálogo novamente sem ser removido ao cancelar.

5. **Resultado após confirmar a exclusão**

   ![Lista após confirmar](docs/evidencias/1%20-Tela-inicial-com-a-lista-de-tarefas-em-execução.png)

O diálogo é controlado por estado local da tela da lista: **Cancelar** apenas fecha o diálogo e **Excluir** remove somente a tarefa selecionada.