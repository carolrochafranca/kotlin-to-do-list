package br.com.carol.todolist.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.carol.todolist.data.Tarefa

@Composable
fun ListaTarefasScreen(tarefas: List<Tarefa>, aoCriar: () -> Unit, aoEditar: (Long) -> Unit, aoAlternar: (Tarefa) -> Unit, aoExcluir: (Tarefa) -> Unit) {
    Scaffold(floatingActionButton = { FloatingActionButton(onClick = aoCriar) { Text("+") } }) { padding ->
        if (tarefas.isEmpty()) Box(Modifier.fillMaxSize().padding(padding), contentAlignment = androidx.compose.ui.Alignment.Center) { Text("Nenhuma tarefa cadastrada") }
        else LazyColumn(Modifier.padding(padding).fillMaxSize(), contentPadding = PaddingValues(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(tarefas, key = { it.id }) { tarefa -> TarefaItem(tarefa, { aoAlternar(tarefa) }, { aoEditar(tarefa.id) }, { aoExcluir(tarefa) }) }
        }
    }
}
@Composable private fun TarefaItem(tarefa: Tarefa, alternar: () -> Unit, editar: () -> Unit, excluir: () -> Unit) {
    Card { Row(Modifier.fillMaxWidth().padding(12.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Checkbox(tarefa.concluida, alternar); Column(Modifier.weight(1f)) { Text(tarefa.titulo, textDecoration = if (tarefa.concluida) TextDecoration.LineThrough else null); if (tarefa.descricao.isNotBlank()) Text(tarefa.descricao) }
        TextButton(editar) { Text("Editar") }; TextButton(excluir) { Text("Excluir") }
    }}
}
@Preview @Composable private fun ListaPreview() { MaterialTheme { ListaTarefasScreen(listOf(Tarefa(1,"Estudar Compose")), {}, {}, {}, {}) } }
