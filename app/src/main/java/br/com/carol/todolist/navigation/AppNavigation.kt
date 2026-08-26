package br.com.carol.todolist.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.carol.todolist.ui.FormularioTarefaScreen
import br.com.carol.todolist.ui.ListaTarefasScreen
import br.com.carol.todolist.viewmodel.TarefaViewModel

private const val LISTA = "lista"
private const val FORMULARIO = "formulario?id={id}"
@Composable fun AppNavigation(viewModel: TarefaViewModel) {
    val navController = rememberNavController(); val tarefas by viewModel.tarefas.collectAsState()
    NavHost(navController, startDestination = LISTA) {
        composable(LISTA) { ListaTarefasScreen(tarefas, { navController.navigate("formulario?id=0") }, { navController.navigate("formulario?id=$it") }, viewModel::alternarConclusao, viewModel::excluir) }
        composable(FORMULARIO) { entry ->
            val id = entry.arguments?.getString("id")?.toLongOrNull() ?: 0L
            val tarefa = tarefas.firstOrNull { it.id == id }
            FormularioTarefaScreen(tarefa, { viewModel.salvar(it); navController.popBackStack() }, { navController.popBackStack() })
        }
    }
}
