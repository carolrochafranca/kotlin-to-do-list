package br.com.carol.todolist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import br.com.carol.todolist.data.Tarefa
import br.com.carol.todolist.repository.TarefaRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TarefaViewModel(private val repository: TarefaRepository) : ViewModel() {
    val tarefas: StateFlow<List<Tarefa>> = repository.tarefas.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
    fun tarefa(id: Long) = repository.observar(id)
    fun salvar(tarefa: Tarefa) = viewModelScope.launch { repository.salvar(tarefa) }
    fun excluir(tarefa: Tarefa) = viewModelScope.launch { repository.excluir(tarefa) }
    fun alternarConclusao(tarefa: Tarefa) = salvar(tarefa.copy(concluida = !tarefa.concluida))
}

class TarefaViewModelFactory(private val repository: TarefaRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST") override fun <T : ViewModel> create(modelClass: Class<T>): T = TarefaViewModel(repository) as T
}
