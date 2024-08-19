package ru.progpuppers.simmsearch.presentation.deviceselect.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Man
import androidx.compose.material.icons.filled.NearMe
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.progpuppers.simmsearch.app.R


data class LobbyUiState(
    val userName: String,
    val userPhone: String,
    val drawerItems: List<DrawerItem>,
    // val lobbyItems: List<Chat>
) {
    object MockedState {
        private fun mockedDrawerItem(): List<DrawerItem> = listOf(
            DrawerItem(Icons.Filled.Group, "New group"),
            DrawerItem(Icons.Filled.Person, "Contacts"),
            DrawerItem(Icons.Filled.Call, "Calls"),
            DrawerItem(Icons.Filled.NearMe, "Near me"),
            DrawerItem(Icons.Filled.Man, "Saved messages"),
            DrawerItem(Icons.Filled.Settings, "Settings"),
            DrawerItem(Icons.Filled.VerifiedUser, "Invite friends"),
            DrawerItem(Icons.Filled.Info, "About me")
        )

        fun lobbyUiMockedState(): LobbyUiState =
            // LobbyUiState("rooL", "+34 712 123 123", mockedDrawerItem(), listOf(Chat.mockedChat))
            LobbyUiState("rooL", "+34 712 123 123", mockedDrawerItem())
    }
}

data class DrawerItem(val icon: ImageVector, val text: String)

val TelegramBlue40 = Color(0xff517da3)

@Composable
fun DrawerSheet(uiState: LobbyUiState) {
    ModalDrawerSheet {
            Column(
                modifier = Modifier
                    .background(TelegramBlue40)
                    // .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = stringResource(
                        id = R.string.user_profile_pic_description
                    ),

                    modifier = Modifier
                        .padding(8.dp)
                        .size(64.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop

                )
                Text(
                    text = uiState.userName,
                    color = Color.White,
                    modifier = Modifier.padding(start = 8.dp),
                    style = MaterialTheme.typography.labelLarge
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = uiState.userPhone,
                    color = TelegramBlue40,
                    modifier = Modifier.padding(start = 8.dp),
                    style = MaterialTheme.typography.labelMedium
                )
            }
            uiState.drawerItems.forEach { item ->
                DrawerMenuItem(imageVector = item.icon, text = item.text)
            }
    }
}

@Composable
private fun DrawerMenuItem(
    imageVector: ImageVector,
    text: String,
    onItemClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text)
    }
}