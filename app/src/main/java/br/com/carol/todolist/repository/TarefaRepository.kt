package br.com.carol.todolist.repository

import br.com.carol.todolist.data.Tarefa
import br.com.carol.todolist.data.TarefaDao
import kotlinx.coroutines.flow.Flow

class TarefaRepository(private val dao: TarefaDao) {
    val tarefas: Flow<List<Tarefa>> = dao.observarTodas()
    fun observar(id: Long): Flow<Tarefa?> = dao.observarPorId(id)
    suspend fun salvar(tarefa: Tarefa) { if (tarefa.id == 0L) dao.inserir(tarefa) else dao.atualizar(tarefa) }
    suspend fun excluir(tarefa: Tarefa) = dao.excluir(tarefa)
}
