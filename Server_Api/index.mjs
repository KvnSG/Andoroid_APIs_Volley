import express from "express";
import cors from "cors";
import "./loadEnvironment.mjs";
import "express-async-errors";
import posts from "./routes/posts.mjs";

const PORT = process.env.PORT || 8000;
const app = express();

app.use(cors());
app.use(express.json());

// Load the /posts routes
app.use("/posts", posts);


app.use((err, _req, res, next) => {
  res.status(500).send("Fail connection")
})


app.listen(PORT, () => {
  console.log(`Server is running on port: ${PORT}`);
});
