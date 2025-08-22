package com.example.appcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.appcompose.ui.theme.AppComposeTheme
import com.example.appcompose.ui.theme.component.HelloContent

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

