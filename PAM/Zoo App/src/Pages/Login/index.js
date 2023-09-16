import { StatusBar } from "expo-status-bar";
import {
  Text,
  View,
  Image,
  TextInput,
  TouchableOpacity,
  ImageBackground,
} from "react-native";
import { LinearGradient } from "expo-linear-gradient";
import styles from "./style";
import Open from "../Open";

export default function Login({ navigation }) {
  return (
    <View style={styles.container}>
      <ImageBackground
        source={require("../../images/open-background.jpg")}
        resizeMode="cover"
        style={styles.backgroundImage}
      >
        <LinearGradient
          colors={["rgba(0, 0, 0, 0.3)", "rgba(0, 0, 0, 1)"]}
          style={styles.linearGradient}
        >
          <View style={styles.header}>
            <Text style={styles.headerP}>Faça Login </Text>
            <Text style={[styles.headerP, { color: "white" }]}>
              Na sua conta
            </Text>
          </View>
          <View style={styles.buttons}>
            <TouchableOpacity style={[styles.login, styles.button]}>
              <Text style={styles.buttonText}>Entrar</Text>
            </TouchableOpacity>

            <TouchableOpacity
              style={styles.button}
              onPress={() => navigation.navigate(Open)}
            >
              <Text
                style={[
                  styles.buttonText,
                  {
                    fontFamily: "Inter-Light",
                    color: "#F4892A",
                    textAlign: "center",
                    fontSize: 16,
                  },
                ]}
              >
                Ainda não possui uma conta? Cadastre-se
              </Text>
            </TouchableOpacity>
          </View>
        </LinearGradient>
      </ImageBackground>
      <StatusBar style="auto" />
    </View>
  );
}
