import { StatusBar } from "expo-status-bar";
import { useState } from "react";
import { StyleSheet, Text, View, TouchableOpacity, Image } from "react-native";

export default function App() {
  const [frase, setFrase] = useState("");
  const [img, setImg] = useState(0);
  const frases = [
    "“É em meio a dificuldade que se encontra a oportunidade”.",
    "“O êxito é ir de frustração a frustração sem perder a animação”.",
    "“Mesmo que algo pareça difícil, nunca desista antes de tentar”.",
    "“Você é o único que entende as suas dificuldades, por isso motive se a prosseguir”.",
    "“Não é uma vida ruim, é apenas um dia ruim, lembre-se disso”.",
    "“A maior prova de que você pode fazer o impossível, é superar circunstâncias difíceis”.",
    "“Que os dias bons se tornem rotina, e os ruins se tornem raros”.",
    "“É genial celebrar a vitória, contudo é mais significativo aprender com as lições da derrota”.",
    "“Qualquer dificuldade pode ser ultrapassada, já que para todo problema há uma solução”.",
    "“Já pensou que você já superou muitas dificuldades até aqui?”.",
  ];

  function quebrarBiscoito() {
    if (img == 0) {
      let randNum = Math.floor(Math.random() * frases.length);
      setFrase(frases[randNum]);
      setImg(1);
    }
  }

  function novoBiscoito() {
    setFrase("");
    setImg(0);
  }

  function mostrarImagem(index) {
    let selectedImage =
      index == 0 ? "novoBiscoito.png" : "biscoitoQuebrado.png";
    return (
      <Image
        source={require(`./assets/${selectedImage}`)}
        style={styles.biscoito}
      />
    );
  }

  return (
    <View style={styles.container}>
      {mostrarImagem(img)}
      <Text style={styles.frase}> {frase} </Text>

      <View style={{ gap: 18 }}>
        <TouchableOpacity
          style={styles.button}
          onPress={() => quebrarBiscoito()}
        >
          <View style={styles.buttonArea}>
            <Text style={styles.buttonText}>Quebrar Biscoito</Text>
          </View>
        </TouchableOpacity>

        <TouchableOpacity style={styles.button} onPress={() => novoBiscoito()}>
          <View style={styles.buttonArea}>
            <Text style={styles.buttonText}>Novo Biscoito</Text>
          </View>
        </TouchableOpacity>
      </View>

      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: "center",
    justifyContent: "center",
    textAlign: "center",
    backgroundColor: "#EEE8DA",
  },
  biscoito: {
    width: 250,
    height: 250,
  },
  frase: {
    marginTop: 25,
    marginBottom: 25,
    fontWeight: "bold",
    fontSize: 20,
    maxWidth: 300,
    color: "#0B421A",
  },
  button: {
    paddingVertical: "0.6rem",
    paddingHorizontal: "2rem",
    borderRadius: 50,
    border: "2px solid #C5B358",
  },
  buttonText: {
    color: "#0B421A",
    fontWeight: "bold",
  },
});
