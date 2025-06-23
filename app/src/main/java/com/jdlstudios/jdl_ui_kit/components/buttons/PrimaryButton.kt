package com.jdlstudios.jdl_ui_kit.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Un botón primario personalizado construido sobre el [Button] de Material 3.
 * Este botón está diseñado para acciones de alta énfasis en tu aplicación.
 *
 * @param onClick Callback que se invoca cuando el botón es presionado.
 * @param modifier Modificador a aplicar al botón.
 * @param enabled Controla el estado habilitado del botón. Cuando es `false`,
 *                este botón no responderá a la interacción del usuario.
 * @param shape Define la forma del botón. Por defecto usa [ButtonDefaults.shape].
 * @param colors [ButtonColors] que se utilizarán para este botón en diferentes estados.
 *               Por defecto usa los colores primarios del tema.
 * @param contentPadding El espaciado aplicado al interior del botón.
 *                       Por defecto usa [ButtonDefaults.ContentPadding].
 * @param text El texto a mostrar dentro del botón. Si se proporciona `content`,
 *             este parámetro se ignora.
 * @param content El contenido personalizado del botón. Permite más flexibilidad que solo texto,
 *                como agregar iconos.
 */
@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.shape, // Forma por defecto de Material
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.secondary,
        contentColor = MaterialTheme.colorScheme.onSecondary
    ),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    text: String? = null,
    content: @Composable RowScope.() -> Unit = {
        text?.let {
            Text(text = it)
        }
    }
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = colors,
        contentPadding = contentPadding,
        content = content
    )
}

// --- Preview para tu botón personalizado ---

@Preview(name = "Primary Button Enabled", showBackground = true)
@Composable
fun PrimaryButtonEnabledPreview() {
    // Si tu biblioteca no tiene su propio tema para previews,
    // puedes envolverlo en un MaterialTheme básico o en el tema de tu app si es accesible.
    MaterialTheme {
        PrimaryButton(
            onClick = { println("Botón Primario Presionado!") },
            text = "Acción Principal"
        )
    }
}

@Preview(name = "Primary Button Disabled", showBackground = true)
@Composable
fun PrimaryButtonDisabledPreview() {
    MaterialTheme {
        PrimaryButton(
            onClick = { /* No debería ejecutarse */ },
            text = "Acción Deshabilitada",
            enabled = false
        )
    }
}

@Preview(name = "Primary Button Custom Content", showBackground = true)
@Composable
fun PrimaryButtonCustomContentPreview() {
    MaterialTheme {
        PrimaryButton(
            onClick = { },
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
        ) {
            // Aquí puedes agregar un icono junto al texto, por ejemplo
            // Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
            // Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
            Text(text = "Con Icono (Ejemplo)")
        }
    }
}

