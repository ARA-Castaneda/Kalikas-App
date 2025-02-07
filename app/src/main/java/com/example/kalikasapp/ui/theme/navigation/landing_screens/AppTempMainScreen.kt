package com.example.kalikasapp.ui.theme.navigation.landing_screens

/*
@Composable
fun LogoImage(modifier: Modifier) {
    val image = painterResource(R.drawable.logo)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null
        )
    }
}

@Composable
fun AppMainScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }

    Box {
        Scaffold(
            containerColor = Color.Transparent,
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    onClick = {
                        navController.navigate(Screen.AppSignupScreen.withArgs(text))
                    }
                ) {
                    Text(text = "Sign Up")
                }
            }
        ) { innerPadding ->
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp)
            ) {
                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            /*
            Button(
                onClick = {
                    navController.navigate(Screen.AppSignupScreen.withArgs(text))
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Sign Up")
            }
             */
        }
        LogoImage(
            modifier = Modifier.
            fillMaxHeight(0.2f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppMainScreenPreview() {
    val navController = rememberNavController()
    AppMainScreen(navController = navController)
}
 */