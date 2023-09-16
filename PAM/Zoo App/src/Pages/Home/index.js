import { StatusBar } from "expo-status-bar";
import { Text, View } from "react-native";
import { SafeAreaView } from "react-native-safe-area-context";
import styles from "./style";

export default function Home({ navigation }) {
  return (
    <SafeAreaView style={styles.container}>
      <View style={styles.header}>
        <View style={styles.user}></View>
      </View>
      <View style={styles.main}></View>
    </SafeAreaView>
  );
}
