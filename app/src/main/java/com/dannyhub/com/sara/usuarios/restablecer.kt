package com.dannyhub.com.sara.usuarios

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dannyhub.com.sara.R

////////////////
import androidx.compose.ui.text.style.TextAlign
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.*
import com.dannyhub.com.sara.ui.theme.GreenImsalud
import androidx.compose.material.icons.filled.Email
import com.dannyhub.com.sara.footer.AppFooter


@Composable
fun PasswordResetScreen() {
    var email by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf(false) }

    val context = LocalContext.current

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {



            Image(
                painter = painterResource(id = R.drawable.logocompleto),
                contentDescription = "Logo Imsalud",
                modifier = Modifier
                    .height(140.dp)
                    .padding(bottom = 16.dp)
            )

            Text(
                text = "Restablecer Contraseña en el\nSistema de Administración de Recursos y Aplicaciones",
                fontSize = 18.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                lineHeight = 24.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    emailError = false
                },
                label = { Text("Correo electrónico") },
                isError = emailError,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = GreenImsalud,
                    unfocusedBorderColor = GreenImsalud,
                    cursorColor = GreenImsalud,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Gray
                )
            )

            if (emailError) {
                Text(
                    text = "Por favor, introduce un correo válido",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    if (email.isBlank() || !email.contains("@")) {
                        emailError = true
                    } else {
                        Toast.makeText(
                            context,
                            "Se ha enviado el enlace a: $email",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = GreenImsalud)
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Enviar Enlace", color = Color.White)
            }

            Spacer(modifier = Modifier.height(40.dp))
            AppFooter()
        }
    }
}
