import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginapp.ui.SignupScreen
import com.example.loginapplication.ui.theme.login.domain.data.ui.LoginScreen

@Composable
fun LoginApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen( onSignupClick = { navController.navigate("signup") }) }
        composable("signup") { SignupScreen(onLoginClick = {navController.navigate("login") }, onSignupClick = { navController.navigate("login") }) }
    }
}

