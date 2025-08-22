package com.example.appcompose.ui.theme.component.ExampleModifier

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appcompose.ui.theme.AppComposeTheme


const val X = 100

@Composable
fun VisualProperties(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize() // Faz a coluna ocupar toda a tela
            .padding(16.dp), // Espaço interno nas bordas
        horizontalAlignment = Alignment.CenterHorizontally, // Centraliza filhos na horizontal
        verticalArrangement = Arrangement.spacedBy(16.dp) // Espaço fixo entre cada item
    ) {
        // 📌 Exemplo 1: Background com gradiente
        // Brush.horizontalGradient → cria um gradiente horizontal
        // listOf(Color.Yellow, Color.Red, Color.Blue) → cores do gradiente
        // Útil para fundos mais chamativos, botões, cards etc.
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color.Yellow,
                            Color.Red,
                            Color.Blue
                        )
                    )
                )
        )

        // 📌 Exemplo 2: Borda Simples
        // .border() → cria uma borda ao redor do componente
        // width = 3.dp → espessura
        // color = Color.Red → cor da borda
        // shape = CircleShape → formato circular
        // .background() → cor de fundo verde
        Box(
            modifier = Modifier
                .size(200.dp)
                .border(width = 3.dp, color = Color.Red, shape = CircleShape)
                .background(Color(red = 0, green = 255, blue = 0, alpha = 255))
        )

        // 📌 Exemplo 3: Sombra Simples
        // .shadow() → adiciona sombra com profundidade (elevation)
        // shape = RoundedCornerShape(8.dp) → cantos arredondados
        // Muito usado em cards, botões e containers
        Box(
            modifier = Modifier
                .size(200.dp)
                .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp))
                .background(Color(red = 0, green = 255, blue = 0, alpha = 255))
        )

        // 📌 Exemplo 4: graphicsLayer
        // Permite manipular o "plano gráfico" do componente:
        // - Rotação (rotationX, rotationY, rotationZ)
        // - Escala (scaleX, scaleY)
        // - Transparência (alpha)
        // Muito útil para animações ou efeitos visuais personalizados

        Box(
            modifier = Modifier
                .size(200.dp)
                .graphicsLayer {
                    // Obs: "X" precisa ser uma variável (não declarada no código)
                    // Aqui simulamos um cálculo qualquer
                    val rotationZ = X * 0.15f
                    this.rotationZ = rotationZ // Rotação no eixo Z
                    rotationX = 15f// Rotação no eixo X
                    scaleY = 2f // Escala vertical (aumenta em 2x)
                    alpha = 0.5f  // 50% de transparência
                }
                .background(Color(red = 255, green = 255, blue = 0, alpha = 255))
        )


    }
}

@Preview(showBackground = true)
@Composable
private fun VisualPropertiesPreview() {
    AppComposeTheme {
        VisualProperties()
    }
}