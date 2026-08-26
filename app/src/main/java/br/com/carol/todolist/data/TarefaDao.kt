package br.com.carol.todolist.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TarefaDao {
    @Query("SELECT * FROM tarefas ORDER BY concluida, id DESC") fun observarTodas(): Flow<List<Tarefa>>
    @Query("SELECT * FROM tarefas WHERE id = :id") fun observarPorId(id: Long): Flow<Tarefa?>
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun inserir(tarefa: Tarefa)
    @Update suspend fun atualizar(tarefa: Tarefa)
    @Delete suspend fun excluir(tarefa: Tarefa)
}
