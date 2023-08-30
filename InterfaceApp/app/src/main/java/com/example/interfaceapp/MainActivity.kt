package com.example.interfaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.interfaceapp.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterfaceAppTheme {
                LoginScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleCenterAlignedTopAppBar() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Centered TopAppBar",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            LazyCol0umn(
                contentPadding = innerPadding,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

            }
        }
    )
}

@Composable
fun LazyCol0umn(contentPadding: PaddingValues, verticalArrangement: Arrangement.HorizontalOrVertical, content: () -> Unit) {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(darkBlueColor)
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        TextTitulo()
        Spacer(modifier = Modifier.height(16.dp))
        SimpleEmailOutlinedTextFieldSample()
        Spacer(modifier = Modifier.height(16.dp))
        SimplePasswordOutlinedTextFieldSample()
        Spacer(modifier = Modifier.height(16.dp))
        TextSenha()
        Spacer(modifier = Modifier.height(16.dp))
        CheckboxWithTextSample()
        Spacer(modifier = Modifier.height(16.dp))
        Button()
        Spacer(modifier = Modifier.height(20.dp))
        TextCriarConta()
    }
}

@Composable
fun TextTitulo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Minha Conta",
            fontSize = 35.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Row {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Ícone de Email",
                    tint = laranjaColor,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    "Email",
                    color = Color.White
                )
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        modifier = Modifier.fillMaxWidth()

    )
}

@Composable
fun SimpleEmailOutlinedTextFieldSample() {
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        EmailOutlinedTextField(
            value = email,
            onValueChange = { email = it }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Row {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Ícone de Senha",
                    tint = laranjaColor,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    "Senha",
                    color = Color.White,
                )
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        singleLine = true,
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun SimplePasswordOutlinedTextFieldSample() {
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        PasswordOutlinedTextField(
            value = password,
            onValueChange = { password = it }
        )
    }
}

@Composable
fun TextSenha() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Esqueci minha senha",
                fontSize = 14.sp,
                color = Color.Gray,
        )
    }
}

@Composable
fun CheckboxWithTextSample() {
    val (checkedState, onStateChange) = remember { mutableStateOf(true) }
    Row(
        Modifier
            .fillMaxWidth()
            .width(180.dp)
            .height(25.dp)
            .toggleable(
                value = checkedState,
                onValueChange = { onStateChange(!checkedState) },
                role = Role.Checkbox
            )
            .padding(horizontal = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = null,
            colors = CheckboxDefaults.colors(
                checkmarkColor = Color.White,
                checkedColor = laranjaColor,
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Mostrar Senha",
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun Button() {
    ExtendedFloatingActionButton(
        onClick = { /* do something */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .height(48.dp)
            .padding(horizontal = 16.dp),
        containerColor = laranjaColor,
        contentColor = Color.Black,
        shape = MaterialTheme.shapes.small.copy(CornerSize(4.dp))
    ) {
        Text(text = "ENTRAR", color = Color.White)
    }
}


@Composable
fun TextCriarConta() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Ainda não tem uma conta? Crie Agora",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            textAlign = TextAlign.Start
        )

    }
}

@Composable
@Preview
fun Login(){
    LoginScreen()
}

