package com.example.appcompose.ui.theme.component.ExampleModifier

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.appcompose.ui.theme.AppComposeTheme

@OptIn(ExperimentalFoundationApi::class) // Necessário pois combinedClickable ainda é experimental
@Composable
fun InteractionProperties(modifier: Modifier = Modifier) {
    // LocalContext → usado para acessar recursos do Android, como Toast
    val context = LocalContext.current
    // Column → organiza os elementos em coluna
    // Espaçamento de 16.dp entre cada item
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {

        // 📌 Exemplo 1: Clique simples
        // .clickable → adiciona comportamento de clique
        // Aqui mostramos um Toast "Clicou!" quando o usuário toca

        Box(
            modifier = Modifier
                .size(width = 300.dp, height = 100.dp)
                .background(Color.Green)
                .clickable {
                    Toast.makeText(context, "Clicou!", Toast.LENGTH_SHORT).show()
                }

        )
        // 📌 Exemplo 2: Clique combinado
        // .combinedClickable → permite capturar diferentes tipos de clique
        // - Clique simples
        // - Clique longo
        // - Clique duplo
        // Útil para interações mais ricas (menus, atalhos etc.)
        Box(
            modifier = Modifier
                .size(width = 300.dp, height = 100.dp)
                .background(Color.Red)
                .combinedClickable(
                    onClick = {
                        Toast.makeText(context, "Clicou!", Toast.LENGTH_SHORT).show()
                    },
                    onLongClick = {
                        Toast.makeText(context, "Clicou longo!", Toast.LENGTH_SHORT).show()
                    },
                    onDoubleClick = {
                        Toast.makeText(context, "Clicou duplo!", Toast.LENGTH_SHORT).show()
                    }
                )
        )
        // 📌 Exemplo 3: Arrastar (draggable)
        // .draggable → permite movimentar o componente em um eixo
        // orientation = Horizontal → arrasta apenas na horizontal
        // rememberDraggableState → guarda o estado do arrasto
        // offset → controla a posição X do Box
        var offset by remember { mutableStateOf(0f) }
        Box(
            modifier = Modifier
                .offset { IntOffset(offset.toInt(), 0) }
                .size(width = 300.dp, height = 100.dp)
                .background(Color.Blue)
                .draggable(
                    orientation = Orientation.Horizontal,
                    state = rememberDraggableState { delta ->
                        offset += delta
                    },
                    onDragStopped = {
                        Toast.makeText(context, "Parou!", Toast.LENGTH_SHORT).show()
                    }
                )
        )

        // 📌 Exemplo 4: Gestos personalizados com pointerInput
        // detectTapGestures → detecta toques específicos
        // - onTap → toque simples
        // - onDoubleTap → toque duplo
        // Útil quando precisamos capturar gestos complexos (zoom, swipe etc.)
        Box(
            modifier = Modifier
                .offset { IntOffset(offset.toInt(), 0) }
                .size(width = 300.dp, height = 100.dp)
                .background(Color.Magenta)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            Toast.makeText(context, "Clicou!", Toast.LENGTH_SHORT).show()
                        },
                        onDoubleTap = {
                            Toast.makeText(context, "Clicou duplo!", Toast.LENGTH_SHORT).show()
                        }
                    )


                }
        )

    }
}

@Preview
@Composable
private fun InteractionPropertiesPrewview() {
    AppComposeTheme {
        InteractionProperties()
    }
}