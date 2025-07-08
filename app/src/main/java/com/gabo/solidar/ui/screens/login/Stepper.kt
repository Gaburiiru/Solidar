package com.gabo.solidar.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Stepper(step: Int) {
    val steps = listOf("Cuenta", "Datos")
    val activeColor = MaterialTheme.colorScheme.primary
    val inactiveColor = MaterialTheme.colorScheme.outline

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Parte superior: círculos + dividers (alineados)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth(),
        ) {
            steps.forEachIndexed { index, _ ->
                // Círculo con número centrado
                Box(
                    modifier =
                        Modifier
                            .size(32.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Box(
                        modifier =
                            Modifier
                                .matchParentSize()
                                .clip(CircleShape)
                                .background(
                                    when {
                                        step > index + 1 -> activeColor.copy(alpha = 0.6f)
                                        step == index + 1 -> activeColor
                                        else -> inactiveColor
                                    },
                                ),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = "${index + 1}",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.labelMedium,
                        )
                    }
                }

                // Divider solo entre círculos
                if (index < steps.lastIndex) {
                    Box(
                        modifier =
                            Modifier
                                .width(40.dp)
                                .height(1.dp)
                                .background(if (step > index + 1) activeColor else inactiveColor),
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        // Parte inferior: etiquetas de texto debajo de cada círculo
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top,
            modifier = Modifier.fillMaxWidth(),
        ) {
            steps.forEachIndexed { index, label ->
                Box(
                    modifier =
                        Modifier
                            .width(40.dp),
                    contentAlignment = Alignment.TopCenter,
                ) {
                    Text(
                        text = label,
                        color = if (step >= index + 1) activeColor else inactiveColor,
                        style = MaterialTheme.typography.labelSmall,
                        textAlign = TextAlign.Center,
                    )
                }

                // Espaciado proporcional al divider
                if (index < steps.lastIndex) {
                    Spacer(modifier = Modifier.width(32.dp))
                }
            }
        }
    }
}
