package br.com.carol.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import br.com.carol.todolist.data.TarefaDatabase
import br.com.carol.todolist.navigation.AppNavigation
import br.com.carol.todolist.repository.TarefaRepository
import br.com.carol.todolist.viewmodel.TarefaViewModel
import br.com.carol.todolist.viewmodel.TarefaViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)
        val database = Room.databaseBuilder(applicationContext, TarefaDatabase::class.java, "tarefas.db").build()
        val factory = TarefaViewModelFactory(TarefaRepository(database.tarefaDao()))
        setContent { val viewModel: TarefaViewModel = viewModel(factory = factory); AppNavigation(viewModel) }
    }
}
