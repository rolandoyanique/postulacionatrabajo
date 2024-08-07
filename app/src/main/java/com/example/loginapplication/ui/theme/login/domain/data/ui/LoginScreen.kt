package com.example.loginapplication.ui.theme.login.domain.data.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.VisualTransformation
import coil.compose.AsyncImage
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import com.example.loginapplication.R

@Composable
fun LoginScreen( onSignupClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        backgroundImage()
        bodyApp(onSignupClick)
    }
}
@Composable
fun backgroundImage(){
    AsyncImage(
        model = R.drawable.fondoapp,
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer {
                alpha = 0.7f
            },
        contentScale = ContentScale.Crop
    )
}
@Composable
fun bodyApp(onSignupClick: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        titleApp()
        emailApp()
        passwordApp()
        recoverPasswordApp()
        buttonLoginApp(onSignupClick)
        registerApp(onSignupClick)
    }
}
@Composable
fun titleApp(){
    Text(
        text = "Ingreso",
        style = MaterialTheme.typography.headlineLarge.copy(fontSize = 24.sp),
        modifier = Modifier.padding(bottom = 8.dp)
    )
    Divider(modifier = Modifier.padding(bottom = 16.dp))
}
@Composable
fun emailApp(){
    var email by remember { mutableStateOf(TextFieldValue()) }
    val emailError by remember { mutableStateOf("") }
    Text("Correo electrónico")
    TextField(
        value = email,
        onValueChange = { email = it },
        label = { Text("Ingresar correo electrónico") },
        leadingIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 16.dp, end = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email Icon"
                )
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .height(24.dp)
                        .width(1.dp)
                        .background(Color.Gray)
                )
            }
        },
        isError = emailError.isNotEmpty(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
    )

    if (emailError.isNotEmpty()) {
        Text(text = emailError, color = Color.Red, style = MaterialTheme.typography.bodySmall)
    }
}
@Composable
fun passwordApp(){
    var password by remember { mutableStateOf(TextFieldValue()) }
    var isPasswordVisible by remember { mutableStateOf(false) }

    val passwordError by remember { mutableStateOf("") }
    Text("Contraseña")
    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Ej:abcABC#123") },
        leadingIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 16.dp, end = 8.dp) // Ajusta el padding según sea necesario
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.password),
                    contentDescription = "Password Icon"
                )
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .height(24.dp)
                        .width(1.dp)
                        .background(Color.Gray)
                )
            }
        },
        trailingIcon = {
            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Icon(
                    imageVector = if (isPasswordVisible) ImageVector.vectorResource(id = R.drawable.visibility) else ImageVector.vectorResource(id = R.drawable.visibility_off),
                    contentDescription = if (isPasswordVisible) "Ocultar contraseña" else "Mostrar contraseña"
                )
            }
        },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        isError = passwordError.isNotEmpty(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    )

    if (passwordError.isNotEmpty()) {
        Text(text = passwordError, color = Color.Red, style = MaterialTheme.typography.bodySmall)
    }

}
@Composable
fun recoverPasswordApp(){
    var rememberMe by remember { mutableStateOf(false) }
    // Signup Link
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = rememberMe,
                onCheckedChange = { rememberMe = it }
            )
            Text(text = "Recordarme")
        }

        TextButton(onClick = { /* Handle onSignupClick */ }) {
            Text("Contraseña olvidada?")
        }
    }
}
@Composable
fun buttonLoginApp(onSignupClick: () -> Unit){
    var isError by remember { mutableStateOf(false) }
    if (isError) {
        Text("Datos incorrectos", color = Color.Red, modifier = Modifier.padding(bottom = 16.dp))
    }
    Button(
        onClick = {
            onSignupClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Text("Ingresar")
    }
}
@Composable
fun registerApp(onSignupClick: () -> Unit){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = "No tienes una cuenta?",
            style = MaterialTheme.typography.headlineLarge.copy(fontSize = 16.sp)
        )
        TextButton(onClick = { onSignupClick() }) {
            Text("Regístrate")
        }
    }
}