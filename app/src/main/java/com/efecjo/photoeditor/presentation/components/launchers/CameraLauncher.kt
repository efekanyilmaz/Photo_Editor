package com.efecjo.photoeditor.presentation.components.launchers

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.core.net.toUri
import com.efecjo.photoeditor.util.GalleryLauncherFlow
import com.efecjo.photoeditor.util.GalleryLauncherFlowModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraLauncher(
    permissionList : List<String>,
){
    val permissionState = rememberMultiplePermissionsState(permissions = permissionList)
    val scope = rememberCoroutineScope()

    if (permissionState.allPermissionsGranted){
        val cameraLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.TakePicture()) { uri ->
            scope.launch {
                GalleryLauncherFlow.setGalleryState(GalleryLauncherFlowModel(uri = uri.toString()))
            }
        }
        SideEffect {
            cameraLauncher.launch("image/*".toUri())
        }
    } else {
        PermissionRequiredDialog(permissionStates = permissionState)
    }

}
