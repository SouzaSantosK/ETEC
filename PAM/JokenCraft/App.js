import { StatusBar } from "expo-status-bar";
import { useState } from "react";
import {
  StyleSheet,
  Text,
  View,
  TouchableOpacity,
  Image,
  ImageBackground,
} from "react-native";
import { useFonts } from "expo-font";

export default function App() {
  const [loaded] = useFonts({
    Minecraftia: require("./assets/fonts/Minecraftia-Regular.ttf"),
  });

  const optionsImages = ["Pedra.png", "Papel.png", "Tesoura.png"];
  const adversaries = [
    "Herobrine.png",
    "Skeleton.png",
    "Warden.gif",
    "Zombie.png",
    "Creeper.png",
    "Alex.png",
  ];

  const [playerPoints, setPlayerPoints] = useState(0);
  const [botPoints, setBotPoints] = useState(0);
  const [botImg, setBotImg] = useState("Alex.png");
  const [playerChoiceImg, setPlayerChoiceImg] = useState("bedrock.png");
  const [botChoiceImg, setBotChoiceImg] = useState("bedrock.png");
  const [result, setResult] = useState("");

  function jogar(playerOption) {
    let botOption = Math.floor(Math.random() * 3);
    setPlayerChoiceImg(optionsImages[playerOption]);
    setBotChoiceImg(optionsImages[botOption]);

    if (
      (playerOption == 0 && botOption == 0) ||
      (playerOption == 1 && botOption == 1) ||
      (playerOption == 2 && botOption == 2)
    ) {
      setResult("E m p a t e !");
    } else if (
      (playerOption == 0 && botOption == 2) ||
      (playerOption == 1 && botOption == 0) ||
      (playerOption == 2 && botOption == 1)
    ) {
      setResult("O  P l a y e r  G a n h o u !");
      setPlayerPoints(playerPoints + 1);
      let adversariesIndex = Math.floor(Math.random() * adversaries.length);
      setBotImg(adversaries[adversariesIndex]);
    } else {
      setResult("O  B o t  G a n h o u !");
      setBotPoints(botPoints + 1);
    }
  }

  function novaPartida() {
    setPlayerPoints(0);
    setBotPoints(0);
    setResult("");
    setPlayerChoiceImg("bedrock.png");
    setBotChoiceImg("bedrock.png");
    setBotImg("Alex.png");
  }

  return (
    <View style={styles.body}>
      <View style={styles.main}>
        <Text style={styles.title}>Jo Ken Pô</Text>

        <View style={styles.placar}>
          <Text style={styles.subtitle}>Placar</Text>
          <View style={styles.result}>
            <Image
              source={require(`./assets/Minecraft/${playerChoiceImg}`)}
              style={styles.jogadorOpcao}
            ></Image>
            <Text
              style={{
                flex: 2,
                display: "flex",
                alignItems: "center",
                justifyContent: "center",
              }}
            >
              {result}
            </Text>
            <Image
              source={require(`./assets/Minecraft/${botChoiceImg}`)}
              style={styles.jogadorOpcao}
            ></Image>
          </View>
          <View style={styles.pontuacoes}>
            <Text style={styles.pontos}>{playerPoints}</Text>
            <Text style={styles.pontos}>{botPoints}</Text>
          </View>
        </View>

        <View style={styles.adversarios}>
          <Image
            source={require(`./assets/Minecraft/Steve.png`)}
            style={styles.jogador}
          />
          <Image
            source={require("./assets/Minecraft/VS.png")}
            style={styles.vs}
          />
          <Image
            source={require(`./assets/Minecraft/${botImg}`)}
            style={styles.oponente}
          />
        </View>

        <View style={{ flex: 1, alignItems: "center" }}>
          <ImageBackground
            source={require("./assets/Minecraft/button.png")}
            style={styles.buttonBackground}
          >
            <TouchableOpacity
              style={styles.botao}
              onPress={() => {
                novaPartida();
              }}
            >
              <Text style={styles.buttonText}>Nova Partida</Text>
            </TouchableOpacity>
          </ImageBackground>
        </View>

        <View style={styles.jogadas}>
          <TouchableOpacity style={styles.jogada} onPress={() => jogar(0)}>
            <Image
              source={require("./assets/Minecraft/Pedra.png")}
              style={styles.opcao}
            />
          </TouchableOpacity>
          <TouchableOpacity style={styles.jogada} onPress={() => jogar(1)}>
            <Image
              source={require("./assets/Minecraft/Papel.png")}
              style={styles.opcao}
            />
          </TouchableOpacity>

          <TouchableOpacity style={styles.jogada} onPress={() => jogar(2)}>
            <Image
              source={require("./assets/Minecraft/Tesoura.png")}
              style={styles.opcao}
            />
          </TouchableOpacity>
        </View>
      </View>
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  body: {
    flex: 1,
    alignItems: "center",
    justifyContent: "center",
    textAlign: "center",
  },
  main: {
    flex: 1,
    width: 375,
  },
  title: {
    fontSize: 30,
    paddingVertical: 15,
  },
  placar: {
    justifyContent: "space-between",
  },
  subtitle: {
    fontSize: 22,
    flex: 1,
  },
  result: {
    flex: 1,
    flexDirection: "row",
  },
  jogadorOpcao: {
    resizeMode: "contain",
    height: 70,
    flex: 1,
  },
  pontuacoes: {
    flex: 1,
    flexDirection: "row",
    width: "100%",
    justifyContent: "space-around",
  },
  pontos: {
    fontWeight: 700,
    fontFamily: "Minecraftia",
    fontSize: "1.6rem",
  },
  adversarios: {
    flex: 3,
    flexDirection: "row",
    gap: 50,
  },
  jogador: {
    flex: 1,
    resizeMode: "contain",
    transform: "scaleX(-1)",
  },
  vs: {
    flex: 1,
    resizeMode: "contain",
  },
  oponente: {
    flex: 1,
    resizeMode: "contain",
  },
  botao: {
    border: "2px solid #000",
    justifyContent: "center",
    alignItems: "center",
    // rgba(100, 100, 255, .45)
  },
  buttonText: {
    // FFFFA0
    color: "#d0d0d0",
    textShadow: "2px 2px #000A",
    boxShadow: "inset -2px -4px #0006, inset 2px 2px #FFF7",
    paddingHorizontal: 45,
    fontSize: "12pt",
    fontFamily: "Minecraftia",
    lineHeight: 25,
    paddingTop: 10,
  },
  jogadas: {
    flex: 1,
    flexDirection: "row",
    gap: 5,
  },
  jogada: {
    flex: 1,
  },
  opcao: {
    width: "100%",
    height: "100%",
    resizeMode: "contain",
  },
});
