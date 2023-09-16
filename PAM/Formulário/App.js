import { StatusBar } from "expo-status-bar";
import { useState } from "react";
import {
  Image,
  StyleSheet,
  Text,
  TextInput,
  View,
  CheckBox,
  Picker,
} from "react-native";

export default function App() {
  const [nome, setNome] = useState("");
  const [telefone, setTelefone] = useState("");
  const [endereco, setEndereco] = useState("");
  const [email, setEmail] = useState("");
  const [competencia, setCompetencia] = useState("");
  const [aceitoTermos, setAceitoTermos] = useState(false);

  return (
    <View style={styles.body}>
      <View style={styles.formWrapper}>
        <Image
          style={styles.userImage}
          source={require("./assets/pica-pau.jpg")}
        />

        <View style={[styles.mainView, { marginVertical: 15 }]}>
          <Text style={styles.mainTitle}>Dados Pessoais </Text>
          <TextInput
            style={styles.input}
            placeholder="Digite seu Nome"
            onChangeText={(text) => setNome(text)}
          />
          <TextInput
            style={styles.input}
            placeholder="Digite seu Telefone"
            keyboardType="numeric"
            onChangeText={(text) => setTelefone(text)}
          />
          <TextInput
            style={styles.input}
            placeholder="Digite seu Endereço"
            onChangeText={(text) => setEndereco(text)}
          />
          <TextInput
            style={styles.input}
            placeholder="Digite seu E-mail"
            onChangeText={(text) => setEmail(text)}
          />
        </View>

        <View style={styles.mainView}>
          <Text style={styles.mainTitle}>Competências </Text>
          <Picker
            style={[styles.input, { padding: 5 }]}
            onValueChange={(itemValue) => setCompetencia(itemValue)}
          >
            <Picker.Item label="Selecione uma linguagem" value="" />
            <Picker.Item label="JavaScript" value="Javascript" />
            <Picker.Item label="Java" value="Java" />
            <Picker.Item label="PHP" value="PHP" />
            <Picker.Item label="React Native" value="React Native" />
            <Picker.Item label="React" value="React" />
            <Picker.Item label="HTML 5" value="Html" />
            <Picker.Item label="CSS 3" value="Css" />
            <Picker.Item label="Node.js" value="Node.js" />
          </Picker>
          <View
            style={{
              display: "flex",
              flexDirection: "row",
              alignItems: "center",
              gap: 5,
            }}
          >
            <CheckBox
              value={aceitoTermos}
              onValueChange={setAceitoTermos}
              color={aceitoTermos ? "#1ed760" : undefined}
            />
            <Text>Aceita os termos de Serviço</Text>
          </View>
        </View>

        <View style={[styles.mainView, { gap: 5 }]}>
          <Text style={styles.formInputs}>Nome: {nome} </Text>
          <Text style={styles.formInputs}>Telefone: {telefone} </Text>
          <Text style={styles.formInputs}>Endereço: {endereco}</Text>
          <Text style={styles.formInputs}>Email: {email}</Text>
          <Text style={styles.formInputs}>Competência: {competencia} </Text>
          <Text style={styles.formInputs}>
            Aceito: {aceitoTermos ? "👍😎" : "👎😢"}
          </Text>
        </View>
      </View>
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  body: {
    display: "flex",
    alignItems: "center",
    width: "100%",
    overflow: "hidden",
    backgroundColor: "#191414",
  },
  userImage: {
    width: 150,
    height: 150,
    borderRadius: "50%",
    border: "2.5px solid #1ed760",
  },
  formWrapper: {
    flex: 1,
    backgroundColor: "inherit",
    alignItems: "center",
    justifyContent: "center",
    padding: 50,
    minWidth: 400,
    maxWidth: 500,
  },
  mainView: {
    border: "2.5px solid #1ed760",
    borderRadius: 10,
    padding: 10,
    width: "100%",
    marginVertical: 8,
    backgroundColor: "white",
  },
  mainTitle: {
    fontSize: 18,
  },
  input: {
    marginVertical: 5,
    padding: 10,
    border: "1px solid #191414",
  },
  formInputs: {
    fontSize: 15,
    marginVertical: 3,
  },
});
