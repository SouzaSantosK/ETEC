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

import Icon from "react-native-vector-icons/FontAwesome";

export default function SignIn({ navigation }) {
  return (
    <View style={styles.container}>
      <LinearGradient
        colors={["#FF7800", "#FE9538"]}
        start={{ x: 0, y: 0.5 }}
        end={{ x: 1, y: 0.5 }}
        style={[styles.linearGradient, { position: "relative" }]}
      >
        <Icon
          name="chevron-left"
          size={20}
          color="#fff"
          style={{ position: "absolute", top: 30, left: 30 }}
        />
        <View style={styles.main}>
          <View style={styles.header}>
            <Text
              style={[styles.text, { fontSize: 24, fontFamily: "Inter-Bold" }]}
            >
              Criar uma conta
            </Text>
            <Text style={[styles.text, { color: "rgba(0, 0, 0, 0.2)" }]}>
              Cadastre-se para continuar
            </Text>
          </View>
          <View style={styles.inputs}>
            <Text style={styles.label}>Email</Text>
            <TextInput style={styles.input} placeholder="Digite seu nome" />
          </View>
          <View style={styles.inputs}>
            <Text style={styles.label}>Telefone</Text>
            <TextInput style={styles.input} placeholder="Digite seu telefone" />
          </View>
          <View style={styles.inputs}>
            <Text style={styles.label}>Senha</Text>
            <TextInput style={styles.input} placeholder="Crie uma senha" />
          </View>
          <TouchableOpacity
            style={[styles.login, styles.button]}
            onPress={() => navigation.navigate(Teste)}
          >
            <LinearGradient
              colors={["#FF5000", "#FE9538"]}
              start={{ x: 0, y: 0 }}
              end={{ x: 1, y: 1 }}
              style={styles.buttonGradient}
            >
              <Text style={styles.buttonText}>Cadastrar</Text>
            </LinearGradient>
          </TouchableOpacity>
          <TouchableOpacity
            style={{
              alignItems: "center",
              height: 35,
              justifyContent: "center",
            }}
          >
            <Text style={styles.text}>Já possui uma conta?</Text>
          </TouchableOpacity>
          <TouchableOpacity
            style={[styles.button, { border: "2px solid #F4892A" }]}
            onPress={() => navigation.navigate(Teste)}
          >
            <Text style={[styles.buttonText, { color: "#F4892A" }]}>
              Entrar
            </Text>
          </TouchableOpacity>
        </View>
      </LinearGradient>
      <StatusBar style="auto" />
    </View>
  );
}
