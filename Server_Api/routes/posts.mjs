import express from "express";
import db from "../db/conn.mjs";
import { ObjectId } from "mongodb";

const router = express.Router();

// Get a list of 50 posts
router.get("/", async (req, res) => {
  let collection = await db.collection("data");
  let results = await collection.find({})
    .limit(50)
    .toArray();

  res.send(results).status(200);
});


// Get a single post
router.get("/:id", async (req, res) => {
  let collection = await db.collection("data");
  let query = {_id: ObjectId(req.params.id)};
  let result = await collection.findOne(query);

  if (!result) res.send("Not found").status(404);
  else res.send(result).status(200);
});


// Get a posts for BOROUGH
router.get("/findByBorough/:borough", async (req, res) => {
  let collection = await db.collection("data");
  let query = { borough: req.params.borough };
  let result = await collection.find(query).limit(50).toArray();

  if (result.length === 0) {
    res.status(404).send("Not found");
  } else {
    res.status(200).send(result);
  }
});

// Get a posts for cuisine
router.get("/findByCuisine/:cuisine", async (req, res) => {
  let collection = await db.collection("data");
  let query = { cuisine: req.params.cuisine };
  let result = await collection.find(query).limit(50).toArray();

  if (result.length === 0) {
    res.status(404).send("Not found");
  } else {
    res.status(200).send(result);
  }
});

// Add a new document to the collection
router.post("/", async (req, res) => {
  let collection = await db.collection("data");
  let newDocument = req.body;
  newDocument.date = new Date();
  let result = await collection.insertOne(newDocument);
  res.send(result).status(204);
});


// Update the post with a new comment
router.patch("/comment/:id", async (req, res) => {
  const query = { _id: ObjectId(req.params.id) };
  const updates = {
    $push: { comments: req.body }
  };

  let collection = await db.collection("data");
  let result = await collection.updateOne(query, updates);

  res.send(result).status(200);
});


// Delete an entry
router.delete("/:id", async (req, res) => {
  const query = { _id: ObjectId(req.params.id) };

  const collection = db.collection("data");
  let result = await collection.deleteOne(query);

  res.send(result).status(200);
});

export default router;