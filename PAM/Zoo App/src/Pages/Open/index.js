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
import Login from "../Login";

export default function Open({ navigation }) {
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
            <Text style={styles.headerP}>Olá, </Text>
            <Text style={styles.headerP}>Bem-vindo ao</Text>
            <Text style={styles.h1}>Zoo SP</Text>
            <View
              style={{
                width: "100%",
                height: 10,
                borderRadius: 20,
                backgroundColor: "#F4892A",
              }}
            ></View>
          </View>
          <View style={styles.buttons}>
            <TouchableOpacity style={[styles.signin, styles.button]}>
              <Text style={styles.buttonText}>Criar conta</Text>
            </TouchableOpacity>
            <TouchableOpacity
              style={[styles.login, styles.button]}
              onPress={() => navigation.navigate(Login)}
            >
              <Text style={styles.buttonText}>Entrar</Text>
            </TouchableOpacity>
            <TouchableOpacity style={[styles.invited, styles.button]}>
              <Text
                style={[
                  styles.buttonText,
                  { fontFamily: "Inter-Light", color: "#F4892A" },
                ]}
              >
                Continuar como convidado
              </Text>
            </TouchableOpacity>
          </View>
        </LinearGradient>
      </ImageBackground>

      <StatusBar style="auto" />
    </View>
  );
}
