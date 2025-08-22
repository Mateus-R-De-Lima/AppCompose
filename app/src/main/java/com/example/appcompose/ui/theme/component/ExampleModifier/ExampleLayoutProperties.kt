package com.example.appcompose.ui.theme.component.ExampleModifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appcompose.ui.theme.AppComposeTheme

@Composable
fun LayoutProperties(modifier: Modifier = Modifier) {
    // Column → organiza os elementos filhos em uma coluna (vertical)
    // .fillMaxSize() → faz a coluna ocupar toda a tela
    // .padding() → adiciona espaçamento nas bordas
    // horizontalAlignment → alinha horizontalmente os filhos dentro da coluna
    // verticalArrangement.spacedBy(16.dp) → adiciona um espaço fixo entre os itens
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 16.dp,
                top = 8.dp,
                end = 16.dp,
                bottom = 8.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {
        // 📌 Exemplo 1: Tamanho Fixo
        // Quando queremos que o elemento tenha largura e altura específicas
        // .width() → define largura
        // .height() → define altura
        // .background(Color.Green) → aplica cor de fundo para visualizar
        Box(
            modifier = Modifier
                // .size(200.dp)
                .width(100.dp)
                .height(50.dp)
                .background(Color.Green)
        )

        // 📌 Exemplo 2: Preenchimento baseado em tamanho disponível
        // .fillMaxHeight(0.5f) → ocupa 50% da altura disponível
        // .width(200.dp) → largura fixa
        // Útil quando queremos layouts responsivos proporcionais

        Box(
            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//                .fillMaxHeight()
//                .width(200.dp)
                .fillMaxHeight(0.5f)
                .width(200.dp)
                .background(Color.Red)
        )



        // 📌 Exemplo 3: Offset (deslocamento de posição)
        // .offset() → move o elemento da sua posição original
        // Aqui desloca -100dp no eixo X (esquerda) e +25dp no eixo Y (baixo)
        // Útil para ajustes visuais ou sobreposição de elementos
        Box(
            modifier = Modifier
                .size(100.dp)
                .offset(x = (-100).dp,y = 25.dp)
                .background(Color.Blue)

        )

        // 📌 Exemplo 4: Aspect Ratio (proporção fixa)
        // .aspectRatio(16f/10f) → mantém largura proporcional à altura
        // Mesmo que a altura seja definida, a largura será ajustada
        // Muito usado para imagens e vídeos (ex.: 16:9, 1:1 etc.)

        Box(
            modifier = Modifier
                .height(100.dp)
                .aspectRatio(16f/10f)
                .background(Color.Magenta)

        )

        // 📌 Exemplo 5: Distribuição de espaço com Row + weight
        // Row → organiza elementos lado a lado (horizontal)
        // .fillMaxWidth() → ocupa toda a largura da tela
        // .height(300.dp) → altura fixa para visualização
        // .weight() → distribui espaço proporcional entre elementos

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color.Gray)
        ){
            // Ocupa 1 parte do espaço
            Box(
                modifier = Modifier
                    // .size(200.dp)
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green)
            )
            // Ocupa 2 partes do espaço (o dobro da verde)
            // + largura fixa de 100.dp
            Box(
                modifier = Modifier
                    // .size(200.dp)
                    .width(100.dp)
                    .weight(2f)
                    .fillMaxHeight()
                    .background(Color.Yellow)
            )
            // Ocupa 1 parte do espaço (igual à verde)
            Box(

                modifier = Modifier
                    // .size(200.dp)
                    .width(100.dp)
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Cyan)
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
private fun LayoutPropertiesPreview() {
    AppComposeTheme {
        LayoutProperties()
    }
}