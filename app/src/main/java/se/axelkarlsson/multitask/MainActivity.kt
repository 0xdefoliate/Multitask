package se.axelkarlsson.multitask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import se.axelkarlsson.multitask.route.addroutine.AddRoutineRoute
import se.axelkarlsson.multitask.route.addroutine.AddRoutineScreen
import se.axelkarlsson.multitask.route.overview.OverviewRoute
import se.axelkarlsson.multitask.route.overview.OverviewScreen
import se.axelkarlsson.multitask.route.routines.RoutinesRoute
import se.axelkarlsson.multitask.route.routines.RoutinesScreen
import se.axelkarlsson.multitask.ui.theme.MultitaskTheme
import se.axelkarlsson.multitask.util.Tab

class MainActivity : ComponentActivity() {

    val tabs = listOf(
        OverviewRoute,
        RoutinesRoute
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ContentView(tabs)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentView(tabs: List<Tab>) {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val destination = navBackStackEntry?.destination

    var title by remember { mutableStateOf("") }
    var showTabBar by remember { mutableStateOf(true) }

    MultitaskTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(title)
                })
            },
            bottomBar = {
                AnimatedVisibility(
                    visible = showTabBar,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    BottomAppBar {
                        NavigationBar {
                            tabs.forEach { tab ->
                                val selected = destination
                                    ?.hierarchy
                                    ?.any {
                                        it.hasRoute(tab::class)
                                    } == true

                                NavigationBarItem(
                                    icon = {
                                        Icon(
                                            painter = painterResource(tab.icon),
                                            contentDescription = null
                                        )
                                    },
                                    label = { Text(tab.label) },
                                    selected = selected,
                                    onClick = {
                                        navController.navigate(tab)
                                    }
                                )
                            }
                        }
                    }
                }
            }
        ) { innerPadding ->
            NavHost(
                modifier = Modifier.padding(innerPadding),
                navController = navController,
                startDestination = tabs.first()
            ) {
                composable<OverviewRoute> {
                    title = OverviewRoute.label
                    showTabBar = true

                    OverviewScreen()
                }

                composable<RoutinesRoute> {
                    title = RoutinesRoute.label
                    showTabBar = true

                    RoutinesScreen(callback = {
                        navController.navigate(AddRoutineRoute)
                    })
                }

                composable<AddRoutineRoute>(
                    enterTransition = {
                        slideInHorizontally { it }
                    }
                ) {
                    title = "Add Routine"
                    showTabBar = false

                    AddRoutineScreen()
                }
            }
        }
    }
}