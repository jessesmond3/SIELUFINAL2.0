package com.example.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Scaffold
import androidx.compose.ui.platform.LocalContext
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
//import androidx.constraintlayout.compose.createRefs
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FabPosition


// Esto ahora es un Composable de nivel superior para ser usado con NavHost
@Composable
fun pantallaPrincipal() {
    dashboard()
}

@Composable
fun dashboard() {
    var text by rememberSaveable { mutableStateOf("") }

    Scaffold(
        bottomBar = { MyButtonBar() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO: Acción para el FAB*/ },
                containerColor = Color(android.graphics.Color.parseColor("#0e5563")),
                contentColor = Color.White
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.solecito),
                    contentDescription = "add",
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )
            }
        },
        //isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color(android.graphics.Color.parseColor("#fcfcfc")))
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Icon representing the sun",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clickable { /* Handle click if needed */ }
                )
                Column(
                    modifier = Modifier
                        .height(100.dp)
                        .padding(start = 14.dp)
                        .weight(0.7f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "SIELU",
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "sielu.com",
                        color = Color.Black,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(top = 14.dp)
                    )
                }
            }

            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                label = { Text(text = "Searching for...") },
                trailingIcon = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .padding(end = 6.dp)
                                .height(45.dp)
                                .width(45.dp)
                                .background(
                                    Color(android.graphics.Color.parseColor("#fdfbfb")),
                                    shape = RoundedCornerShape(10.dp)
                                )
                        )
                        Image(
                            painter = painterResource(id = R.drawable.lupa),
                            contentDescription = "Search icon",
                            modifier = Modifier
                                .size(35.dp)
                                .padding(end = 6.dp)
                        )
                    }
                },
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedLabelColor = Color.Gray,
                    unfocusedLabelColor = Color.Gray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .background(Color.White, CircleShape)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(end = 12.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(65.dp)
                            .width(75.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#fdcb61")),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.agenda),
                            contentDescription = "Placeholder icon"
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .height(40.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#5e5e5e")),
                                shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Agenda",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(start = 12.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(65.dp)
                            .width(75.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#fefbfb")),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.meditacion),
                            contentDescription = "Placeholder icon 2"
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .height(40.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#5e5e5e")),
                                shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Meditación",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(end = 12.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(65.dp)
                            .width(75.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#fefbfb")),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.frase),
                            contentDescription = "Placeholder icon"
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .height(40.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#5e5e5e")),
                                shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Frase",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(start = 12.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(65.dp)
                            .width(75.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#fefbfb")),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.motivacion),
                            contentDescription = "Placeholder icon 2"
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .height(40.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#5e5e5e")),
                                shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Motivación",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }

            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .height(120.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(android.graphics.Color.parseColor("#0e5563")),
                                Color(android.graphics.Color.parseColor("#83c1b4"))
                            )
                        ), shape = RoundedCornerShape(25.dp)
                    )
            ) {
                val (img, text1, text2) = createRefs()
                Image(
                    modifier = Modifier.constrainAs(img) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    },
                    painter = painterResource(id = R.drawable.nubes),
                    contentDescription = "Clouds background image"
                )
                Text(
                    text = "¡Bienvenide a",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .constrainAs(text1) {
                            top.linkTo(parent.top, margin = 16.dp)
                            start.linkTo(img.end, margin = 8.dp)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                        }
                )
                Text(
                    text = "SIELU",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .constrainAs(text2) {
                            top.linkTo(text1.bottom, margin = 4.dp)
                            start.linkTo(text1.start)
                            end.linkTo(text1.end)
                            width = Dimension.fillToConstraints
                        }
                )
            }
        }
    }
}

data class BottomMenuItem(val label: String, val icon: Painter)

@Composable
fun MyButtonBar() {
    val contextForToast = LocalContext.current.applicationContext

    var selectedItem by rememberSaveable {
        mutableStateOf("home") // o cualquier valor inicial
    }

    val bottomMenuItems = listOf(
        BottomMenuItem("home", painterResource(id = R.drawable.contenedor)),
        BottomMenuItem("search", painterResource(id = R.drawable.contenedor)),
        BottomMenuItem("profile", painterResource(id = R.drawable.contenedor)),
        BottomMenuItem("settings", painterResource(id = R.drawable.contenedor))
    )

    BottomAppBar(
        containerColor = Color.White,
        contentColor = MaterialTheme.colorScheme.onSurface,
        tonalElevation = 3.dp
    ) {
        bottomMenuItems.forEach { item ->
            NavigationBarItem(
                selected = (selectedItem == item.label),
                onClick = {
                    selectedItem = item.label
                    Toast.makeText(contextForToast, item.label, Toast.LENGTH_SHORT).show()
                },
                icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = item.label,
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp)
                    )
                },
                label = {
                    Text(text = item.label, modifier = Modifier.padding(top = 14.dp))
                },
                alwaysShowLabel = true
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardPreview() {
    MaterialTheme {
        dashboard()
    }
}

@Preview(showBackground = true)
@Composable
fun MyButtonBarPreview() {
    MaterialTheme {
        MyButtonBar()
    }
}