import { StatusBar } from "expo-status-bar";
import { Text, View, Image } from "react-native";
import { LinearGradient } from "expo-linear-gradient";
import ProgressBar from "react-native-progress/Bar";

import styles from "./style";
import { useState } from "react";

export default function Splash({ navigation }) {
  return (
    <View style={styles.container}>
      <LinearGradient
        colors={["rgba(0, 0, 0, 0.3)", "rgba(246, 134, 35, 0.2)"]}
        style={styles.linearGradient}
        locations={[0.7, 1]}
      >
        <Image style={styles.logo} source={require("../../images/logo.png")} />
        {/* <ProgressBar progress={0} width={200} height={20} /> */}
      </LinearGradient>

      <StatusBar style="auto" />
    </View>
  );
}
