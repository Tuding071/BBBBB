package com.grey.browser

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun Homescreen() {
    var text by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Full screen background image
        Image(
            painter = painterResource(id = R.drawable.ss),
            contentDescription = "SS Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Text field centered on top of image
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Type here...") },
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(0.85f)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White.copy(alpha = 0.9f))
                .focusRequester(focusRequester),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White.copy(alpha = 0.9f),
                unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White.copy(alpha = 0.5f)
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            singleLine = true,
            shape = RoundedCornerShape(12.dp)
        )
    }
}
