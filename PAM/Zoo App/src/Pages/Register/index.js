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

import { SafeAreaView } from "react-native-safe-area-context";
import { useState } from "react";
import Open from "../Open";
import Icon from "react-native-vector-icons/AntDesign";

export default function Register({ navigation }) {
  return (
    <SafeAreaView style={styles.container}>
      <ImageBackground
        source={require("../../images/araraAzul.png")}
        resizeMode="cover"
        style={styles.backgroundImage}
      >
        <LinearGradient
          colors={["rgba(0, 0, 0, 0.3)", "rgba(0, 0, 0, 1)"]}
          style={styles.linearGradient}
        >
          <View style={styles.header}>
            <Icon
              name="arrowleft"
              size={35}
              color="#FF6347"
              style={{ marginBottom: 20 }}
              onPress={() => navigation.navigate(Open)}
            />
            <Text style={styles.headerP}>Faça seu </Text>
            <Text style={[styles.headerP, { color: "white", fontSize: 40 }]}>
              Seu Login
            </Text>
          </View>
          <View style={styles.form}>
            <View>
              <Text style={styles.label}>Nome</Text>
              <TextInput style={styles.input} placeholder="Digite seu nome" />
            </View>
            <View>
              <Text style={styles.label}>Email</Text>
              <TextInput style={styles.input} placeholder="Digite seu email" />
            </View>
            <View>
              <Text style={styles.label}>Senha</Text>
              <TextInput
                style={styles.input}
                // onChangeText={onChangeText}
                // value={text}
                placeholder="Digite sua senha"
              />
            </View>
          </View>
          <View style={styles.buttons}>
            <TouchableOpacity
              style={styles.button}
              onPress={() => navigation.navigate(Teste)}
            >
              <Text style={styles.buttonText}>Cadastrar</Text>
            </TouchableOpacity>

            <TouchableOpacity
              style={styles.button}
              onPress={() => navigation.navigate(Login)}
            >
              <Text
                style={[
                  styles.buttonText,
                  {
                    fontFamily: "Inter-Light",
                    color: "white",
                    textAlign: "center",
                    fontSize: 16,
                  },
                ]}
              >
                Já possui uma conta? Faça Login
              </Text>
            </TouchableOpacity>
          </View>
        </LinearGradient>
      </ImageBackground>
      <StatusBar style="auto" />
    </SafeAreaView>
  );
}
