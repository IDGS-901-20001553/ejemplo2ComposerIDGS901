package org.utl.ejemplo2composeridgs901

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.savedstate.SavedStateRegistryController
import org.utl.ejemplo2composeridgs901.ui.theme.Ejemplo2ComposerIDGS901Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            navHost(navController= navController, startDestination = "inicio"){
                composable("inicio"){PantallaInicio(navController)}
                composable("detalle/{nombre}"){backStackEntry ->
                    val nombre = backStackEntry.arguments?.getString("nombre")?:"invitado"
                    PnatallaDetalle(navController, nombre)
                }
            }
        }
}

@Composable
fun pantallaInicip(navController: NavHostController){
    var nombre by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("pantalla de inicio")
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = nombre,
            onValueChange = {nombre = it},
            label = { Text("ingrese su nombre") },
            modifier = Modifier.fillMaxHeight()
        )

        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            val nombre = nombre.ifBlank{"cardiel"}
            navController.navigate("detalle/$nombre")
        }){
            Text("ir a detalle con nombre")
        }
    }

}
    @Composable
    fun PantallaDetalle(navController: NavHostController){
        ){
            value
        }
    }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ejemplo2ComposerIDGS901Theme {
        Greeting("Android")
    }
}