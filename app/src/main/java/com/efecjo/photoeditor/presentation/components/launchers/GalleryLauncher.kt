package com.efecjo.photoeditor.presentation.components

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import com.efecjo.photoeditor.presentation.components.launchers.PermissionRequiredDialog
import com.efecjo.photoeditor.util.GalleryLauncherFlow
import com.efecjo.photoeditor.util.GalleryLauncherFlowModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun GalleryLauncher(
    permissionList: List<String>,
){
    val scope = rememberCoroutineScope()
    val permissionsState = rememberMultiplePermissionsState(permissions = permissionList)

    if (permissionsState.allPermissionsGranted){
        val galleryLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia()) { uri ->
            scope.launch {
                GalleryLauncherFlow.setGalleryState(GalleryLauncherFlowModel(uri = uri.toString()))
            }
        }
        SideEffect {
            galleryLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }
    } else {
        PermissionRequiredDialog(permissionStates = permissionsState)
    }

}
