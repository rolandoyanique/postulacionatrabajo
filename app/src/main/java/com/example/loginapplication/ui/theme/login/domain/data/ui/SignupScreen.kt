package com.example.loginapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import com.example.loginapplication.R

@Composable
fun SignupScreen(onLoginClick: () -> Unit,onSignupClick: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }
    var isError by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AsyncImage(
            model = R.drawable.fondoapp,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    alpha = 0.7f // Ajustar transparencia según sea necesario
                },
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Registro",
                fontSize = 32.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Divider(
                color = Color.Black,
                modifier = Modifier.padding(bottom = 24.dp)
            )
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
                isError = isError,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            Text("Número de telefóno")
            TextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Ej: +54 12345678") },
                leadingIcon = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 16.dp, end = 8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Call,
                            contentDescription = "Phone Icon"
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
                isError = isError,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            Text("Contraseña")
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Ej: abcABC#123") },
                leadingIcon = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 16.dp, end = 8.dp)
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
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            imageVector = if (passwordVisibility) ImageVector.vectorResource(id = R.drawable.visibility) else ImageVector.vectorResource(id = R.drawable.visibility_off),
                            contentDescription = if (passwordVisibility) "Ocultar contraseña" else "Mostrar contraseña"
                        )
                    }
                },
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                isError = isError,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            Text("Confirmar contraseña")
            TextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Reingresar contraseña") },
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
                    IconButton(onClick = { confirmPasswordVisibility = !confirmPasswordVisibility }) {
                        Icon(
                            imageVector = if (confirmPasswordVisibility) ImageVector.vectorResource(id = R.drawable.visibility) else ImageVector.vectorResource(id = R.drawable.visibility_off),
                            contentDescription = if (confirmPasswordVisibility) "Ocultar contraseña" else "Mostrar contraseña"
                        )
                    }
                },
                visualTransformation = if (confirmPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                isError = isError,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )


            if (isError) {
                Text("Datos incorrectos", color = Color.Red, modifier = Modifier.padding(bottom = 16.dp))
            }

            Button(
                onClick = {
                    // Handle signup
                    isError = email.isEmpty() || phone.isEmpty() || password.isEmpty() || password != confirmPassword
                    if (!isError) {
                        onLoginClick()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Crear cuenta")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "Ya tienes una cuenta?",
                    style = MaterialTheme.typography.headlineLarge.copy(fontSize = 16.sp)
                )
                TextButton(onClick = { onSignupClick() }) {
                    Text("Ingresar")
                }
            }
        }
    }
}
