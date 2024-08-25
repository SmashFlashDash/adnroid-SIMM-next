package ru.progpuppers.simmsearch.presentation.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import ru.progpuppers.simmsearch.app.R


@Composable
fun InputIcon(
    onClick: () -> Unit,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    description: String = "No description",
    tint: Color = MaterialTheme.colorScheme.secondary
) {
    IconButton(onClick = onClick) {
        Icon(icon, tint = tint, modifier = modifier, contentDescription = description)
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
    fun isVisible(): Boolean = this == VISIBLE
}

// fun NotAvailablePopUpVisibility.isVisible(): Boolean =
//     this == NotAvailablePopUpVisibility.VISIBLE

fun Modifier.padding(start: Dp, other: Dp) = this then Modifier.padding(start, other, other, other)

