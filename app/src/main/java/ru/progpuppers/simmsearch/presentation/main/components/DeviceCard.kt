package ru.progpuppers.simmsearch.presentation.main.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import ru.progpuppers.simmsearch.domain.model.SimmDevice
import ru.progpuppers.simmsearch.ui.theme.SimmnextTheme

@Composable
fun SimmDeviceCard(
    modifier: Modifier = Modifier,
    device: SimmDevice,
    onClick: (() -> Unit)? = null
) {
    val context = LocalContext.current
    Row(
        modifier = modifier.clickable { onClick?.invoke() }
    ) {

    }

}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SimmDeviceCardPreview() {
    SimmnextTheme(dynamicColor = false) {
        SimmDeviceCard(
            device = SimmDevice(
                // author = "",
                // content = "",
                // description = "",
                // publishedAt = "2 hours",
                // source = Source(id = "", name = "BBC"),
                // title = "Her train broke down. Her phone died. And then she met her Saver in a",
                // url = "",
                // urlToImage = "https://img.freepik.com/free-photo/beautiful-kitten-with-colorful-clouds_23-2150752964.jpg?size=626&ext=jpg&ga=GA1.1.2008272138.1723334400&semt=ais_hybrid"
            )
        )
    }
}