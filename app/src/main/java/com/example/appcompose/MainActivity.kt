package com.example.appcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appcompose.ui.theme.AppComposeTheme
import com.example.appcompose.ui.theme.Typography

// MainActivity é a "porta de entrada" do app no Android
// Ela herda de ComponentActivity, que já é preparada para usar Jetpack Compose
class MainActivity : ComponentActivity() {
    // Função que é chamada quando a Activity é criada (primeiro ciclo de vida da tela)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Ativa suporte para telas modernas (de ponta a ponta, notch etc)
        enableEdgeToEdge()
        // Define o conteúdo da tela usando Compose
        // É aqui que "desenhamos" a interface do usuário
        setContent {
            // Usa o tema definido para o app (cores, tipografia, etc)

            AppComposeTheme {
                // Scaffold é um layout básico do Material Design
                // Ele já traz estrutura pronta: AppBar, FAB, Drawer etc (quando precisar)
                // Aqui usamos apenas como "container"
                Scaffold(modifier = Modifier.fillMaxSize()) // Faz ocupar toda a tela
                { innerPadding ->
                    // Chama nossa função composable "HelloContent"
                    // E aplica o padding interno que o Scaffold fornece
                    HelloContent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


// @Composable marca funções que podem "desenhar" interface usando Compose
// Pense como se fosse um "componente de tela" reutilizável
@Composable
fun HelloContent(modifier: Modifier = Modifier) {
    // Column = layout em coluna (empilha elementos verticalmente)
    // Adicionamos um padding geral de 16dp (espaço nas bordas)
    Column(modifier = modifier.padding(16.dp)) {
        // Criamos uma variável "name" que será observada pelo Compose
        // remember -> salva o estado na memória enquanto a tela existir
        // mutableStateOf("") -> cria um estado que pode mudar e que a tela vai "reagir"
        var name by remember { mutableStateOf("") }
        // Condição: se o usuário já digitou algo (não vazio)
        if (name.isNotBlank()) {
            // Mostra um texto de saudação, pegando a string do arquivo strings.xml
            Text(
                text = stringResource(R.string.hello_name, name), // "Olá, Mateus!"
                modifier = Modifier.padding(bottom = 8.dp), // Espaço embaixo
                style = Typography.bodyMedium // Estilo do texto
            )
        }
        // Campo de texto com borda (Material Design)
        OutlinedTextField(
            value = name, // O que vai aparecer dentro do campo
            onValueChange = { updatedName -> // Toda vez que o usuário digitar algo, atualizamos "name"
            name = updatedName // Isso faz o Compose "recompor" a tela, exibindo a atualização

        }, label = {
                // Rótulo que aparece dentro do campo
            Text(stringResource(R.string.name)) // "Digite seu nome"
        })
    }
}