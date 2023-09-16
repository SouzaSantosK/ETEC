import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import {
  createStackNavigator,
  TransitionSpecs,
  CardStyleInterpolators,
} from "@react-navigation/stack";
import "react-native-gesture-handler";
import { useFonts } from "expo-font";
import Open from "./src/Pages/Open";
import Login from "./src/Pages/Login";
import Splash from "./src/Pages/Splash";
import Register from "./src/Pages/Register";
import SignIn from "./src/Pages/SignIn";

const Stack = createStackNavigator();

export default function App() {
  const [fontsLoaded] = useFonts({
    "Inter-Regular": require("./src/fonts/Inter-Regular.ttf"),
    "Inter-Bold": require("./src/fonts/Inter-Bold.ttf"),
    "Inter-Light": require("./src/fonts/Inter-Light.ttf"),
    "Inter-Thin": require("./src/fonts/Inter-Thin.ttf"),
  });

  return (
    <NavigationContainer>
      <Stack.Navigator
        initialRouteName="Splash"
        screenOptions={{ headerShown: false }}
      >
        <Stack.Screen
          name="Splash"
          component={Splash}
          options={{
            title: "Splash",
            cardStyleInterpolator: CardStyleInterpolators.forHorizontalIOS,
          }}
        />
        <Stack.Screen
          name="Open"
          component={Open}
          options={{
            title: "Profile",
            cardStyleInterpolator: CardStyleInterpolators.forHorizontalIOS,
          }}
        />
        <Stack.Screen
          name="Login"
          component={Login}
          options={{
            title: "Profile",
            cardStyleInterpolator: CardStyleInterpolators.forHorizontalIOS,
          }}
        />
        <Stack.Screen
          name="Register"
          component={Register}
          options={{
            title: "Profile",
            cardStyleInterpolator: CardStyleInterpolators.forHorizontalIOS,
          }}
        />
        <Stack.Screen
          name="SignIn"
          component={SignIn}
          options={{
            title: "Profile",
            cardStyleInterpolator: CardStyleInterpolators.forHorizontalIOS,
          }}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
