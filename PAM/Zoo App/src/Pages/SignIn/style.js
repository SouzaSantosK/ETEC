import { StyleSheet } from "react-native";

export default StyleSheet.create({
  container: {
    flex: 1,
    fontSize: "16px",
    maxWidth: 440,
  },
  linearGradient: {
    flex: 1,
    justifyContent: "flex-end",
  },
  main: {
    flex: 1,
    marginTop: 100,
    backgroundColor: "white",
    borderTopLeftRadius: 50,
    borderTopRightRadius: 50,
    padding: 30,
    justifyContent: "space-between",
  },
  header: {
    display: "flex",
    flexDirection: "column",
    gap: 10,
  },
  text: {
    fontFamily: "Inter-Regular",
    fontSize: 16,
    lineHeight: 25,
  },
  inputs: {
    gap: 10,
  },
  label: {
    fontFamily: "Inter-Bold",
    fontSize: 20,
  },
  input: {
    height: 60,
    paddingHorizontal: 30,
    borderRadius: 60,
    border: "1px solid #F4892A",
    color: "rgba(0, 0, 0, 0.2)",
    fontFamily: "Inter-Regular",
  },
  button: {
    height: 60,
    justifyContent: "center",
    alignItems: "center",
    borderRadius: 10,
    width: "100%",
    overflow: "hidden",
  },
  buttonGradient: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    width: "inherit",
  },
  buttonText: {
    fontFamily: "Inter-Bold",
    fontSize: 18,
    color: "white",
  },
});
