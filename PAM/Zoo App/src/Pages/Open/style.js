import { StyleSheet } from "react-native";

export default StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#101010",
    fontSize: "16px",
    maxWidth: 440,
  },
  backgroundImage: {
    flex: 1,
  },
  linearGradient: {
    flex: 1,
    display: "flex",
    justifyContent: "flex-end",
    padding: 30,
  },
  header: {
    flex: 1,
    display: "flex",
    justifyContent: "center",
  },
  headerP: {
    fontSize: 35,
    fontFamily: "Inter-Bold",
    color: "#F4892A",
    textTransform: "uppercase",
  },
  h1: {
    fontSize: 80,
    textTransform: "uppercase",
    color: "#fff",
    fontFamily: "Inter-Bold",
  },
  buttons: {
    display: "flex",
    rowGap: 20,
    flex: 1,
    justifyContent: "flex-end",
  },
  button: {
    height: 60,
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
    borderRadius: 10,
  },
  signin: {
    backgroundColor: "#F4892A",
  },
  login: {
    border: "2px solid #F4892A",
  },
  buttonText: {
    color: "#fff",
    fontFamily: "Inter-Bold",
    fontSize: 18,
  },
});
