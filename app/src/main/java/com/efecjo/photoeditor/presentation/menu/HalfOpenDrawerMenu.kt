package com.efecjo.photoeditor.presentation.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.efecjo.photoeditor.presentation.theme.DarkBlue

@Composable
fun HalfOpenDrawerMenu(
    drawerState: DrawerState,
    onNavigate: (String) -> Unit,
    onPopBackStack: () -> Unit,
    viewModel: MenuViewModel = hiltViewModel()
) {

    val state = viewModel.menuState.value
    // Create the drawer menu.
    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            Box(Modifier.fillMaxHeight()){
                LazyColumn(modifier = Modifier.fillMaxWidth(0.8f)) {
                    items(listOf("FAQ", "Help", "Purchase token", "Options")) { section ->
                        Text(text = section, modifier = Modifier.padding(16.dp), color = DarkBlue)
                    }
                }
                Text(text = "@Copyright Efecjo Software",
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(16.dp),
                    color = DarkBlue,
                    textAlign = TextAlign.Center)
            }


        }
    ) {
        // Create the content of the main screen.
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Profile picture.
            if (state.profilePhoto != null) {
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(128.dp)
                ) {
                    Image(
                        bitmap = state.profilePhoto,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp))
                            .aspectRatio(1f)
                    )
                }
            }
        }
    }


    if (state.isDrawerClosed) {
        onPopBackStack()
    }
}

sealed class MenuEvent {
    object InitOperationsForMenuEvent : MenuEvent()
}