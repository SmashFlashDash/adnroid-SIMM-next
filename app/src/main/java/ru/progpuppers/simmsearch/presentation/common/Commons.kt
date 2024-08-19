package ru.progpuppers.simmsearch.presentation.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import ru.progpuppers.simmsearch.app.R


@Composable
fun InputIcon(
    onClick: () -> Unit,
    icon: ImageVector,
    description: String,
    tint: Color = MaterialTheme.colorScheme.secondary
) {
    IconButton(onClick = onClick) {
        Icon(icon, tint = tint, contentDescription = description)
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

enum class NotAvailablePopUpVisibility {
    VISIBLE, GONE
}

fun NotAvailablePopUpVisibility.isVisible(): Boolean =
    this == NotAvailablePopUpVisibility.VISIBLE