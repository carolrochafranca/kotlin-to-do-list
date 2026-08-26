package br.com.carol.todolist

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.carol.todolist.data.Tarefa
import br.com.carol.todolist.data.TarefaDatabase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TarefaDaoContratoTest {
    @Test fun `DAO insere e expõe tarefas observáveis`() = runBlocking {
        val banco = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), TarefaDatabase::class.java).build()
        banco.tarefaDao().inserir(Tarefa(titulo = "Tarefa de teste"))
        val tarefas = banco.tarefaDao().observarTodas().first()
        assertEquals("Tarefa de teste", tarefas.single().titulo)
        banco.close()
    }
}
