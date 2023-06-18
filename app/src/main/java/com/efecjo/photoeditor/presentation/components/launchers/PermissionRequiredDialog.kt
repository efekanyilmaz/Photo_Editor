package com.efecjo.photoeditor.presentation.components.launchers


import android.Manifest
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.room.util.TableInfo
import com.google.accompanist.permissions.*
import timber.log.Timber
import java.util.*

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionRequiredDialog(
    permissionStates: MultiplePermissionsState,
) {
    var showDialog by remember { mutableStateOf(true) }
    val permissionTitle by remember {
        mutableStateOf("")
    }

    PermissionsRequired(
        multiplePermissionsState = permissionStates,
        permissionsNotGrantedContent = { //Create a dialog to show the rationale and request the permissions
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = showDialog.not() },
                    title = { Text(text = permissionTitle) },
                    text = { Text(text = "Please enable the required permissions") },
                    confirmButton = {
                        TextButton(onClick = { permissionStates.launchMultiplePermissionRequest() }) {
                            Text(text = "Ok".uppercase(Locale.ROOT))
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { showDialog = showDialog.not() }) {
                            Text(text = "Cancel".uppercase(Locale.ROOT))
                        }
                    }
                )
            }
        },
        permissionsNotAvailableContent = { //RedirectToSettingsDialog(permissionTitle = permissionTitle)
            AlertDialog(
                onDismissRequest = { showDialog = showDialog.not() },
                title = { Text(text = permissionTitle) },
                text = { Text(text = "Please go to settings and enable the required permissions") },
                confirmButton = {
                    TextButton(onClick = { showDialog = showDialog.not() }) {
                        Text(text = "Ok")
                    }
                }
            )
        },
        content = {
            Timber.d("Permission granted")
        }
    )

}
