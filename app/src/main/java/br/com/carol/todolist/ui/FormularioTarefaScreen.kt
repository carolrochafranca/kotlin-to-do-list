package br.com.carol.todolist.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.carol.todolist.data.Tarefa

@Composable
fun FormularioTarefaScreen(tarefa: Tarefa?, aoSalvar: (Tarefa) -> Unit, aoVoltar: () -> Unit) {
    var titulo by rememberSaveable(tarefa?.id) { mutableStateOf(tarefa?.titulo.orEmpty()) }
    var descricao by rememberSaveable(tarefa?.id) { mutableStateOf(tarefa?.descricao.orEmpty()) }
    Scaffold(topBar = { TopAppBar(title = { Text(if (tarefa == null) "Nova tarefa" else "Editar tarefa") }, navigationIcon = { TextButton(aoVoltar) { Text("Voltar") } }) }) { padding ->
        Column(Modifier.padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            OutlinedTextField(titulo, { titulo = it }, Modifier.fillMaxWidth(), label = { Text("Título") }, isError = titulo.isBlank())
            OutlinedTextField(descricao, { descricao = it }, Modifier.fillMaxWidth(), label = { Text("Descrição") }, minLines = 3)
            Button(onClick = { aoSalvar(Tarefa(tarefa?.id ?: 0, titulo.trim(), descricao.trim(), tarefa?.concluida ?: false)) }, enabled = titulo.isNotBlank()) { Text("Salvar") }
        }
    }
}
@Preview @Composable private fun FormularioPreview() { MaterialTheme { FormularioTarefaScreen(Tarefa(1,"Comprar café"), {}, {}) } }
