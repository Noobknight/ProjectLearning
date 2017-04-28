var express = require("express");
var path = require("path");
var mysql = require("mysql");
var bodyParser = require("body-parser");
var route = require("./routes/route.js");
var app = express();
app.use(express.static(path.join(__dirname, "public")));
app.use('/image',express.static(path.join(__dirname, 'public/images')));

function Server() {
  var self = this;
  self.connectionSql();
}

Server.prototype.connectionSql = function () {
  var self = this;
  var pool = mysql.createPool({
    connectionLimit: 100,
    host: "localhost",
    database: "productsell",
    user: "root",
    password: ""
  });
  pool.getConnection(function (err, connection) {
    if (err) {
      self.stop();
    } else {
      self.configurationDb(connection);
    }
  });
}

Server.prototype.configurationDb = function (connection) {
  var self = this;
  app.use(bodyParser.urlencoded({ extended: false }));
  //app.use(bodyParser.urlencoded());
  // app.use(bodyParser.json({ type: 'application/*+json' }));
  //app.use(bodyParser.json());
  app.use(function (req, res, next) {
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE,OPTIONS');
    res.header('Access-Control-Allow-Headers', 'X-Requested-With, X-HTTP-Method-Override, Content-Type, Accept');
    next();
  });
  var router = express.Router();
  app.use("/api", router);
  var restRouter = new route(router, connection);
  self.startServer();
}

Server.prototype.startServer = function () {
  app.listen(8070, function () {
    console.log("All right! I am alive at port 8070");
  })
}

Server.prototype.stop = function (error) {
  console.log("Issue with Mysql " + error);
  process.exit(1);
}

new Server();
module.exports = app;