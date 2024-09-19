package ru.progpuppers.simmsearch.presentation.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import ru.progpuppers.simmsearch.app.R


@Composable
fun InputIcon(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    description: String = "No description",
    tint: Color? = null,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            icon,
            tint = tint ?: LocalContentColor.current,
            modifier = modifier,
            contentDescription = description
        )
    }
}

@Composable
fun TextIconButton(
    text: String,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onSurface,
        disabledContainerColor = Color.Transparent,
        disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
    ),
    contentPadding: PaddingValues = ButtonDefaults.TextButtonContentPadding,
    enabled: Boolean = true,
    textStyle: TextStyle? = null,
    icon: ImageVector,
    iconTint: Color? = null,
    iconDescription: String = "No description",
    iconModifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = contentPadding,
        colors = colors
    ) {
        Text(
            text = text,
            style = textStyle ?: LocalTextStyle.current
        )
        Icon(
            modifier = iconModifier,
            imageVector = icon,
            contentDescription = iconDescription,
            tint = iconTint ?: LocalContentColor.current
        )
    }
}

@Composable
fun NotAvailablePopup(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        text = {
            Text(
                text = stringResource(id = R.string.not_implemented),
                style = MaterialTheme.typography.bodyMedium
            )
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(text = stringResource(id = R.string.close))
            }
        }
    )
}

enum class NotAvailablePopUpState {
    VISIBLE, GONE;
}

fun NotAvailablePopUpState.isVisible(): Boolean = this == NotAvailablePopUpState.VISIBLE

// fun Modifier.padding(start: Dp, other: Dp) = this then Modifier.padding(start, other, other, other)

